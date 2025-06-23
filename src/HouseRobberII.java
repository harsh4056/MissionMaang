public class HouseRobberII {

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = nums[1];

        for (int i = 0; i < n; i++) {
            int iMinus2= (((i-2)%n)+n)%n;
            int iMinus3= (((i-3)%n)+n)%n;
            int pickFrom2Back = Math.abs(iMinus2-i)>1? dp[iMinus2]:0;
            int pickFrom3Back =  Math.abs(iMinus2-i)>1?dp[iMinus3] :0;
            dp[i] = Math.max(pickFrom2Back, pickFrom3Back) + nums[i];
        }


        return Math.max(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) {
        HouseRobberII solution = new HouseRobberII();

        int[] nums1 = {2, 3, 2};
        System.out.println(solution.rob(nums1)); // Expected: 3

        int[] nums2 = {1, 2, 3, 1};
        System.out.println(solution.rob(nums2)); // Expected: 4

        int[] nums3 = {1, 2, 3};
        System.out.println(solution.rob(nums3)); // Expected: 3
    }


}
