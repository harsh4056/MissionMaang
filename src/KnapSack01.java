import java.util.Arrays;

public class KnapSack01 {

    int knapsack(int[] weights, int[] values, int W){
            int[][]memo= new int[W+1][values.length+1];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }

        int ans= maxValue(weights,values,weights.length-1,W,memo);
        return ans;

    }

    static int maxValue(int[] weight, int[] value, int index, int maxWeight, int[][] memo){
        if(index==0){
            if(weight[index]<=maxWeight)
                return value[index];
            else return 0;
        }

        if(memo[maxWeight][index]!=-1) {
            return memo[maxWeight][index];
        }
        int take=Integer.MIN_VALUE;
        if(weight[index]<=maxWeight) {
            take = value[index] + maxValue(weight, value, index - 1, maxWeight - weight[index], memo);
        }
        int notTake= maxValue(weight,value,index-1,maxWeight, memo);
        memo[maxWeight][index]=Math.max(take,notTake);
        return memo[maxWeight][index];

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
