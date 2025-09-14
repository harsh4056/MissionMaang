import java.util.Arrays;

public class NumberOfStableSubsequences {
    static final int MOD = 1_000_000_007;

    public int countStableSubsequences(int[] nums) {
        int n = nums.length;
        int[][][] dp = new int[n][3][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int totalInvalid = totalInvalid(nums, 0, 0, 2, dp);
        int total = (int) ((modPow(2, n, MOD) - 1 + MOD) % MOD);

        return (total - totalInvalid + MOD) % MOD;
    }

    private int totalInvalid(int[] nums, int index, int count, int parity, int[][][] dp) {
        if (count == 3) {
            int rem = nums.length - index;
            return (int) modPow(2, rem, MOD);
        }
        if (index == nums.length) return 0;
        if (dp[index][count][parity] != -1) return dp[index][count][parity];

        int currParity = nums[index] % 2;

        long take, dontTake;
        if (parity == 2) {
            take = totalInvalid(nums, index + 1, 1, currParity, dp);
        } else if (currParity == parity) {
            take = totalInvalid(nums, index + 1, count + 1, currParity, dp);
        } else {
            take = totalInvalid(nums, index + 1, 1, currParity, dp);
        }

        dontTake = totalInvalid(nums, index + 1, count, parity, dp);

        return dp[index][count][parity] = (int) ((take + dontTake) % MOD);
    }

    private long modPow(long base, int exp, int mod) {
        long res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) res = (res * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        NumberOfStableSubsequences sol = new NumberOfStableSubsequences();

        int[] nums1 = {2,3,4,2};
        //System.out.println(sol.countStableSubsequences(nums1));
        //14

        int[] nums2 = {131,665,498,951,892,779,764,507,725,491,346,772,618,347,675,877,394,277,791,445,949,903,855,220,396,934,790,229,379,956,589,234};
        //System.out.println(sol.countStableSubsequences(nums2));
        // 189985863

        int[] nums3 = {91,139,520,113,596,81,501,19,600,556,43,659,169,558,347,743,446,52,364,199,424,903,398,760,347,453,492,577,107,642};
        System.out.println(sol.countStableSubsequences(nums3));
        // 154259833
    }

}
