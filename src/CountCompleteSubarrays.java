import java.util.*;

public class CountCompleteSubarrays {

    public int countCompleteSubarrays(int[] nums) {
        HashSet<Integer> set= new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        int distinct=set.size();
        int n=nums.length;
        int[] freq = new int[1001];
        int formed = 0, count = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            if (freq[nums[right]] == 0) formed++;
            freq[nums[right]]++;

            while (formed == distinct) {
                count += (n - right);

                freq[nums[left]]--;
                if (freq[nums[left]] == 0) formed--;
                left++;
            }
        }
        return count;

    }




    public static void main(String[] args) {
        CountCompleteSubarrays sol = new CountCompleteSubarrays();

        // Test case 1
        int[] nums1 = {1, 3, 1, 2, 2};
        System.out.println(sol.countCompleteSubarrays(nums1));
        // Expected: 4

        // Test case 2
        int[] nums2 = {5, 5, 5, 5};
        System.out.println(sol.countCompleteSubarrays(nums2));
        // Expected: 10 (all subarrays are complete since only 1 distinct element)

        // Test case 3
        int[] nums3 = {1, 2, 3};
        System.out.println(sol.countCompleteSubarrays(nums3));
        // Expected: 1
    }

}
