import java.util.Arrays;

public class LargestSumAfterKNegations {
    public int largestSumAfterKNegations(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int lowest = 0;

        for (int i = 0; i < n &&k>0; i++) {
            if (nums[i] < 0) {
                nums[i] = -nums[i];
                k--;
            }
            if (nums[lowest] > nums[i]) {
                lowest = i;
            }
        }
        if (k % 2 == 1) {
            nums[lowest] = -nums[lowest];
        }
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main(String[] args) {
        LargestSumAfterKNegations obj = new LargestSumAfterKNegations();

        int[] nums1 = {-2, 5, 0, 2, -3};
        //System.out.println(obj.largestSumAfterKNegations(nums1, 3)); // Expected 12

        int[] nums2 = {3, -1, 0, 2};
        //System.out.println(obj.largestSumAfterKNegations(nums2, 3)); // Expected 6

        int[] nums3 = {2, -3, -1, 5, -4};
        //System.out.println(obj.largestSumAfterKNegations(nums3, 2)); // Expected 13

        int[] nums4 = {-8, -7, -3, -2, 1};
        System.out.println(obj.largestSumAfterKNegations(nums4, 4)); // Expected 21
    }
}
