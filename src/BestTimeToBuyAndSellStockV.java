import java.util.Arrays;

public class BestTimeToBuyAndSellStockV {

    public long maximumProfit(int[] prices, int k) {

        long[][][][]dp= new long[2][k+1][prices.length+1][prices.length+1];
        for (long[][][] ints : dp) {
            for (long[][] anInt : ints) {
                for (long[] longs : anInt) {
                    Arrays.fill(longs,-1);
                }

            }
        }
        long ans=solve(prices,k,0,0,0,dp);
        return ans;
    }
    //bs
    //0 nothing
    //1 bought
    public long solve(int[]price,int k,int bs,int prev,int index,long[][][][]dp){
        if(k==0) return 0;
        if(index==price.length)return 0;
        if(dp[bs][k][index][prev]!=-1) return dp[bs][k][index][prev];
        long take=0;
        long skip=0;
        if(bs==1){
            take=Math.abs(price[index]-price[prev])+ solve(price,k-1,0,0,index+1,dp);
        }
        else{
            take=solve(price,k,1,index,index+1,dp);
        }
        skip=solve(price,k,bs,prev,index+1,dp);
        return dp[bs][k][index][prev]= Math.max(take,skip);
    }

    public long maximumProfit2(int[]prices,int k){
        int n = prices.length;
        long[][][][] dp = new long[2][k + 1][n + 1][n + 1];

        // initialize with 0 (base cases already 0)
        for (int bs = 0; bs <= 1; bs++) {
            for (int kk = 0; kk <= k; kk++) {
                for (int i = 0; i <= n; i++) {
                    Arrays.fill(dp[bs][kk][i], 0);
                }
            }
        }

        // index from n-1 -> 0
        for (int index = n - 1; index >= 0; index--) {
            for (int kk = 1; kk <= k; kk++) {
                for (int bs = 0; bs <= 1; bs++) {
                    for (int prev = 0; prev <= n; prev++) {

                        long take = 0;
                        long skip = dp[bs][kk][index + 1][prev];

                        if (bs == 1) {
                            if (prev < n) {
                                take = Math.abs(prices[index] - prices[prev])
                                        + dp[0][kk - 1][index + 1][0];
                            }
                        } else {
                            take = dp[1][kk][index + 1][index];
                        }

                        dp[bs][kk][index][prev] = Math.max(take, skip);
                    }
                }
            }
        }

        return dp[0][k][0][0];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockV obj = new BestTimeToBuyAndSellStockV();

        int[] prices1 = {1, 7, 9, 8, 2};
        int k1 = 2;
        System.out.println(obj.maximumProfit2(prices1, k1));
        // Expected: 14

        int[] prices2 = {12, 16, 19, 19, 8, 1, 19, 13, 9};
        int k2 = 3;
        System.out.println(obj.maximumProfit2(prices2, k2));
        // Expected: 36
    }

}
