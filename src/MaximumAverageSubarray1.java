public class MaximumAverageSubarray1 {
    public double findMaxAverage(int[] nums, int k) {
        double max=Integer.MIN_VALUE;
        double sum=0;
        for (int i = 0; i < k; i++) {
            sum+=nums[i];
        }
        max= Math.max(sum,max);
        for (int i = k; i < nums.length; i++) {
            sum=(sum-nums[i-k])+nums[i];
            max=Math.max(max,sum);
        }
        return max /k;

    }





    public static void main(String[] args) {
        MaximumAverageSubarray1 solution = new MaximumAverageSubarray1();

      /*  int[] nums1 = {1,12,-5,-6,50,3};
        int k1 = 4;
        System.out.println(solution.findMaxAverage(nums1, k1)); // Expected: 12.75

        int[] nums2 = {5,5,5,5,5};
        int k2 = 2;
        System.out.println(solution.findMaxAverage(nums2, k2)); // Expected: 5.0*/

        int[] nums3 = {-1};
        int k3 = 1;
        System.out.println(solution.findMaxAverage(nums3, k3)); // Expected: -6.0
    }

}
