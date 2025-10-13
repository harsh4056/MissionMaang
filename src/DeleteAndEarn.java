import java.util.Arrays;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length + 1];
        Arrays.fill(dp, -1);
        int max= getMax(nums, 0, -2, dp);
        return max;
    }

    public int getMax(int[] nums, int index, int prev, int[] dp) {
        if (index >= nums.length)
            return 0;
        if (dp[index] != -1)
            return dp[index];
        int take;
        if (prev + 1 != nums[index]) {
            take = nums[index] + getMax(nums, index + 1, nums[index], dp);
        } else {
            take = getMax(nums, index + 1, prev, dp);
        }
        int dontTake = getMax(nums, index + 1, -2, dp);
        int max = Math.max(take, dontTake);
        dp[index]=Math.max(dp[index],max);
        return dp[index];

    }

    public static void main(String[] args) {
        DeleteAndEarn soln= new DeleteAndEarn();

        System.out.println(soln.deleteAndEarn(new int[]{2,3}));
    }
}
