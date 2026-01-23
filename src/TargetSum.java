public class TargetSum {
    public int findTargetSumWays(int[] nums, int target) {
        return solve(nums,target,0);
    }
    public int solve(int[]nums,int target,int index){
        if(index==nums.length){
            if(target==0) return 1;
            else return 0;
        }
        return solve(nums,target-nums[index],index+1) +
                solve(nums,target+nums[index],index+1);
    }

    public static void main(String[] args) {
        TargetSum solution = new TargetSum();

        int[] nums1 = {1, 1, 1, 1, 1};
        int target1 = 3;
        System.out.println(solution.findTargetSumWays(nums1, target1)); // Expected: 5

        int[] nums2 = {1};
        int target2 = 1;
        System.out.println(solution.findTargetSumWays(nums2, target2)); // Expected: 1

        int[] nums3 = {1, 2, 3, 4, 5};
        int target3 = 3;
        System.out.println(solution.findTargetSumWays(nums3, target3)); // Expected: 3
    }

}
