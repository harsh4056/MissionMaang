import java.util.Arrays;

public class UnboundedKnapSack {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][]dp = new int[w+1][n];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
       return findProfit(w,profit,weight,n-1,dp);
    }
    public static int findProfit(int w, int[] profit, int[] weight, int index, int[][] dp){

        if(index==0){
            if(w>=weight[index]){
              return   (w/weight[index]) * profit[index];
            }
            return 0;
        }
        if(dp[w][index]!=-1) return dp[w][index];



        int take=0;
        if(w>=weight[index]){
            take=profit[index]+findProfit(w-weight[index],profit,weight,index, dp);
        }
        int notTake=findProfit(w,profit,weight,index-1, dp);
        dp[w][index]=Math.max(take,notTake);
        return Math.max(take,notTake);
    }

    public static void main(String[] args) {
        // Test Case 1
        int n1 = 3, w1 = 15;
        int[] profit1 = {7, 2, 4};
        int[] weight1 = {5, 10, 20};
        System.out.println(UnboundedKnapSack.unboundedKnapsack(n1, w1, profit1, weight1)); // Expected: 21

        // Test Case 2
        int n2 = 2, w2 = 3;
        int[] profit2 = {6, 12};
        int[] weight2 = {4, 17};
        System.out.println(UnboundedKnapSack.unboundedKnapsack(n2, w2, profit2, weight2)); // Expected: 0

        // Test Case 3
        int n3 = 4, w3 = 8;
        int[] profit3 = {1, 3, 4, 5};
        int[] weight3 = {1, 2, 3, 4};
        System.out.println(UnboundedKnapSack.unboundedKnapsack(n3, w3, profit3, weight3)); // Expected: 12
    }

}
