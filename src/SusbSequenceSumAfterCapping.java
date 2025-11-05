import java.util.*;

public class SusbSequenceSumAfterCapping {

    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        boolean[] answer = new boolean[n];
        Arrays.sort(nums);

        for (int cap = 1; cap <= n; cap++) {
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = Math.min(cap, nums[j]);
            }
            Boolean[][] dp = new Boolean[n][k + 1];
            answer[cap - 1] = isPossible(arr, k, 0, 0, dp);
        }
        return answer;
    }

    private boolean isPossible(int[] nums, int k, int currSum, int index, Boolean[][] dp) {
        if (currSum == k) return true;
        if (index == nums.length || currSum > k) return false;
        if (dp[index][currSum] != null) return dp[index][currSum];

        boolean take = isPossible(nums, k, currSum + nums[index], index + 1, dp);
        boolean skip = isPossible(nums, k, currSum, index + 1, dp);

        return dp[index][currSum] = take || skip;
    }


    public static void main(String[] args) {
        SusbSequenceSumAfterCapping obj = new SusbSequenceSumAfterCapping();
        // Test case 1
        int[] nums1 = {11,12,2,8,4,19,10,10,14,20,17,10,2,13,20,15,20,9,13,16};
        int k1 = 60;
        boolean[] res1 = obj.subsequenceSumAfterCapping(nums1, k1);
        System.out.println(Arrays.toString(res1));
        int[] nums2 = {4,2,3,4};
        int k2 =5;

        boolean[] res2 = obj.subsequenceSumAfterCapping(nums2, k2);
        System.out.println(Arrays.toString(res2));



    }
}

