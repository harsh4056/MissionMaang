public class MinimumLimitOfBallsInBag {
    public int minimumSize(int[] nums, int maxOperations) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int left = 1, right = max;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int ops = getOps(nums, mid);

            if (ops > maxOperations) {
                left = mid + 1;  // too many operations → bag too small
            } else {
                right = mid;     // can achieve → try smaller
            }
        }

        return left;
    }

    public int getOps(int[] nums, int bag) {
        int ops = 0;
        for (int num : nums) {
            ops += (num - 1) / bag;
        }
        return ops;
    }

    public static void main(String[] args) {
        MinimumLimitOfBallsInBag sol = new MinimumLimitOfBallsInBag();

        int[] nums1 = {9};
        int maxOperations1 = 2;
        System.out.println(sol.minimumSize(nums1, maxOperations1)); // Expected: 3

        int[] nums2 = {2, 4, 8, 2};
        int maxOperations2 = 4;
        System.out.println(sol.minimumSize(nums2, maxOperations2)); // Expected: 2

        int[] nums3 = {7, 17};
        int maxOperations3 = 2;
        System.out.println(sol.minimumSize(nums3, maxOperations3)); // Expected: 7
    }
}
