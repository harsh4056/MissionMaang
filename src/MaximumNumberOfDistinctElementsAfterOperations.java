import java.util.Arrays;
import java.util.HashSet;

public class MaximumNumberOfDistinctElementsAfterOperations {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int prev=nums[0]-k;
        int count=1;
        for (int i = 1; i < nums.length; i++) {

            int start=nums[i]-k;
            int end=nums[i]+k;

            if(prev+1>=start && prev+1<=end){
                prev=prev+1;
                count++;
            }
            else{
                if(nums[i]>prev) {
                    prev = start;
                    count++;
                }

            }
        }
        return count;
    }
    public static void main(String[] args) {
        MaximumNumberOfDistinctElementsAfterOperations sol = new MaximumNumberOfDistinctElementsAfterOperations();
        int[] nums2 = {1, 1,1,1,1,1,8,8,8};
        int k2 = 1;
        System.out.println(sol.maxDistinctElements(nums2, k2)); // Expected output: 3
        int[] nums3 = {7,8,10,10,7,6,7};
        int k3 = 1;
        System.out.println(sol.maxDistinctElements(nums3, k3)); // Expected output: 7

        int[] nums1 = {1, 2, 2, 3};
        int k1 = 1;
        System.out.println(sol.maxDistinctElements(nums1, k1)); // Expected output: 4




    }

}
