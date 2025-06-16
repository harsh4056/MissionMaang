public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int []answer=new int[n];
        int leftProduct=1;
        int rightProduct=1;
        int k=n-1;
        for (int i = 0; i < n; i++) {
           leftProduct*=nums[i];
           answer[i]=leftProduct;
        }
        for (int i = k; i >=0; i--) {
            int leftP=i-1<0?1:answer[i-1];

            answer[i]=leftP*rightProduct;
            rightProduct*=nums[i];
        }
        return answer;

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
