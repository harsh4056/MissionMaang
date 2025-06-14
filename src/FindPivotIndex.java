import java.util.HashSet;

public class FindPivotIndex {


    public int pivotIndex(int[] nums) {

        int sum=0;
        for (int num : nums) {
            sum += num;
        }
        int leftSum=0;
        for (int i = 0; i < nums.length; i++) {
            int num=nums[i];
            leftSum+=num;
            int left=leftSum-num;
            int right=sum-leftSum;
            if(left==right){
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        FindPivotIndex obj = new FindPivotIndex();

        // Test Case 1
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println(obj.pivotIndex(nums1)); // Expected: 3

        // Test Case 2
        int[] nums2 = {1, 2, 3};
        System.out.println(obj.pivotIndex(nums2)); // Expected: -1
        // Test Case 3
        int[] nums3 = {2, 1, -1};
        System.out.println(obj.pivotIndex(nums3)); // Expected: 0

        int[] nums4 = {-1,-1,0,1,1,0};
        System.out.println(obj.pivotIndex(nums4)); // Expected: 5
    }

}
