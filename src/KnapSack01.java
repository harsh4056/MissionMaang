import java.util.Arrays;

public class KnapSack01 {

    int knapsack(int[] weights, int[] values, int W){
        int[]memo= new int[W+1];
        Arrays.fill(memo,-1);
        dfs(weights,values,W,memo,0,0);
        return memo[0];
    }
    int dfs(int[] weights, int[] values, int W,int []memo,int i,int j){

        if(W<0){
            return Integer.MIN_VALUE;
        }
        if(W==0){
            return 0;
        }
        if(memo[i]!=-1) return memo[i];
        int max=-1;
        for (int k = j, weightsLength = weights.length; k < weightsLength; k++) {
            int weight = weights[k];
            int profit = dfs(weights, values, W - weight, memo, i + 1,j+1);
            max = Math.max(max, values[j]+profit);
        }
        memo[i]=max;
        return max;

    }

    public static void main(String[] args) {
        KnapSack01 knapsack = new KnapSack01();

       /* int[] weights1 = {1, 3, 4};
        int[] values1 = {15, 20, 30};
        int W1 = 4;
        System.out.println(knapsack.knapsack(weights1, values1, W1)); // Expected: 30*/

        int[] weights2 = {2, 3, 5};
        int[] values2 = {10, 20, 50};
        int W2 = 5;
        System.out.println(knapsack.knapsack(weights2, values2, W2)); // Expected: 50

        int[] weights3 = {1, 2, 3};
        int[] values3 = {10, 15, 40};
        int W3 = 6;
        System.out.println(knapsack.knapsack(weights3, values3, W3)); // Expected: 65
    }

}
