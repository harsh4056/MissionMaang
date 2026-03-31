public class NumbersWithRepeatedDigits {

    public int numDupDigitsAtMostN(int n) {
        char[]cn=String.valueOf(n).toCharArray();
        Integer[][][][] dp= new Integer[10][2][1024][2];
        int ans=solve(0,true,0,false,cn,dp);
        return n+1-ans;


    }

    public int solve(int i, boolean tight, int mask, boolean started, char[] n, Integer[][][][] dp) {
        if (i == n.length) return 1;

        if (dp[i][tight ? 1 : 0][mask][started ? 1 : 0] != null)
            return dp[i][tight ? 1 : 0][mask][started ? 1 : 0];

        int limit = tight ? n[i] - '0' : 9;
        int count = 0;

        for (int d = 0; d <= limit; d++) {
            boolean newTight = tight && (d == limit);

            if (!started && d == 0) {

                count += solve(i + 1, newTight, mask, false, n, dp);
            } else {

                if ((mask & (1 << d)) == 0) {
                    count += solve(i + 1, newTight, mask | (1 << d), true, n, dp);
                }
            }
        }

        return dp[i][tight ? 1 : 0][mask][started ? 1 : 0] = count;
    }

    public static void main(String[] args) {
        NumbersWithRepeatedDigits soln= new NumbersWithRepeatedDigits();
        System.out.println(soln.numDupDigitsAtMostN(20));
        System.out.println(soln.numDupDigitsAtMostN(100));
        System.out.println(soln.numDupDigitsAtMostN(1000));
    }

    /*
    * Example 1:

            Input: n = 20
            Output: 1
            Explanation: The only positive number (<= 20) with at least 1 repeated digit is 11.
            Example 2:

            Input: n = 100
            Output: 10
            Explanation: The positive numbers (<= 100) with atleast 1
            * repeated digit are 11, 22, 33, 44, 55, 66, 77, 88, 99, and 100.
            Example 3:

            Input: n = 1000
            Output: 262
    * */
}
