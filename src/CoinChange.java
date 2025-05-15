import java.util.Arrays;

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

    public static void main(String[] args) {
        CoinChange  coinChange= new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1},1));
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
