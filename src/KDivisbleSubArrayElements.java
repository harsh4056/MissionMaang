import java.util.*;

public class KDivisbleSubArrayElements {
    public int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        HashSet<Long> set = new HashSet<>();  // store combined double hash

        long mod1 = 1_000_000_007;
        long mod2 = 1_000_000_009;
        int base1 = 31;
        int base2 = 37;

        for (int i = 0; i < n; i++) {
            int td = 0;
            long hash1 = 0;
            long hash2 = 0;

            for (int j = i; j < n; j++) {
                if (nums[j] % p == 0) td++;
                if (td > k) break;

                hash1 = (hash1 * base1 + nums[j]) % mod1;
                hash2 = (hash2 * base2 + nums[j]) % mod2;

                // combine two hashes into a single long
                long combinedHash = (hash1 << 32) | hash2;
                set.add(combinedHash);
            }
        }

        return set.size();
    }

    /*
    * Initially used a single hash and the test cases are really cleverly generated. So single hashing casued
    * a collsion because test cases contained one to tackle that.
    *  After using to separate hashses and then combining them the collision was handled
    *
    * */
    public static void main(String[] args) {
        KDivisbleSubArrayElements obj = new KDivisbleSubArrayElements();

        // Test Case 1
        int[] nums1 = {2,3,3,2,2};
        int k1 = 2;
        int p1 = 2;
        System.out.println("Test Case 1 Output: " + obj.countDistinct(nums1, k1, p1)); // Example expected output: 11

        // Test Case 2
        int[] nums2 = {1, 2, 3, 4};
        int k2 = 2;
        int p2 = 2;
        System.out.println("Test Case 2 Output: " + obj.countDistinct(nums2, k2, p2)); // Example expected output: 10

        // Test Case 3
        int[] nums3 = {2, 4, 6};
        int k3 = 2;
        int p3 = 2;
        System.out.println("Test Case 3 Output: " + obj.countDistinct(nums3, k3, p3)); // Example expected output: 5
    }
}
