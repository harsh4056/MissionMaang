public class RotateFunction {


    public int maxRotateFunction(int[] nums) {
        int prefixSum=0;
        for (int num : nums) {
            prefixSum+=num;
        }
        int maxi=-1;
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i]*i;
        }
        int n=nums.length;
        for (int i = n-1; i >=0; i--) {
            sum+=prefixSum;
            sum=sum-(n*nums[i]);
            maxi=Math.max(sum,maxi);
        }
        return maxi;
    }
    public static void main(String[] args) {
        RotateFunction obj = new RotateFunction();

        int[] nums1 = {4, 3, 2, 6};
        System.out.println(obj.maxRotateFunction(nums1)); // Expected: 26

        int[] nums2 = {100};
        System.out.println(obj.maxRotateFunction(nums2)); // Expected: 0

        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println(obj.maxRotateFunction(nums3)); // Expected: 40
    }
}
