import java.util.Arrays;

public class HouseRobberV {

    public long rob(int[] nums, int[] colors) {

        long[]dp= new long[nums.length+2];

        int n=colors.length;
        for(int i=n-1;i>=0;i--){
            long take=0;
            if(i+1<nums.length && colors[i]!=colors[i+1]){
                take=nums[i]+dp[i+1];
            }
            else {
                take=nums[i]+dp[i+2];
            }
            long skip=dp[i+1];
             dp[i]=Math.max(take,skip);
        }

        return dp[0];
    }
    public long solve(int[] nums, int[] colors, int i, long[] dp){
        if(i>=nums.length) return 0;
        long take=0;
        if(dp[i]!=-1) return dp[i];
        if(i+1<nums.length && colors[i]!=colors[i+1]){
            take=nums[i]+solve(nums,colors,i+1, dp);
        }
        else {
            take=nums[i]+solve(nums,colors,i+2, dp);
        }
        long skip=solve(nums,colors,i+1, dp);
        return dp[i]=Math.max(take,skip);
    }
    public static void main(String[] args) {
        HouseRobberV obj = new HouseRobberV();

        // Example 1
        int[] nums1 = {1, 4, 3, 5};
        int[] colors1 = {1, 1, 2, 2};
        System.out.println(obj.rob(nums1, colors1));
        // Expected: 9

        // Example 2
        int[] nums2 = {3, 1, 2, 4};
        int[] colors2 = {2, 3, 2, 2};
        System.out.println(obj.rob(nums2, colors2));
        // Expected: 8

        // Example 3
        int[] nums3 = {10, 1, 3, 9};
        int[] colors3 = {1, 1, 1, 2};
        System.out.println(obj.rob(nums3, colors3));
        // Expected: 22
    }


}
