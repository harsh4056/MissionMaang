import java.util.Arrays;

public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        // Case 1: Rob from house 0 to n-2
        int a1 = 0, b1 = nums[0], c1 = nums[1];
        for (int i = 2; i < n - 1; i++) {
            int current = Math.max(a1, b1) + nums[i];
            a1 = b1;
            b1 = c1;
            c1 = current;
        }
        int max1 = Math.max(b1, c1);

        // Case 2: Rob from house 1 to n-1
        int a2 = 0, b2 = nums[1], c2 = nums[2];
        for (int i = 3; i < n; i++) {
            int current = Math.max(a2, b2) + nums[i];
            a2 = b2;
            b2 = c2;
            c2 = current;
        }
        int max2 = Math.max(b2, c2);

        return Math.max(max1, max2);
    }


    public static void main(String[] args) {
        HouseRobberII solution = new HouseRobberII();

        int[] nums1 = {2, 3, 2};
        System.out.println(solution.rob(nums1)); // Expected: 3

        int[] nums2 = {1, 2, 3, 1};
        System.out.println(solution.rob(nums2)); // Expected: 4

        int[] nums3 = {1, 2, 3};
        System.out.println(solution.rob(nums3)); // Expected: 3
    }


}
