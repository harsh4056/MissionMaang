public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int right = 0;
        int left = 0;
        int window = 0;
        int minWindow = Integer.MAX_VALUE;

        while (right < nums.length) {
            // Expand window
            window += nums[right];
            right++;

            // Shrink window as small as possible while maintaining window sum >= target
            while (window >= target) {
                minWindow = Math.min(minWindow, right - left);
                window -= nums[left];
                left++;
            }
        }

        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
    }


    public static void main(String[] args) {
        MinimumSizeSubArraySum solution = new MinimumSizeSubArraySum();

        int[] nums1 = {2, 3, 1, 2, 4, 3};
        int target1 = 7;
        System.out.println("Result 1: " + solution.minSubArrayLen(target1, nums1));  // Expected 2

        int[] nums2 = {1, 4, 4};
        int target2 = 4;
        System.out.println("Result 2: " + solution.minSubArrayLen(target2, nums2));  // Expected 1

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        System.out.println("Result 3: " + solution.minSubArrayLen(target3, nums3));  // Expected 0
    }

}
