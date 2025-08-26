import java.util.*;

public class HappyNumber {
    public static boolean isHappy(int n) {

        int x = 0;
        HashSet<Integer> set = new HashSet<>();
        while ( !set.contains(n)) {
            set.add(n);
            while (n > 0) {
                int rem = n % 10;
                n = n / 10;
                x =x+ rem * rem;
            }
            n=x;
            x=0;
            if (n == 1)
                return true;

        }
        return false;
    }



    public static void main(String[] args) {
        System.out.println(HappyNumber.isHappy(19));
    }
}
