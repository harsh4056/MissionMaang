import java.util.Arrays;

public class WarFire {
    public int calculate(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][total + 1];


        dp[n][0] = true;


        for (int index = n - 1; index >= 0; index--) {
            for (int t = 0; t <= total; t++) {
                boolean skip = dp[index + 1][t];
                boolean take = false;

                if (t - nums[index] >= 0) {
                    take = dp[index + 1][t - nums[index]];
                }

                dp[index][t] = skip || take;
            }
        }

        int ans = Integer.MAX_VALUE;


        for (int j = 0; j <= total; j++) {
            if (dp[0][j]) {
                ans = Math.min(ans, Math.abs((total - j) - j));
            }
        }

        return ans;
    }



    public static void main(String[] args) {
        WarFire soln= new WarFire();
        System.out.println(soln.calculate(new int[]{1,2,5}));

    }
}
