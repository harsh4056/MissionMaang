public class MaximumSumCircularSubarray {

    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int minSum = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        int totalSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            maxSum = Math.max(maxSum, currentMax);

            currentMin = Math.min(nums[i], currentMin + nums[i]);
            minSum = Math.min(minSum, currentMin);

            totalSum += nums[i];
        }

        if (maxSum < 0)
            return maxSum;  // all elements are negative
        else
            return Math.max(maxSum, totalSum - minSum);





    }

    public static void main(String[] args) {
        MaximumSumCircularSubarray solution = new MaximumSumCircularSubarray();
        System.out.println(
        solution.maxSubarraySumCircular(new int[]{0,5,8,-9,9,-7,3,-2}));
    }
}
