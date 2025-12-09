import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[]dp= new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        int ans= solve(coins,amount,dp);
        if(ans==amount) return -1;
        return ans;
    }

    public int solve(int []coins,int amount,int[]dp){
        if(amount==0) return 0;
        if(amount<0) return Integer.MAX_VALUE;
        if(dp[amount]!=Integer.MAX_VALUE) return dp[amount];

        for (int coin : coins) {
            int res=solve(coins,amount-coin,dp);
            if(res!=Integer.MAX_VALUE){
                dp[amount]=Math.min(dp[amount],1+res);
            }
        }
        return dp[amount];
    }

    public int coinChange2(int[] coins, int amount) {

        int []dp = new int[amount+1];
        Arrays.fill(dp,-1);

        int ans=dfs(coins, amount, dp);
        return ans;

    }

    public int dfs(int[]coins,int amount,int[]dp){
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (dp[amount] != -1) return dp[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, amount - coin, dp);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }

        dp[amount] = min;
        return min;
    }



    public static void main(String[] args) {
        CoinChange  coinChange= new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1,2,5},11));
        System.out.println(coinChange.coinChange(new int[]{1},3));
    }


    /*
    [186,419,83,408]
    amount =
            6249

    Use Testcase
    Output
    -1
    */

}
