public class MaxLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int n1=nums1.length;
        int n2=nums2.length;

        int[][]dp = new int[n1+1][n2+1];
        int ans=0;
        for(int i=1;i<n1+1;i++){
            for(int j=1;j<n2+1;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
