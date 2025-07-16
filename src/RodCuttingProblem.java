import java.util.Arrays;

public class RodCuttingProblem {
    public static int cutRod(int price[], int n) {
        int dp[][] =new int[price.length][price.length+1];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }

        return findMaxCuts(price,price.length-1,price.length,dp);

    }
    public static int findMaxCuts(int price[],int index,int target,int dp[][] ){
            if(index==0){
                return price[index]*target;
            }
            if(dp[index][target]!=-1) return dp[index][target];
        int take=Integer.MIN_VALUE;
        if(target>=(index+1)){
            take=price[index]+findMaxCuts(price,index,target-(index+1),dp);
        }
        int notTake= findMaxCuts(price,index-1,target,dp);
        dp[index][target]=Math.max(take,notTake);
        return Math.max(take,notTake);
    }
    public static void main(String[] args) {
        // Test Case 1
        int[] price1 = {2 ,5 ,7 ,8 ,10};
        int n1 = 5;
        System.out.println(cutRod(price1, n1)); // Expected: 12



        // Test Case 3
        int[] price3 = {3, 5, 8, 9, 10, 17, 17, 20};
        int n3 = 8;
        System.out.println(cutRod(price3, n3)); // Expected: 24
    }

}
