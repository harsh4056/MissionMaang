import java.util.Arrays;

public class MaximumAmountOfMoneyRobotCanEarn {
    public int maximumAmount2(int[][] coins) {

        int[][][]dp= new int[coins.length][coins[0].length][3];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,-1);
            }
        }
        int ans=solve(0,0,2,coins,dp);
        return ans;
    }

    public int maximumAmount(int[][] coins) {

        int[][][]dp= new int[coins.length+1][coins[0].length+1][3];
        int n=coins.length;
        int m=coins[0].length;
        for (int i = 0; i < n; i++) {
            dp[i][m-1][0]=(int)(-1e9);
            dp[i][m-1][1]=(int)(-1e9);
            dp[i][m-1][2]=(int)(-1e9);
        }

        for (int j = 0; j < m; j++) {
            dp[n-1][j][0]=(int)(-1e9);
            dp[n-1][j][1]=(int)(-1e9);
            dp[n-1][j][2]=(int)(-1e9);
        }
        for(int ign=0;ign<3;ign++){
            if(coins[n-1][m-1]<0 && ign>0){
                dp[n-1][m-1][ign]=0;
            }
            else{
                dp[n-1][m-1][ign]=coins[n-1][m-1];
            }
        }

        for (int i = n-1; i >=0 ; i--) {
            for (int j = m-1; j >=0 ; j--) {
                for (int ign= 0; ign <3 ; ign++) {

                    int take1,take2,ignore1=(int)(-1e9),ignore2=(int)(-1e9);
                    take1=coins[i][j]+dp[i+1][j][ign];
                    take2=coins[i][j]+dp[i][j+1][ign];
                    if(coins[i][j]<0 && ign>0){
                        ignore1=dp[i+1][j][ign-1];
                        ignore2=dp[i][j+1][ign-1];
                    }
                     dp[i][j][ign]=Math.max(Math.max(take1,take2),Math.max(ignore1,ignore2));
                }
            }
        }
        return dp[0][0][2];
    }

    public int solve(int i, int j, int ignore, int[][]coins, int[][][] dp){
        if(i>=coins.length|| j==coins[0].length) return (int)(-1e9);
        if(i==coins.length-1 && j==coins[0].length-1){
            if(ignore>0 && coins[i][j]<0) return 0;
            return coins[i][j];
        }
        if(dp[i][j][ignore]!=-1) return dp[i][j][ignore];
        int take1,take2,ignore1=(int)(-1e9),ignore2=(int)(-1e9);
        take1=coins[i][j]+solve(i+1,j,ignore,coins, dp);
        take2=coins[i][j]+solve(i,j+1,ignore,coins, dp);
        if(coins[i][j]<0 && ignore>0){
          ignore1=solve(i+1,j,ignore-1,coins, dp);
          ignore2=solve(i,j+1,ignore-1,coins, dp);
        }
        return dp[i][j][ignore]=Math.max(Math.max(take1,take2),Math.max(ignore1,ignore2));
    }

    public static void main(String[] args) {
        MaximumAmountOfMoneyRobotCanEarn soln = new MaximumAmountOfMoneyRobotCanEarn();
        int[][] coins3 = {
                {-6 , -15, -16, -8},
                {-10, 11 , 6  , 16},
                {1  , 2  , 18 , 12},
                {15 , 19 , 4  , 17}
        };
        System.out.println(soln.maximumAmount(coins3)); // Expected: 64
        int[][] coins1 = {
                {0, 1, -1},
                {1, -2, 3},
                {2, -3, 4}
        };
        System.out.println(soln.maximumAmount(coins1)); // Expected: 8

        int[][] coins2 = {
                {10, 10, 10},
                {10, 10, 10}
        };
        System.out.println(soln.maximumAmount(coins2)); // Expected: 40
    }
}
