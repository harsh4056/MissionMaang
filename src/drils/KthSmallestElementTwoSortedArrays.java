package drils;

public class KthSmallestElementTwoSortedArrays {

    public int kthSmalles(int[] nums1, int[] nums2,int k) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, idx = 0;

        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                merged[idx++] = nums1[i++];
            } else {
                merged[idx++] = nums2[j++];
            }
        }

        return merged[k-1];
    }


    public static void main(String[] args) {
        KthSmallestElementTwoSortedArrays obj = new KthSmallestElementTwoSortedArrays();

        int[] nums1 = {1, 3, 5};
        int[] nums2 = {2, 4, 6};
        int result1 = obj.kthSmalles(nums1, nums2, 4);
        System.out.println(result1); // Expected: 4

        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4, 5, 6};
        int result2 = obj.kthSmalles(nums3, nums4, 5);
        System.out.println(result2); // Expected: 5

        int[] nums5 = {10, 20, 30};
        int[] nums6 = {5, 15, 25};
        int result3 = obj.kthSmalles(nums5, nums6, 3);
        System.out.println(result3); // Expected: 15
    }

}
