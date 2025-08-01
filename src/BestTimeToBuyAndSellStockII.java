import java.util.Arrays;

public class BestTimeToBuyAndSellStockII {

    public int maxProfit(int[] prices) {


        int current=Integer.MAX_VALUE;
        int profit=0;
        for(int price:prices){
            if(price<current)
            {
                current=price;
            }
            else if(price-current>0){
                profit+=price-current;
                current=price;

            }

        }
        return profit;

    }


    public int maxProfit2(int[] prices) {
        int[][] dp= new int[2][prices.length];
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);
        int ans=findProfit(prices,0,0,dp);
        return dp[0][0];

    }

    public int findProfit(int[]prices, int index, int bought, int[][] dp){

        int profit=0;
        if(index>=prices.length){
            return 0;
        }
        if(dp[bought][index]!=-1) return  dp[bought][index];
        if (bought == 0) {
            // We can BUY
            profit = Math.max(
                    -prices[index] + findProfit(prices, index + 1, 1, dp), // Buy
                    findProfit(prices, index + 1, 0, dp)                    // Skip
            );
        } else {
            // We can SELL
            profit = Math.max(
                    prices[index] + findProfit(prices, index + 1, 0, dp),  // Sell
                    findProfit(prices, index + 1, 1, dp)                   // Skip
            );
        }

        dp[bought][index]=profit;

        return profit;
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII stockII= new BestTimeToBuyAndSellStockII();
        System.out.println(stockII.maxProfit2(new int[]{7,1,5,3,6,4}));
    }
}
