import java.util.Arrays;

public class RodCuttingProblem {
    public static int cutRod(int price[], int n) {
        int dp[][] =new int[price.length][price.length+1];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }

        return solve(price,price.length-1,price.length,dp);

    }
    public static int solve(int price[], int index, int target, int dp[][] ){
    return 0;
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
