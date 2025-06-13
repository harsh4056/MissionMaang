package drils.binarysearch;

public class TwoPointersAndMerge {

    public double median(int[] nums1, int[] nums2) {
        int[] merged = new int[nums1.length + nums2.length];
        int i = 0, j = 0, k = 0;

        while (i < nums1.length || j < nums2.length) {
            if (i < nums1.length && (j == nums2.length || nums1[i] < nums2[j])) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }
        int n= merged.length;

        if(n%2==0){
            return (double) (merged[n/2]+merged[(n/2)-1])/2;
        }
        else{
            return merged[n/2];
        }
    }
}
