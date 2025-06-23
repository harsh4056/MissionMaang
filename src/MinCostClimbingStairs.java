public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {

        for (int i = 2; i < cost.length; i++) {
            cost[i]+=Math.min(cost[i-1],cost[i-2]);
        }
        return Math.min(cost[cost.length-1],cost[cost.length-2]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs obj = new MinCostClimbingStairs();

        /*// Test case 1
        int[] cost1 = {10, 15, 20};
        System.out.println(obj.minCostClimbingStairs(cost1)); // Expected: 15*/

        // Test case 2
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(obj.minCostClimbingStairs(cost2)); // Expected: 6

        // Test case 3
        int[] cost3 = {0, 1, 2, 2};
        System.out.println(obj.minCostClimbingStairs(cost3)); // Expected: 3
    }

}
