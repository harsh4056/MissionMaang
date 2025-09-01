import java.util.*;

public class FourKeysKeyboard {
    static long findMaxAs(int n) {
        long[] dp = new long[n+1];
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;

        if (n <= 3) return n;

        for(int i=4;i<=n;i++){
            int count=i-3;
         for(int j=1;j<=i-3;j++){
             dp[i]=Math.max(dp[i],(dp[j]*count)+dp[j]);
             count--;
         }
            dp[i]=Math.max(dp[i],4);

        }
       return dp[n];

    }

    public static void main(String[] args) {
        // Test case 1
       // System.out.println(FourKeysKeyboard.findMaxAs(3));
        // Expected: 3 (just pressing 'A' three times)

        // Test case 2
        System.out.println(FourKeysKeyboard.findMaxAs(7));
        // Expected: 9 (optimal sequence: A A A Ctrl+A Ctrl+C Ctrl+V Ctrl+V)

        // Test case 3
        System.out.println(FourKeysKeyboard.findMaxAs(9));
        // Expected: 16 (optimal sequence: A A A Ctrl+A Ctrl+C Ctrl+V Ctrl+V Ctrl+V Ctrl+V)
        // Test case 3
        System.out.println(FourKeysKeyboard.findMaxAs(150));
        // Expected: 27
    }

}
