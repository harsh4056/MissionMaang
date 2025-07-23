public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
       int[] left= new int[n];
       int[] right= new int[n];
        for (int i = 0; i < n; i++) {
            left[i]=nums[i]*(i-1>=0?left[i-1]:1);
            int j=n-1-i;
            right[j]=nums[j]*(j+1<n?right[j+1]:1);
        }

        int []arr= new int[n];

        for (int i = 0; i <n ; i++) {
            int rightVal=i+1<n?right[i+1]:1;
            int leftVal=  i-1>=0?left[i-1]:1;
            arr[i]= rightVal *leftVal;
        }
        return arr;

    }

    public static void main(String[] args) {
        ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();

        int[] result1 = solution.productExceptSelf(new int[]{1, 2, 3, 4});
        System.out.println(java.util.Arrays.toString(result1)); // Expected: [24, 12, 8, 6]

        int[] result2 = solution.productExceptSelf(new int[]{-1, 1, 0, -3, 3});
        System.out.println(java.util.Arrays.toString(result2)); // Expected: [0, 0, 9, 0, 0]

        int[] result3 = solution.productExceptSelf(new int[]{2, 3});
        System.out.println(java.util.Arrays.toString(result3)); // Expected: [3, 2]
    }

}
