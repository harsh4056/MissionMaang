import java.util.Arrays;

public class MaximumTotalDamageWithSpellCasting {

    public long maximumTotalDamage(int[] power) {
        Arrays.sort(power);
        int n = power.length;
        long[] dp = new long[n];
        long max = 0;

        for (int i = 0; i < n; i++) {
            int last = lastIndex(power, i);
            dp[i] = power[i] + (last != -1 ? dp[last] : 0);
            if (i > 0) dp[i] = Math.max(dp[i], dp[i - 1]); // choose max till i
            max = Math.max(max, dp[i]);
        }
        return max;

    }
    public int lastIndex(int[]power,int index){
        int num = power[index];
        int left = 0, right = index - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (power[mid] < num - 2) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        MaximumTotalDamageWithSpellCasting soln= new MaximumTotalDamageWithSpellCasting();
        System.out.println(soln.maximumTotalDamage(new int[]{1,1,1,1,1,1,4,3,6}));//12
        System.out.println(soln.maximumTotalDamage(new int[]{7,1,6,6}));//13
        System.out.println(soln.maximumTotalDamage(new int[]{5,9,2,10,2,7,10,9,3,8}));//31
    }
}
