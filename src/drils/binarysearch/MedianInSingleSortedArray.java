package drils.binarysearch;

public class MedianInSingleSortedArray {
    public double medianInArray(int[]nums){

        int n= nums.length;

        if(n%2==0){
            return (double) (nums[n/2]+nums[(n/2)-1])/2;
        }
        else{
            return nums[n/2];
        }
    }



    public static void main(String[] args) {
        MedianInSingleSortedArray medianCalc = new MedianInSingleSortedArray();

        // Test case 1
        int[] nums1 = {1, 3, 5};
        double result1 = medianCalc.medianInArray(nums1);
        System.out.println("Median: " + result1);
        // Expected output: 3.0

        // Test case 2
        int[] nums2 = {2, 4, 6, 8};
        double result2 = medianCalc.medianInArray(nums2);
        System.out.println("Median: " + result2);
        // Expected output: (4+6)/2 = 5.0

        // Test case 3
        int[] nums3 = {10, 20, 30, 40, 50, 60};
        double result3 = medianCalc.medianInArray(nums3);
        System.out.println("Median: " + result3);
        // Expected output: (30+40)/2 = 35.0
    }

}
