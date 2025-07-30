public class CountNumberOfMaximumBitwiseOR {

    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums) max |= num;
        return dfs(nums, 0, 0, max);
    }

    private int dfs(int[] nums, int index, int currentOR, int max) {
        if (index == nums.length) {
            return currentOR == max ? 1 : 0;
        }

        // Include nums[index]
        int take = dfs(nums, index + 1, currentOR | nums[index], max);

        // Exclude nums[index]
        int skip = dfs(nums, index + 1, currentOR, max);

        return take + skip;
    }

    public static void main(String[] args) {
        CountNumberOfMaximumBitwiseOR solution = new CountNumberOfMaximumBitwiseOR();

        int[] nums1 = {3, 1};
        System.out.println(solution.countMaxOrSubsets(nums1)); // Expected: 2

        int[] nums2 = {2, 2, 2};
        System.out.println(solution.countMaxOrSubsets(nums2)); // Expected: 7

        int[] nums3 = {3,2,1,5};
        System.out.println(solution.countMaxOrSubsets(nums3)); // Expected: 6
    }

}
