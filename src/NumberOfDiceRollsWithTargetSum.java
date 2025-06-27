import java.util.Arrays;

public class NumberOfDiceRollsWithTargetSum {

    public int numRollsToTarget(int n, int k, int target) {

        int[][]dp = new int[n+1][target+1];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        dfs(dp,n,k,target);
        return  dp[n][target];


    }

    public int dfs(int[][] dp,int n, int k, int target){
        if(target==0 && n==0){
           return 1;
        }
        if(target <0 || n <0){
            return 0;
        }

        if(dp[n][target]!=-1){
            return dp[n][target];
        }
        long ways=0;
        for (int i = 1; i <=k ; i++) {
            if(n >0 && target-i>=0)
             ways+=dfs(dp,n-1,k,target-i);
            ways=ways%(1000000007L);
        }
        dp[n][target]= Math.toIntExact(ways);
        return Math.toIntExact(ways);
    }
    public static void main(String[] args) {
        NumberOfDiceRollsWithTargetSum sol = new NumberOfDiceRollsWithTargetSum();

        // Test case 1
        //System.out.println(sol.numRollsToTarget(1, 6, 3)); // Expected: 1

        // Test case 2
        System.out.println(sol.numRollsToTarget(2, 6, 2)); // Expected: 6

        // Test case 3
        System.out.println(sol.numRollsToTarget(8, 10, 21)); // Expected: 1
        // Test case 4
        System.out.println(sol.numRollsToTarget(30, 30, 500)); // Expected: 1
    }


}
