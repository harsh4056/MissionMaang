public class HouseRobber {


    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        if (n == 2) return Math.max(nums[0], nums[1]);

        int a = 0;            // dp[i-3]
        int b = nums[0];      // dp[i-2]
        int c = nums[1];      // dp[i-1], though not strictly needed

        for (int i = 2; i < n; i++) {
            int current = Math.max(a, b) + nums[i];
            a = b;
            b = c;
            c = current;
        }

        return Math.max(b, c);
    }


    public static void main(String[] args) {
        HouseRobber houseRobber=  new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{9,1,1,1,1,7 }));
    }
}
