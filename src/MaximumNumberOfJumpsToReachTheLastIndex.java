public class MaximumNumberOfJumpsToReachTheLastIndex {

    public int maximumJumps(int[] nums, int target) {
        int ans= dfs(nums,0,0,target);
        return ans;
    }

    public int dfs(int[]nums,int index,int prev,int target){
        if(index==nums.length) return 0;

        int take=0;
        int skip=0;
        int diff=Math.abs(nums[prev]-nums[index]);

        if(prev!=index && diff<=target){
            take=1+dfs(nums,index+1,index,target);
        }
        skip=dfs(nums,index+1,prev,target);
        return Math.max(take,skip);
    }

    public static void main(String[] args) {
        MaximumNumberOfJumpsToReachTheLastIndex sol = new MaximumNumberOfJumpsToReachTheLastIndex();

        int[] nums1 = {1,2,3,4};
        System.out.println(sol.maximumJumps(nums1, 10));
        // Expected: 3

        int[] nums2 = {1, 3, 6, 4, 1, 2};
        System.out.println(sol.maximumJumps(nums2, 3));
        // Expected: 5

        int[] nums3 = {1, 3, 6, 4, 1, 2};
        System.out.println(sol.maximumJumps(nums3, 0));
        // Expected: -1
    }
}
