public class NumbersAtMostNGivenDigitSet {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        int mask = 0;
        for (String digit : digits) {
            int d = Integer.parseInt(digit);
            mask |= 1 << d;
        }
        Integer[][][][] dp = new Integer[10][2][2][2];
        char[] cn = String.valueOf(n).toCharArray();
        int ans = solve(0, true, false, 0, mask, cn, dp);
        return ans;
    }

    public int solve(int index, boolean tight, boolean started, int cnt, int mask, char[] cn, Integer[][][][] dp) {
        if (index == cn.length) {
            return cnt;
        }
        if (dp[index][tight ? 1 : 0][started ? 1 : 0][cnt] != null)
            return dp[index][tight ? 1 : 0][started ? 1 : 0][cnt];
        int limit = tight ? cn[index] - '0' : 9;
        int count = 0;
        for (int d = 0; d <= limit; d++) {
            boolean newTight = tight && (d == limit);
            boolean allowed = (((1 << d) & mask) != 0);
            int updateCnt = index == cn.length - 1 && allowed ? 1 : 0;

            if (!started && d == 0) {
                count += solve(index + 1, newTight, false, updateCnt, mask, cn, dp);
            } else {
                if (allowed)
                    count += solve(index + 1, newTight, true, updateCnt, mask, cn, dp);
            }
        }
        return dp[index][tight ? 1 : 0][started ? 1 : 0][cnt] = count;
    }


    public static void main(String[] args) {
        NumbersAtMostNGivenDigitSet soln= new NumbersAtMostNGivenDigitSet();
        System.out.println(soln.atMostNGivenDigitSet(new String[]{"1","3","5","7"},10));
    }
}
