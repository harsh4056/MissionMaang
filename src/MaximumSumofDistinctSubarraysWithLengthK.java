import java.util.*;

public class MaximumSumofDistinctSubarraysWithLengthK {
    public long maximumSubarraySum(int[] nums, int k) {
        int[] freq=new int[100001];
        int n = nums.length;
        int formed = 0;
        long count = 0;
        for (int i = 0; i < k ; i++) {
            count = count + nums[i];
            freq[nums[i]]++;
            if (freq[nums[i]] > 1)
                formed++;

        }
        long max = 0;
        if (formed == 0)
            max = Math.max(max, count);
        for (int i = k; i < n; i++) {
            count -= nums[i - k];
            count += nums[i];


            freq[nums[i]]++;

            if (freq[nums[i]] > 1)
                formed++;

            if (freq[nums[i-k]] > 1)
                formed--;
            freq[nums[i-k]]--;
            if (formed == 0)
                max = Math.max(max, count);

        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSumofDistinctSubarraysWithLengthK sol = new MaximumSumofDistinctSubarraysWithLengthK();

        int[] nums1 = {1,1,1,7,8,9};
        int k1 = 3;
        System.out.println(sol.maximumSubarraySum(nums1, k1)); // Expected: 12 (subarray [3,4,5])

        int[] nums2 = {4, 4, 4};
        int k2 = 2;
        System.out.println(sol.maximumSubarraySum(nums2, k2)); // Expected: 0 (no distinct subarray of length 2)

        int[] nums3 = {1, 2, 1, 3, 4, 2, 3};
        int k3 = 3;
        System.out.println(sol.maximumSubarraySum(nums3, k3)); // Expected: 9 (subarray [1,3,4])
    }

}
