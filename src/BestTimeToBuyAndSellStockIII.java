public class BestTimeToBuyAndSellStockIII {

    public int maxProfit(int[] prices) {

        int[][]dp= new int[prices.length][prices.length];
        for (int i = 0; i <prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                if(i!=j ){
                    if(i<j && prices[i] < prices[j]) {
                         dp[i][j] = prices[j] - prices[i];
                    }
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIII solution = new BestTimeToBuyAndSellStockIII();
        solution.maxProfit(new int[]{3,3,5,0,0,3,1,4});
    }
}
