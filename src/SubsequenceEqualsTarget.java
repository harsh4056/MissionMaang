public class SubsequenceEqualsTarget {

    public  boolean subsetSumToK( int k, int[] arr){
        Boolean[][]dp = new Boolean[arr.length][k+1];
        return find(k, arr,arr.length-1,dp);

    }
    public boolean find(int target, int[]arr, int index, Boolean[][]dp){
        if(target<0){
            return false;
        }
        if(index<0){
           return target==0;
        }
        if(dp[index][target]!=null) return dp[index][target];
        if(find(target-arr[index], arr,index-1,dp)||find(target, arr,index-1,dp)){

            return true;
        }
        dp[index][target]=false;
        return false;
    }
    public static void main(String[] args) {
        SubsequenceEqualsTarget solution = new SubsequenceEqualsTarget();

        int[] arr1 = {1, 2, 3, 4};
        int k1 = 6;

        System.out.println(solution.subsetSumToK(k1, arr1)); // Expected: true
        int[] arr2 = {2, 4, 6, 8};
        int k2 = 5;

        System.out.println(solution.subsetSumToK(k2, arr2)); // Expected: false
        int[] arr3 = {3, 34, 4, 12, 5, 2};
        int k3 = 9;

        System.out.println(solution.subsetSumToK(k3, arr3)); // Expected: true
    }

}

