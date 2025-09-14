import java.util.*;

public class SusbSequenceSumAfterCapping {

    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        boolean[] ans = new boolean[n];

        // DP array for achievable sums
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;

        // Count frequency of numbers
        int[] freq = new int[n + 1];
        for (int num : nums) freq[num]++;

        for (int cap = 1; cap <= n; cap++) {
            int count = 0;
            for (int val = cap; val <= n; val++) count += freq[val]; // all numbers >= cap contribute as cap

            if (count > 0) {
                for (int s = k; s >= cap; s--) {
                    for (int t = 1; t <= count && t * cap <= s; t++) {
                        if (dp[s - t * cap]) {
                            dp[s] = true;
                            break;
                        }
                    }
                }
            }

            ans[cap - 1] = dp[k];
        }

        return ans;
    }


    public static void main(String[] args) {
        SusbSequenceSumAfterCapping obj = new SusbSequenceSumAfterCapping();
        int[] nums2 = {4,2,3,4};
        int k2 = 5;
        boolean[] res2 = obj.subsequenceSumAfterCapping(nums2, k2);
        System.out.println(Arrays.toString(res2));
        // Test case 1
        int[] nums1 = {11,12,2,8,4,19,10,10,14,20,17,10,2,13,20,15,20,9,13,16};
        int k1 = 6;
        boolean[] res1 = obj.subsequenceSumAfterCapping(nums1, k1);
        System.out.println(Arrays.toString(res1));


    }
}

