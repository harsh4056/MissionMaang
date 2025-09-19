import java.util.*;

public class SubArraysWithKDifferentIntegers {

    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int formed = 0;
        int count = 0;

        HashMap<Integer, Integer> hashmap = new HashMap<>();

        while (right < n) {
            hashmap.put(nums[right], hashmap.getOrDefault(nums[right], 0) + 1);
            if (hashmap.getOrDefault(nums[right], 0) == 1)
                formed++;
            while (left<=right && formed > k) {
                count += (n - right);
                hashmap.put(nums[left], hashmap.getOrDefault(nums[left], 0) - 1);
                if (hashmap.getOrDefault(nums[left], 0) == 0)
                    formed--;
                left++;

            }
            right++;
        }
        return count;

    }

    public static void main(String[] args) {
        SubArraysWithKDifferentIntegers sol = new SubArraysWithKDifferentIntegers();

        // Test case 1
        int[] nums1 = {1, 2, 1, 2, 3};
        System.out.println(sol.subarraysWithKDistinct(nums1, 2));
        // Expected: 7 (subarrays with exactly 2 distinct elements)

        // Test case 2
        int[] nums2 = {1, 2, 1, 3, 4};
        System.out.println(sol.subarraysWithKDistinct(nums2, 3));
        // Expected: 3 ([1,2,1,3], [2,1,3], [1,3,4])

        // Test case 3
        int[] nums3 = {1, 2, 1, 2, 1};
        System.out.println(sol.subarraysWithKDistinct(nums3, 2));
        // Expected: 10
    }

}
