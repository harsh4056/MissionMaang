import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MaxNumberSumOfKPairs {

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int left=0;
        int right=nums.length-1;
        int count=0;
        while(left<right){
            int sum=nums[left]+nums[right];
            if(sum>k){
                right--;
            }
            else if(sum<k){
                left++;
            }
            else{
                left++;
                right--;
                count++;
            }
        }

        return count;
    }

    public static int maxOperations2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;

        for (int num : nums) {
            int target = k - num;
            if (map.getOrDefault(target, 0) > 0) {
                count++;
                map.put(target, map.get(target) - 1);
            } else {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        return count;
    }


    public static void main(String[] args) {
        MaxNumberSumOfKPairs solution = new MaxNumberSumOfKPairs();

        // Test Case 1
        int[] nums1 = {1, 2, 3, 4};
        int k1 = 5;
        System.out.println(solution.maxOperations(nums1, k1)); // Expected: 2

        // Test Case 2
        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        System.out.println(solution.maxOperations(nums2, k2)); // Expected: 1

        // Test Case 3
        int[] nums3 = {2, 2, 2, 2};
        int k3 = 4;
        System.out.println(solution.maxOperations(nums3, k3)); // Expected: 2
    }

}
