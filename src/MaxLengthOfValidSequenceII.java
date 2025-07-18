import java.util.*;

public class MaxLengthOfValidSequenceII {

    public  int maximumLength(int[] nums, int k) {
        int n = nums.length;
        int max = 0;

        Map<Integer, List<int[]>> map = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int mod = (nums[i] + nums[j]) % k;

                List<int[]> sequences = map.getOrDefault(mod, new ArrayList<>());

                int best = 2; // default start

                for (int[] prev : sequences) {
                    int prevCount = prev[0];
                    int prev_i = prev[1];
                    int prev_j = prev[2];

                    if (i == prev_i - 1 && j == prev_j - 1) {
                        best = Math.max(best, prevCount + 1);
                    } else if (i > prev_j) {
                        best = Math.max(best, prevCount + 2);
                    }
                }

                sequences.add(new int[]{best, i, j});
                map.put(mod, sequences);
                max = Math.max(max, best);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        MaxLengthOfValidSequenceII solution = new MaxLengthOfValidSequenceII();

        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5};
        int k1 = 2;
        System.out.println(solution.maximumLength(nums1, k1)); // Expected output: 5

        // Test case 2
        int[] nums2 = {1,4,2,3,1,4};
        int k2 = 3;
        System.out.println(solution.maximumLength(nums2, k2)); // Expected output: 4

        // Test case 3
        int[] nums3 = {3,2,1,9,1};
        int k3 = 6;
        System.out.println(solution.maximumLength(nums3, k3)); // Expected output: 4
    }


}
