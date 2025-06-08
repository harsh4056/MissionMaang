package drils;

public class BinarySearchInSortedArray {

    public int find(int []nums,int candidate){
        int left=0;
        int right=nums.length-1;
        while (left<=right){

            int mid=left+((right-left)/2);
            if(nums[mid]==candidate){
                return mid;
            }
            if(candidate<nums[mid]){
                right=mid-1;
            }
            else {
                left=mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchInSortedArray obj = new BinarySearchInSortedArray();

        int[] nums1 = {1, 3, 5, 7, 9};
        int result1 = obj.find(nums1, 5);
        System.out.println(result1); // Expected: 2

        int[] nums2 = {2, 4, 6, 8, 10, 12};
        int result2 = obj.find(nums2, 8);
        System.out.println(result2); // Expected: 3

        int[] nums3 = {1, 2, 3, 4, 5};
        int result3 = obj.find(nums3, 6);
        System.out.println(result3); // Expected: -1
    }



}
