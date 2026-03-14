public class BestTimeToBuyAndSellStockUsingStrategy {

    public long maxProfit(int[] prices, int[] strategy, int k) {
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += (long) prices[i] * strategy[i];
        }
        ans = Math.max(ans, sum);
        for (int i = 0; i < k / 2; i++) {
            if (strategy[i] == 1) {
                sum -= prices[i];
            } else if (strategy[i] == -1) {
                sum += prices[i];
            }
        }

        for (int i = k / 2; i < k; i++) {
            if (strategy[i] == -1) {
                sum += 2L * prices[i];
            } else if (strategy[i] == 0) {
                sum += prices[i];
            }
        }
        ans = Math.max(ans, sum);

        for (int i = 1; i < prices.length - k+1; i++) {
            if (strategy[i-1] == 1) {
                sum += prices[i-1];
            } else if (strategy[i-1] == -1) {
                sum -= prices[i-1];
            }
            sum -= prices[i-1 +(k/2)];
            if (strategy[i + k - 1] == -1) {
                sum += 2L * prices[i + k - 1];
            } else if (strategy[i + k - 1] == 0) {
                sum += prices[i + k - 1];
            }
            ans = Math.max(ans, sum);
        }
        return ans;

    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockUsingStrategy obj =
                new BestTimeToBuyAndSellStockUsingStrategy();

        // Test case 3
        int[] prices3 = {4,7,13};
        int[] strategy3 = {-1, -1, 0};
        int k3 = 2;
        System.out.println(obj.maxProfit(prices3, strategy3, k3));
        // Expected: 9

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


    }

}
