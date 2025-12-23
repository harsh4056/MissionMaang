import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CoinChange {

    public int coinChange2(int[] coins, int amount) {

        int[][]dp= new int[amount+1][coins.length+1];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        int ans=solve(coins,amount,0,dp);
        if(ans==1_000_000_000)return -1;
        return ans;
    }
    public int solve(int[]coins,int amount,int index,int[][]dp){

        if(index==coins.length) {
            if(amount==0) return 0;
            return 1_000_000_000;
        }
        if(dp[amount][index]!=-1) return dp[amount][index];
        int take=1_000_000_000;
        if(amount-coins[index]>=0){
            take=1+solve(coins,amount-coins[index],index,dp);
        }
        int skip= solve(coins,amount,index+1,dp);

        return dp[amount][index]=Math.min(take,skip);
    }
    int coinChange(int[] coins, int amount){
        int n=coins.length;
        int[][]dp= new int[amount+1][n+1];

        // base: index == n
        for (int a = 1; a <= amount; a++) {
            dp[a][n] = 1_000_000_000;
        }
        for(int i=n-1;i>=0;i--){
            for (int a = 0; a <= amount; a++) {

                int take=1_000_000_000;
                if(a-coins[i]>=0){
                    take= 1+dp[a-coins[i]][i];
                }
                int skip=dp[a][i+1];
                dp[a][i]=Math.min(take,skip);

            }
        }
        return dp[amount][0]==1_000_000_000?-1:dp[amount][0];
    }




    public static void main(String[] args) {
        CoinChange  coinChange= new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1,2,5},11));
        System.out.println(coinChange.coinChange(new int[]{1,2,5},20));
        System.out.println(coinChange.coinChange(new int[]{1},0));
        System.out.println(coinChange.coinChange(new int[]{2},3));
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
