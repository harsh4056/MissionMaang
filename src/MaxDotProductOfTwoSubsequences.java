import java.util.Arrays;

public class MaxDotProductOfTwoSubsequences {
    //Input: nums1 = [2,1,-2,5], nums2 = [3,0,-6]
    //Output: 18

    public int maxDotProduct(int[] nums1, int[] nums2) {

        int[][]dp =new int[nums1.length+1][nums2.length+1];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        int ans= solve(nums1,nums2,0,0,dp);
        return ans;
    }

    public int solve(int []nums1, int []nums2, int i1, int i2, int[][] dp){

        if(i1==nums1.length || i2== nums2.length) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        int take =nums1[i1]*nums2[i2]+solve(nums1,nums2,i1+1,i2+1, dp);
        int skip1= solve(nums1,nums2,i1+1,i2, dp);
        int skip2= solve(nums1,nums2,i1,i2+1, dp);
        return dp[i1][i2]= Math.max(skip2,Math.max(take,skip1));
    }



    public int maxDotProduct2(int[] nums1, int[] nums2) {

        int[][]dp =new int[nums1.length+1][nums2.length+1];
        int maxi=Integer.MIN_VALUE;
        for (int k : nums1) {
            for (int j = 0; j < nums2.length; j++) {
                maxi = Math.max(maxi, k * nums2[j]);
            }

        }
        dp[nums1.length][nums2.length]=0;
        for(int i1=nums1.length-1;i1>=0;i1--){
            for (int i2 = nums2.length-1; i2 >=0; i2--) {
                int take =nums1[i1]*nums2[i2]+dp[i1+1][i2+1];
                int skip1=  dp[i1+1][i2];
                int skip2=  dp[i1][i2+1];
                dp[i1][i2]= Math.max(skip2,Math.max(take,skip1));
            }
        }
        if(dp[0][0]==0) return maxi;

        return dp[0][0];
    }

    public static void main(String[] args) {
        MaxDotProductOfTwoSubsequences obj = new MaxDotProductOfTwoSubsequences();
/*
        // Test case 1
        int[] nums1a = {2, 1, -2, 5};
        int[] nums2a = {3, 0, -6};
        System.out.println(obj.maxDotProduct2(nums1a, nums2a));
        // Expected output: 18

        // Test case 2
        int[] nums1b = {3, -2};
        int[] nums2b = {2, -6, 7};
        System.out.println(obj.maxDotProduct2(nums1b, nums2b));
        // Expected output: 21
*/

        // Test case 3
        int[] nums1c = {-1, -1};
        int[] nums2c = {-2, 1};
        System.out.println(obj.maxDotProduct2(nums1c, nums2c));
        // Expected output: 0
    }

}
