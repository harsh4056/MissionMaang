import java.lang.reflect.Array;
import java.util.Arrays;

public class CoinChangeII {

    public int change(int amount, int[] coins) {
        int [][]dp= new int[amount+1][coins.length];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
         int ans=solve(amount,coins,0,dp);
         return ans;
    }

    public int solve(int amount, int[] coins, int index, int[][] dp){
        if(amount==0) return 1;
        if(index==coins.length){
            return 0;
        }
        if(dp[amount][index]!=-1) return dp[amount][index];
        int take=0;
        if(amount-coins[index]>=0){
            take =solve(amount-coins[index],coins,index,dp);
        }
        int skip= solve(amount,coins,index+1,dp);
        return dp[amount][index]=take+skip;
    }

    public int change2(int amount,int[]coins){
        int n=coins.length;
        int[][]dp = new  int[amount+1][n+1];

        for(int i=1;i<=n;i++){
            dp[0][i]=1;
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<=amount;j++){
                int take=0;
                if(j-coins[i]>=0){
                    take =dp[(j-coins[i])][i];
                }
                int skip= dp[j][i+1];
                dp[j][i]=take+skip;
            }

        }

        return dp[amount][0];
    }
    public static void main(String[] args) {
        CoinChangeII solution = new CoinChangeII();

        System.out.println(solution.change2(5, new int[]{1, 2, 5})); // Expected: 4
        System.out.println(solution.change2(3, new int[]{2}));       // Expected: 0
        System.out.println(solution.change2(10, new int[]{5}));     // Expected: 1
    }

}
