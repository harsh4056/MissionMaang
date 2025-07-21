import java.util.Arrays;

public class BestTimeToBuyAndSellStockIV {

    public int maxProfit(int k, int[] prices) {



        int[][][] dp = new int[k+1][2][prices.length];
        for (int[][] ints : dp) {
            Arrays.fill(ints[0],-1);
            Arrays.fill(ints[1],-1);
        }
        findProfit(prices,0,0,k,dp);
        return dp[k][0][0];

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
        BestTimeToBuyAndSellStockIV solution = new BestTimeToBuyAndSellStockIV();

        System.out.println(solution.maxProfit(4, new int[]{1,2,4,2,5,7,2,4,9,0})); //
        System.out.println(solution.maxProfit(2, new int[]{2,4,1})); // Expected: 2
        System.out.println(solution.maxProfit(2, new int[]{3,2,6,5,0,3})); // Expected: 7
        System.out.println(solution.maxProfit(1, new int[]{1,2})); // Expected: 1
    }

}
