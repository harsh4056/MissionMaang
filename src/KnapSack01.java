import java.util.Arrays;

public class KnapSack01 {

    int knapsack1(int[] weights, int[] values, int W){
            int[][]dp= new int[W+1][values.length+1];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }

        int ans= maxValue(weights,values,weights.length-1,W,dp);
        return ans;

    }

    static int maxValue(int[] weight, int[] value, int index, int maxWeight, int[][] dp){
        if(index==0){
            if(weight[index]<=maxWeight)
                return value[index];
            else return 0;
        }
        if(dp[maxWeight][index]!=-1) {
            return dp[maxWeight][index];
        }
        int take=Integer.MIN_VALUE;
        if(weight[index]<=maxWeight) {
            take = value[index] + maxValue(weight, value, index - 1, maxWeight - weight[index], dp);
        }
        int skip= maxValue(weight,value,index-1,maxWeight, dp);
        return dp[maxWeight][index]=Math.max(take,skip);


    }

    int knapsack(int[] weights, int[] values, int W){
        int n = weights.length;
        int[][] dp = new int[W + 1][n];

        // base case: index = 0
        for (int w = 0; w <= W; w++) {
            if (weights[0] <= w)
                dp[w][0] = values[0];
            else
                dp[w][0] = 0;
        }

        // fill table
        for (int i = 1; i < n; i++) {
            for (int w = 0; w <= W; w++) {
                int skip = dp[w][i - 1];
                int take = 0;
                if (weights[i] <= w) {
                    take = values[i] + dp[w - weights[i]][i - 1];
                }
                dp[w][i] = Math.max(take, skip);
            }
        }

        return dp[W][n - 1];
    }



    public static void main(String[] args) {
        KnapSack01 solution = new KnapSack01();

        System.out.println(solution.knapsack(new int[]{6, 5, 1, 5, 6, 5, 9}, new int[]{5, 3, 4, 9, 6, 1, 1}, 63)); // Expected: 29
        System.out.println(solution.knapsack(new int[]{1, 5, 6, 9, 7, 9, 7}, new int[]{1, 7, 1, 5, 1, 7, 7}, 37)); // Expected: 23
        System.out.println(solution.knapsack(new int[]{3,11}, new int[]{4,7}, 13)); // Expected: 4
        System.out.println(solution.knapsack(new int[]{7}, new int[]{1}, 1)); // Expected: 0
        System.out.println(solution.knapsack(new int[]{10}, new int[]{8}, 85)); // Expected: 8
        System.out.println(solution.knapsack(new int[]{7, 6, 9}, new int[]{3, 3, 5}, 51)); // Expected: 11
        System.out.println(solution.knapsack(new int[]{9}, new int[]{6}, 52)); // Expected: 6
        System.out.println(solution.knapsack(new int[]{1}, new int[]{4}, 53)); // Expected: 4
        System.out.println(solution.knapsack(new int[]{3, 9, 3, 8, 8, 7, 9, 5, 10}, new int[]{5, 1, 6, 10, 1, 6, 3, 7, 5}, 83)); // Expected: 44
    }


}
