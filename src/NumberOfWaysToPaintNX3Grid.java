import java.util.Arrays;

public class NumberOfWaysToPaintNX3Grid {

    public int numOfWays(int n) {
        int[][][]dp = new int[3][n][3];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,-1);
            }
        }
        return solve(n,0,0,-1,dp);
    }
    public int solve(int n, int i, int j, int color, int[][][] dp){

        if(i>=3 || j>=n) return 0;
        if(i==2 && j==n-1) return 1;




        return 0;
    }
}
