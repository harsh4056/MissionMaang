public class MinRemovalsToMakeMountainArray {

    public int minimumMountainRemovals(int[] nums) {
        int n= nums.length;


        int[] incr = new int[n];
        int[] decr = new int[n];
        for(int i=0;i<n;i++){
            incr[i]=1;
            decr[i]=1;
        }

        for (int i = 0; i < n; i++) {
            // Forward: LIS ending at i
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    incr[i] = Math.max(incr[i], incr[j] + 1);
                }
            }

            // Backward: LDS starting at (n-1 - i)
            int k = n - 1 - i;
            for (int j = n - 1; j > k; j--) {
                if (nums[k] > nums[j]) {
                    decr[k] = Math.max(decr[k], decr[j] + 1);
                }
            }
        }

        int maxLen = 0;
        int[] mountLens= new int[n];
        for (int i = 0; i < mountLens.length; i++) {
             mountLens[i]=incr[i] + decr[i] - 1;

        }
        for (int i = 1; i < n-1; i++) {

            if(decr[i]>1 && incr[i]>1)
             maxLen = Math.max(maxLen,mountLens[i]);
        }

         return nums.length-maxLen;
    }

    public static void main(String[] args) {
        MinRemovalsToMakeMountainArray soln= new MinRemovalsToMakeMountainArray();
        int[] test1 = {2,1,1,5,6,2,3,1};
        System.out.println(soln.minimumMountainRemovals(test1)); // Expected: 3

        int[] test2 = {100,92,89,77,74,66,64,66,64};
        System.out.println(soln.minimumMountainRemovals(test2)); // Expected: 6

        int[] test3 = {9,8,1,7,6,5,4,3,2,1};
        System.out.println(soln.minimumMountainRemovals(test3)); // Expected: 2

        int[] test4 = {1,2,3,4,4,3,2,1};
        System.out.println(soln.minimumMountainRemovals(test4)); // Expected: 1
    }
}
