public class MaximumSumSubArray {

    public int maxSubArray(int[] nums) {
        int maxSum=nums[0];
        int currentSum=nums[0];

        for (int i = 1; i < nums.length; i++) {

            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);

        }

        return maxSum;

    }



    public static void main(String[] args) {
        MaximumSumSubArray maximumSumSubArray= new MaximumSumSubArray();
        System.out.println(
        maximumSumSubArray.maxSubArray(new int[]{5,-3,5}));
    }
}
