import java.util.Arrays;

public class BestTimeToBuyAndSellStockIII {


    public int maxProfit(int[] prices) {

        int[][][] dp = new int[3][2][prices.length];
        for (int[][] ints : dp) {
            Arrays.fill(ints[0],-1);
            Arrays.fill(ints[1],-1);
        }
        findProfit(prices,0,0,2,dp);
        return dp[2][0][0];

    }

    public int findProfit(int []prices, int index, int bought, int transactions, int[][][] dp){
        int profit=0;
        if(index>=prices.length){
            return 0;
        }
        if(dp[transactions][bought][index]!=-1) return dp[transactions][bought][index];
        if(transactions>0) {
            if (bought == 0) {
                // We can BUY
                profit = Math.max(
                        -prices[index] + findProfit(prices, index + 1, 1, transactions, dp), // Buy
                        findProfit(prices, index + 1, 0, transactions, dp)                    // Skip
                );
            } else {
                // We can SELL
                profit = Math.max(
                        prices[index] + findProfit(prices, index + 1, 0, transactions - 1, dp),  // Sell
                        findProfit(prices, index + 1, 1, transactions, dp)                   // Skip
                );
            }
        }
        dp[transactions][bought][index]=profit;



        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII solution = new BestTimeToBuyAndSellStockIII();
        System.out.println(
        solution.maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
