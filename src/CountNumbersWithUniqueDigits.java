import java.util.Arrays;

public class CountNumbersWithUniqueDigits {

    public int countNumbersWithUniqueDigits(int n) {
        int a= (int) Math.pow(10,n);
        char[] cn= String.valueOf(a).toCharArray();
        Integer[][][][]dp= new Integer[8][2][1024][2];

        int ans=solve(0,true,0,false,cn,dp);
        return ans;
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
                // still leading zero → don't mark digit used
                count += solve(i + 1, newTight, mask, false, n, dp);
            } else {
                // check if digit already used
                if ((mask & (1 << d)) == 0) {
                    count += solve(i + 1, newTight, mask | (1 << d), true, n, dp);
                }
            }
        }

        return dp[i][tight ? 1 : 0][mask][started ? 1 : 0] = count;
    }
    public static void main(String[] args) {
        CountNumbersWithUniqueDigits soln= new CountNumbersWithUniqueDigits();

        System.out.println(soln.countNumbersWithUniqueDigits(2));


    }
}
