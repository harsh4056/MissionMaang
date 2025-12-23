public class BestTimeToBuyAndSellStockUsingStrategy {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        long sum=0;
        int n= prices.length;
        long[]prefix= new long[n];
        prefix[0]= (long) prices[0] *strategy[0];
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            prefix[i]=prefix[i-1]+((long) price *strategy[i]);
        }
        for (int i = 0; i < prices.length; i++) {
            int price = prices[i];
            int strat=strategy[i];
            sum+= (long) price *strat;
        }
        long ssum=0;
        for(int i=k/2;i<k;i++){
            ssum+=prices[i];
        }
        ssum+=prefix[n-1]-prefix[k-1];
        sum=Math.max(ssum,sum);
        ssum=0;
        for(int i=k;i<n;i++){
            ssum+= (long) strategy[i - k] *prices[i-k];
            //ssum-= (long) strategy[i - (k / 2)] *prices[i-(k/2)];
            ssum+= (long) prices[i];
            long preSum=prefix[n-1]-prefix[i];

            sum=Math.max(sum,ssum+preSum);
        }
        return sum;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockUsingStrategy obj =
                new BestTimeToBuyAndSellStockUsingStrategy();

        // Test case 1 (Example 1)
        int[] prices1 = {4, 2, 8};
        int[] strategy1 = {-1, 0, 1};
        int k1 = 2;
        System.out.println(obj.maxProfit(prices1, strategy1, k1));
        // Expected: 10

        // Test case 2 (Example 2)
        int[] prices2 = {5, 4, 3};
        int[] strategy2 = {1, 1, 0};
        int k2 = 2;
        System.out.println(obj.maxProfit(prices2, strategy2, k2));
        // Expected: 9

        // Test case 3
        int[] prices3 = {4,7,13};
        int[] strategy3 = {-1, -1, 0};
        int k3 = 2;
        System.out.println(obj.maxProfit(prices3, strategy3, k3));
        // Expected: 23
    }

}
