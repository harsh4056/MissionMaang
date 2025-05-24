public class BestTimeToBuyAndSellStockIII {


    public int maxProfit(int[] prices) {
        int current=Integer.MAX_VALUE;
        int[] leftProfit=new int[prices.length];
        int[] rightProfit=new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            if (price < current) {
                current = price;
            } else if (price - current > 0) {
                leftProfit[i] = price - current;
                int current2=Integer.MAX_VALUE;
                for (int j = i; j < prices.length; j++) {
                    int price2=prices[j];
                    if (price2 < current2) {
                        current2 = price2;
                    } else if (price2 - current2 > 0) {
                        rightProfit[i] = price2 - current2;
                    }
                }
            }
        }
        int max=0;
        for (int i = 0; i < rightProfit.length; i++) {
            max=Math.max(max,rightProfit[i]+leftProfit[i]);

        }
        return max;
    }
}
