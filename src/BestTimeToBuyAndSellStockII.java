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

        int ans=findProfit(prices,0,true);
        return ans;

    }

    public int findProfit(int[]prices,int index,boolean bought){

        int profit=0;
        if(index>=prices.length){
            return 0;
        }
        if(!bought){
            profit=Math.max(prices[index]+findProfit(prices,index+1,true),findProfit(prices,index+1,false));
        }
        else{
            profit=Math.max(-prices[index]+findProfit(prices,index+1,false),findProfit(prices,index+1,true));
        }
        return profit;
    }


    public static void main(String[] args) {
        BestTimeToBuyAndSellStockII stockII= new BestTimeToBuyAndSellStockII();
        System.out.println(stockII.maxProfit2(new int[]{7,1,5,3,6,4}));
    }
}
