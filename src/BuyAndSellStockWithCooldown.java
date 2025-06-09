import java.util.HashMap;
import java.util.Map;

public class BuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        Map<String, Integer> memo = new HashMap<>();
        return dfs(0, true, prices, memo);
    }

    private int dfs(int i, boolean canBuy, int[] prices, Map<String, Integer> memo) {
        if (i >= prices.length) return 0;

        String key = i + "-" + canBuy;
        if (memo.containsKey(key)) return memo.get(key);

        int result;
        if (canBuy) {
            int buy = -prices[i] + dfs(i + 1, false, prices, memo);
            int skip = dfs(i + 1, true, prices, memo);
            result = Math.max(buy, skip);
        } else {
            int sell = prices[i] + dfs(i + 2, true, prices, memo); // cooldown
            int skip = dfs(i + 1, false, prices, memo);
            result = Math.max(sell, skip);
        }

        memo.put(key, result);
        return result;
    }


    public static void main(String[] args) {
        BuyAndSellStockWithCooldown solution = new BuyAndSellStockWithCooldown();

        int[] prices1 = {1, 2, 3, 0, 7};
        System.out.println(solution.maxProfit(prices1)); // Expected: 8

        int[] prices2 = {1};
        System.out.println(solution.maxProfit(prices2)); // Expected: 0

        int[] prices3 = {2, 1, 4};
        System.out.println(solution.maxProfit(prices3)); // Expected: 3

        int[] prices4 = {6, 1, 3, 2, 4, 7};
        System.out.println(solution.maxProfit(prices4)); // Expected: 6

        int[] prices5 = {1, 2, 4};
        System.out.println(solution.maxProfit(prices5)); // Expected: 3

        int[] prices6 = {1, 2, 3, 0, 2, 1, 4};
        System.out.println(solution.maxProfit(prices6)); // Expected: 5

    }

}
