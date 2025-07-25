public class MaximumSumSubArray {

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] > nums[i]) {
                currentSum = currentSum + nums[i];
            } else {
                currentSum = nums[i];
            }

            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;


    }



    public static void main(String[] args) {
        MaximumSumSubArray maximumSumSubArray= new MaximumSumSubArray();
        System.out.println(maximumSumSubArray.maxSubArray(new int[]{5,-3,5}));
        System.out.println(maximumSumSubArray.maxSubArray(new int[]{-2,1}));
    }
}
