package drils.binarysearch;

public class MergeTwoSortedArrays {
    public int[] merge(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        return merged;
    }




    public static void main(String[] args) {

            MergeTwoSortedArrays merger = new MergeTwoSortedArrays();

            int[] result1 = merger.merge(new int[]{1, 3, 5}, new int[]{2, 4, 6});
            printArray(result1);

            int[] result2 = merger.merge(new int[]{1, 2, 3}, new int[]{});
            printArray(result2);

            int[] result3 = merger.merge(new int[]{}, new int[]{7, 8, 9});
            printArray(result3);

    }
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
