import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;
        int target = total / 2;
        Map<String, Boolean> memo = new HashMap<>();
        boolean answer= canPartitionHelper(nums, 0, target, memo);
        return answer;
    }

    private static boolean canPartitionHelper(int[] nums, int index, int target, Map<String, Boolean> memo) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;

        String key = index + "," + target;
        if (memo.containsKey(key)) return memo.get(key);

        boolean include = canPartitionHelper(nums, index + 1, target - nums[index], memo);
        boolean exclude = canPartitionHelper(nums, index + 1, target, memo);

        boolean result = include || exclude;
        memo.put(key, result);
        return result;
    }

    public static boolean canPartition2(int[] nums) {

            int total = Arrays.stream(nums).sum();
            if (total % 2 != 0) return false;
            int target = total / 2;

            BitSet dp = new BitSet(target + 1);
            dp.set(0);

            for (int num : nums) {
                BitSet shifted = (BitSet) dp.clone();
                for (int i = dp.length() - 1; i >= 0; i--) {
                    if (dp.get(i) && i + num <= target) {
                        shifted.set(i + num);
                    }
                }
                dp = shifted;
            }

            return dp.get(target);


    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 11, 5};
        System.out.println("Can partition: " + canPartition2(arr1)); // true

        int[] arr2 = {1, 2, 3, 5};
        System.out.println("Can partition: " + canPartition2(arr2)); // false

        int[] arr3 = {2, 2, 3, 5};
        System.out.println("Can partition: " + canPartition2(arr3)); // false
    }

}
