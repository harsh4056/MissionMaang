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

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII stockII= new BestTimeToBuyAndSellStockII();
        System.out.println(stockII.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
