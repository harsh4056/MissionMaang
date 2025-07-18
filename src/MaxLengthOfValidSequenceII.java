import java.util.Arrays;

public class MaxLengthOfValidSequenceII {

    public int maximumLength(int[] nums, int k) {
        int ans=0;
        int n=nums.length;
       int [][]dp = new int[n][n];
        for (int i = 0; i < dp.length; i++) {
            for (int j = i+1; j < dp.length; j++) {
                dp[i][j]= (nums[i]+nums[j])%k;

            }

        }
       return ans+1;
    }

    public static void main(String[] args) {
        MaxLengthOfValidSequenceII solution = new MaxLengthOfValidSequenceII();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println(solution.maximumLength(nums1, k1)); // Expected output: 3

        // Test case 2
        int[] nums2 = {1,4,2,3,1,4};
        int k2 = 3;
        System.out.println(solution.maximumLength(nums2, k2)); // Expected output: 4

        // Test case 3
        int[] nums3 = {3,2,1,9,1};
        int k3 = 6;
        System.out.println(solution.maximumLength(nums3, k3)); // Expected output: 2
    }


}
