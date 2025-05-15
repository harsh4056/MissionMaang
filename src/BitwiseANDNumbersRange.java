import java.util.*;

public class BitwiseANDNumbersRange {

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left << shift;

    }


    public static void main(String[] args) {
        BitwiseANDNumbersRange bitwiseANDNumbersRange= new BitwiseANDNumbersRange();
        System.out.println( bitwiseANDNumbersRange.rangeBitwiseAnd(1073741825 ,2147483647 ));

    }
}
