import java.util.HashMap;
import java.util.Map;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {

        if (k < 1) return 0;
        int runningProduct=1;
        int count=0;
        int left=0;

        for (int i = 0; i < nums.length; i++) {
            runningProduct*=nums[i];
                while (left<=i && runningProduct>=k) {
                    runningProduct /= nums[left++];
                }
                count += i - left + 1;
        }

        return count;


    }

    public static void main(String[] args) {
        SubarrayProductLessThanK solution = new SubarrayProductLessThanK();

        int[] nums1 = {10, 5, 2, 6};
        int k1 = 100;
        System.out.println(solution.numSubarrayProductLessThanK(nums1, k1)); // Expected: 8

        int[] nums2 = {1, 2, 3};
        int k2 = 0;
        System.out.println(solution.numSubarrayProductLessThanK(nums2, k2)); // Expected: 0

        int[] nums3 = {1, 1, 1};
        int k3 = 1;
        System.out.println(solution.numSubarrayProductLessThanK(nums3, k3)); // Expected: 6
    }

}
