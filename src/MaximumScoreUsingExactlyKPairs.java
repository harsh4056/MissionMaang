import java.util.Arrays;

public class MaximumScoreUsingExactlyKPairs {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        long[][][]dp= new long[nums1.length+1][nums2.length+1][k+1];
        for (long[][] longs : dp) {
            for (long[] aLong : longs) {
                Arrays.fill(aLong,-1);
            }
        }
        long ans=solve(nums1,nums2,0,0,k,dp);

        return ans;
    }
    public long solve(int[] nums1, int[] nums2, int i1, int i2, int k, long[][][] dp){
        if(k==0){
            return 0;
        }
        if(i1>= nums1.length || i2>= nums2.length ){
            return (long) -1e14;
        }
        if(dp[i1][i2][k]!=-1) return dp[i1][i2][k];
        long take= ((long) nums1[i1] *nums2[i2])+solve(nums1,nums2,i1+1,i2+1,k-1, dp);
        long skip1=solve(nums1,nums2,i1,i2+1,k, dp);
        long skip2=solve(nums1,nums2,i1+1,i2,k, dp);
        return dp[i1][i2][k]=Math.max(take,Math.max(skip1,skip2));

    }

    public long maxScore2(int[] nums1, int[] nums2, int k) {

        int n = nums1.length;
        int m = nums2.length;

        long NEG = -(long)1e14;

        long[][][] dp = new long[n+1][m+1][k+1];

        // Initialize impossible states
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                for(int kk = 1; kk <= k; kk++){
                    dp[i][j][kk] = NEG;
                }
            }
        }

        // Base case: k == 0
        for(int i = 0; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[i][j][0] = 0;
            }
        }

        // Fill table bottom-up
        for(int i = n-1; i >= 0; i--){
            for(int j = m-1; j >= 0; j--){
                for(int kk = 1; kk <= k; kk++){

                    long take = nums1[i] * 1L * nums2[j]
                            + dp[i+1][j+1][kk-1];

                    long skip1 = dp[i][j+1][kk];
                    long skip2 = dp[i+1][j][kk];

                    dp[i][j][kk] = Math.max(take, Math.max(skip1, skip2));
                }
            }
        }

        return dp[0][0][k];
    }


    public static void main(String[] args) {
        MaximumScoreUsingExactlyKPairs obj = new MaximumScoreUsingExactlyKPairs();

        int[] nums1_3 = {-3, -2};
        int[] nums2_3 = {1, 2};
        int k3 = 2;
        System.out.println(obj.maxScore2(nums1_3, nums2_3, k3)); // Expected: -7

        int[] nums1_1 = {1, 3, 2};
        int[] nums2_1 = {4, 5, 1};
        int k1 = 2;
        System.out.println(obj.maxScore2(nums1_1, nums2_1, k1)); // Expected: 22

        int[] nums1_2 = {-2, 0, 5};
        int[] nums2_2 = {-3, 4, -1, 2};
        int k2 = 2;
        System.out.println(obj.maxScore2(nums1_2, nums2_2, k2)); // Expected: 26


    }

}
