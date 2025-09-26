import java.util.*;

public class MinimumSubsequenceNonIncreasingOrder {


    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int total=0;
        for(int num:nums)total+=num;
        List<Integer> list= new ArrayList<>();
        int n=nums.length;
        int backward=0;
        for(int i=n-1;i>=0;i--){
            backward+=nums[i];

            list.add(nums[i]);
            if(backward>(total-backward)) break;
        }

        return list;
    }
    public static void main(String[] args) {
        MinimumSubsequenceNonIncreasingOrder sol = new MinimumSubsequenceNonIncreasingOrder();

        int[] nums1 = {4, 3, 10, 9, 8};
        System.out.println(sol.minSubsequence(nums1)); // Expected: [10, 9]

        int[] nums2 = {4, 4, 7, 6, 7};
        System.out.println(sol.minSubsequence(nums2)); // Expected: [7, 7, 6]

        int[] nums3 = {6};
        System.out.println(sol.minSubsequence(nums3)); // Expected: [6]
    }

}
