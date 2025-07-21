import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestIncreasingSubsequence {



    public int lengthOfLIS(int[] nums) {

        int[][]dp = new int[nums.length][nums.length];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        findLongest(nums,0,-1,dp);
        return dp[0][0];
    }
    public int findLongest(int []nums,int index,int prevIndex,int[][]dp){
        if(index==nums.length){
            return 0;
        }
        if(dp[index][prevIndex+1]!=-1)return dp[index][prevIndex+1];

        int take=0;
        if(prevIndex==-1 || nums[index]>nums[prevIndex]) {
            take = 1 + findLongest(nums, index + 1, index, dp);
        }

           int notTake=findLongest(nums, index + 1, prevIndex, dp);

        dp[index][prevIndex+1]=Math.max(take,notTake);
        return Math.max(take,notTake);


    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence= new LongestIncreasingSubsequence();
        System.out.println(
        longestIncreasingSubsequence.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
