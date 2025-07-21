import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithTransactionFee {

    public int maxProfit(int[] prices, int fee) {
        int[][] dp= new int[2][prices.length];
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);
        int ans=findProfit(prices,0,0,dp,fee);
        return dp[0][0];
    }


    public int findProfit(int[]prices, int index, int bought, int[][] dp, int fee){

        int profit=0;
        if(index>=prices.length){
            return 0;
        }
        if(dp[bought][index]!=-1) return  dp[bought][index];
        if (bought == 0) {
            // We can BUY
            profit = Math.max(
                    -prices[index] + findProfit(prices, index + 1, 1, dp, fee), // Buy
                    findProfit(prices, index + 1, 0, dp, fee)                    // Skip
            );
        } else {
            // We can SELL
            profit = Math.max(
                    (prices[index]-fee) + findProfit(prices, index + 1, 0, dp, fee),  // Sell
                    findProfit(prices, index + 1, 1, dp, fee)                   // Skip
            );
        }

        dp[bought][index]=profit;

        return profit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithTransactionFee solution = new BestTimeToBuyAndSellStockWithTransactionFee();

        System.out.println(solution.maxProfit(new int[]{1,3,2,8,4,9}, 2)); // Expected: 8
        System.out.println(solution.maxProfit(new int[]{1,3,7,5,10,3}, 3)); // Expected: 6
        System.out.println(solution.maxProfit(new int[]{1,2}, 2)); // Expected: 0
    }

}
