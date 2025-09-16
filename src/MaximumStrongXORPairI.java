public class MaximumStrongXORPairI {
    public int maximumStrongPairXor(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){

            int x=nums[i];
            for(int j=i+1;j<n;j++){
                int y=nums[j];
                int abs=Math.abs(x-y);
                int min=Math.min(x,y);
                if(abs<=min){
                    max=Math.max(x^y,max);
                }
            }
        }
        return max;
    }
    public static void main(String[] args) {
        MaximumStrongXORPairI solution = new MaximumStrongXORPairI();

        // Test case 1
        int result1 = solution.maximumStrongPairXor(new int[]{1, 2, 3, 4});
        System.out.println(result1); // Expected output: 7

        // Test case 2
        int result2 = solution.maximumStrongPairXor(new int[]{10, 12, 15});
        System.out.println(result2); // Expected output: 6

        // Test case 3
        int result3 = solution.maximumStrongPairXor(new int[]{5, 6, 25, 30});
        System.out.println(result3); // Expected output: 7
    }

}
