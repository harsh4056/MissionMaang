import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestIncreasingSubsequence {



    public int lengthOfLIS(int[] nums) {

        int[][]dp = new int[nums.length][nums.length];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }


        dp[0][0]=0;
        for (int i=0;i<nums.length;i++){

            for (int j = 0; j < nums.length; j++) {
                //dp[i][j]= 1+Math.max()
            }
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

    public int lengthOfLIS2(int[] nums) {

        int n= nums.length;
        int[] arr= new int[n];
        int r=0;
        arr[0]=nums[0];
        for (int i = 1; i < arr.length; i++) {
           if(nums[i]>arr[r]){
               arr[++r]=nums[i];
           }
           else{
            int index=   lowerBound(arr,r,nums[i]);
            arr[index]=nums[i];
           }

        }
        return r+1;



    }
    public int lowerBound(int []nums,int r,int target){
        int l=0;
        while(l<r){
            int mid=l+(r-l)/2;
            if(nums[mid]>=target){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence= new LongestIncreasingSubsequence();
        System.out.println(
        longestIncreasingSubsequence.lengthOfLIS2(new int[]{10,9,2,5,3,7,101,18}));
    }
}
