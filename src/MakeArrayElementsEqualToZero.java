public class MakeArrayElementsEqualToZero {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        if ((n == 1) && nums[0] == 0)
            return 2;
        int[] suffix = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = nums[i] + suffix[i + 1];
        }
        int count = 0;
        int prefix = 0;
        for (int i = 0; i < n; i++) {
            prefix += nums[i];
            int right = suffix[i] - nums[i];
            if (right == prefix && nums[i] == 0)
                count = count + 2;
            else if (Math.abs(prefix - right) == 1 && nums[i] == 0)
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        MakeArrayElementsEqualToZero obj = new MakeArrayElementsEqualToZero();

        int[] nums1 = {1, 0, 2, 0, 3};
        int[] nums2 = {16,13,10,0,0,0,10,6,7,8,7};
        int[] nums3 = {2, -2, 2, -2, 2};
        System.out.println(obj.countValidSelections(nums1)); // Expected: 2
        System.out.println(obj.countValidSelections(nums2)); // Expected: 3


        System.out.println(obj.countValidSelections(nums3)); // Expected: 2
    }


}
