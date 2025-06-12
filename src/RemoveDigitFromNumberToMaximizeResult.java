import java.math.BigInteger;
import java.util.Collections;
import java.util.PriorityQueue;

public class RemoveDigitFromNumberToMaximizeResult {

    public String removeDigit(String number, char digit) {

        StringBuilder data = new StringBuilder(number);
        for (int i = 0; i < number.length() - 1; i++) {
            if (number.charAt(i) == digit && number.charAt(i + 1) > digit) {
                data.deleteCharAt(i);
                return data.toString();
            }
        }
        for (int i = number.length() - 1; i >= 0; i--) {
            if (number.charAt(i) == digit) {
                data.deleteCharAt(i);
                break;
            }
        }
            return data.toString();



    }

    public static void main(String[] args) {
        RemoveDigitFromNumberToMaximizeResult soln= new RemoveDigitFromNumberToMaximizeResult();
        System.out.println(soln.removeDigit("1233",'3'));
    }
}
