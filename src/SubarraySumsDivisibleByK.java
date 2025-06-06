import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> modMap = new HashMap<>();
        modMap.put(0, 1);

        int sum = 0, count = 0;

        for (int num : nums) {
            sum += num;
            int mod = ((sum % k) + k) % k;  // handle negative values

            count += modMap.getOrDefault(mod, 0);
            modMap.put(mod, modMap.getOrDefault(mod, 0) + 1);
        }

        return count;
    }







    public static void printResult(int[] nums, int k) {
        SubarraySumsDivisibleByK obj = new SubarraySumsDivisibleByK();
        int result = obj.subarraysDivByK(nums, k);
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {4, 5, 0, -2, -3, 1};
        int k1 = 5;
        printResult(nums1, k1);  // Expected Output: 7

        // Test Case 2
        int[] nums2 = {5};
        int k2 = 9;
        printResult(nums2, k2);  // Expected Output: 0

        // Test Case 3
        int[] nums3 = {2, -2, 2, -4};
        int k3 = 6;
        printResult(nums3, k3);  // Expected Output: 2

    }

}
