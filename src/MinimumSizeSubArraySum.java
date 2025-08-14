public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int rSum = 0;
        int len = Integer.MAX_VALUE;
        int n = nums.length;
        while (left < n) {
            if(right>=n && rSum<target)
                break;

            if (rSum < target && right < n) {
                rSum += nums[right];
                right++;
            } else if (rSum >= target) {
                len = Math.min(len, right - left);
                rSum -= nums[left];
                left++;
            }
                //System.out.println("Right:" + right + "Left:" + left);


            }

        if (len == Integer.MAX_VALUE)
            return 0;
        return len;
    }


    public static void main(String[] args) {
        MinimumSizeSubArraySum solution = new MinimumSizeSubArraySum();

        int[] nums1 = {1,2,3,4,5};
        int target1 = 11;
        System.out.println("Result 1: " + solution.minSubArrayLen(target1, nums1));  // Expected 3

        int[] nums2 = {1, 4, 4};
        int target2 = 4;
        System.out.println("Result 2: " + solution.minSubArrayLen(target2, nums2));  // Expected 1

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        System.out.println("Result 3: " + solution.minSubArrayLen(target3, nums3));  // Expected 0
    }

}
