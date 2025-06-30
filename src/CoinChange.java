import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        if(amount==0)
            return 0;
        int []dp= new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE-1);
        for (int coin : coins) {
            if(coin<=amount) {
                dp[coin] = 1;
            }
        }
        for (int i = 1; i <=amount ; i++) {
            for (int coin : coins) {
                if(i-coin>=1){
                    dp[i]=Math.min(dp[i-coin]+1, dp[i]);
                }
            }
        }
        if(dp[amount]==Integer.MAX_VALUE-1)
            return -1;
        return dp[amount];


    }

    public int coinChange2(int[] coins, int amount) {

        int []memo = new int[amount+1];
        Arrays.fill(memo,-1);

        int ans=dfs(coins, amount, memo);
        return ans;

    }

    public int dfs(int[]coins,int amount,int[]memo){
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (memo[amount] != -1) return memo[amount];

        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int res = dfs(coins, amount - coin, memo);
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, 1 + res);
            }
        }

        memo[amount] = min;
        return min;
    }



    public static void main(String[] args) {
        CoinChange  coinChange= new CoinChange();
        System.out.println(coinChange.coinChange2(new int[]{1,2,5},10000));
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
