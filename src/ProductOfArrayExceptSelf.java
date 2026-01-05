public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[]ans= new int[n];
        ans[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            ans[i]=nums[i]*ans[i+1];
        }
        int prod=1;
        for(int i=0;i<n;i++){
            ans[i]=prod*(i<n-1?ans[i+1]:1);
            prod=prod*nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        int[] result1 = solution.productExceptSelf(new int[]{1, 2, 4, 6});
        System.out.println(java.util.Arrays.toString(result1)); // Expected: [24, 12, 8, 6]

        int[] result2 = solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        System.out.println(java.util.Arrays.toString(result2)); // Expected: [0, 0, 9, 0, 0]

        int[] result3 = solution.productExceptSelf(new int[]{2, 3});
        System.out.println(java.util.Arrays.toString(result3)); // Expected: [3, 2]
    }

}
