public class BestTimeToBuyAndSellStock {
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

            }

        }
        return profit;
    }
}
