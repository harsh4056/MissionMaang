import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int [][]dp= new int[amount+1][coins.length];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
         int ans=dfs(amount,coins,coins.length-1,dp);
         return ans;
    }

    public int dfs(int amount, int[] coins, int index, int[][] dp){


        if(amount<0){
            return 0;
        }
        if(amount==0){
            return 1;
        }
        if(index==0){
            if(amount%coins[index]==0){
                return 1;
            }
            return 0;
        }
        if(dp[amount][index]!=-1) return dp[amount][index];
        int take=0;
        if(amount>=coins[index]){
            take=dfs(amount-coins[index],coins,index, dp);
        }
        int notTake=dfs(amount,coins,index-1, dp);
        dp[amount][index]=take+notTake;
        return take+notTake;

    }
    public static void main(String[] args) {
        CoinChangeII solution = new CoinChangeII();

        System.out.println(solution.change(5, new int[]{1, 2, 5})); // Expected: 4
        //System.out.println(solution.change(5, new int[]{1,2,5}));       // Expected: 0
        System.out.println(solution.change(10, new int[]{5}));     // Expected: 1
    }

}
