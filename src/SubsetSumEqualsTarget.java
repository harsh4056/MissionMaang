public class SubsetSumEqualsTarget {

    public static boolean subsetSumToK(int n, int k, int[] arr){
        Boolean[][]dp = new Boolean[n][k+1];
        boolean ans= solve(arr,k,0,dp);
        return ans;
    }
    public static boolean solve(int[]arr,int k,int index,Boolean[][]dp){

        if(index==arr.length) return false;
        if(k==0) return true;
        if(dp[index][k]!=null)return dp[index][k];
        boolean take=false;
        if(k-arr[index]>=0)
         take = solve(arr,k-arr[index],index+1,dp);
        boolean skip= solve(arr,k,index+1,dp);
        return dp[index][k]=take||skip;
    }

    public static boolean subsetSumToK2(int n, int k, int[] arr) {

        boolean[][] dp = new boolean[n][k+1];

        // k == 0 base case
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        for (int index = n-1; index >= 0; index--) {
            for (int j = 1; j <= k; j++) {

                boolean take = false;
                if (j - arr[index] >= 0) {
                    if (index + 1 < n)
                        take = dp[index+1][j - arr[index]];
                }

                boolean skip = false;
                if (index + 1 < n)
                    skip = dp[index+1][j];

                dp[index][j] = take || skip;
            }
        }
        return dp[0][k];

    }


    public static void main(String[] args) {

        // Test case 1
        int[] arr1 = {1, 2, 3, 4};
        int k1 = 4;
        System.out.println(subsetSumToK(arr1.length, k1, arr1));
        // Expected: true  (subset {4} or {1,3})

        // Test case 2
        int[] arr2 = {2, 5, 1, 6};
        int k2 = 4;
        System.out.println(subsetSumToK(arr2.length, k2, arr2));
        // Expected: false

        // Test case 3
        int[] arr3 = {3, 34, 4, 12, 5, 2};
        int k3 = 9;
        System.out.println(subsetSumToK(arr3.length, k3, arr3));
        // Expected: true (subset {4,5})
    }


}
