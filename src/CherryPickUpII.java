import java.util.Arrays;

public class CherryPickUpII {

    public int cherryPickup(int[][] grid) {

        int[] directions= new int[]{-1,0,1};
        int [][][]dp = new int[grid.length][grid[0].length][grid[0].length];

        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,-1);
            }
        }
        findMaxCherry(grid,directions,0,0,grid[0].length-1,dp);

        return dp[0][0][grid[0].length-1];

    }


    public int  findMaxCherry(int[][] grid, int[] directions, int i, int j1, int j2, int[][][] dp){

        if(j1<0 ||j1>grid[0].length-1||j2<0 ||j2>grid[0].length-1){
            return  Integer.MIN_VALUE;
        }
        if(i==grid.length-1){
            if(j1==j2){
               return grid[i][j1];
            }
            else {
              return   grid[i][j1] + grid[i][j2] ;
            }
        }
        if(dp[i][j1][j2]!=-1) return  dp[i][j1][j2];
        int max=Integer.MIN_VALUE;
        for (int d1 = 0; d1 < directions.length; d1++) {
            for (int d2 = 0; d2 < directions.length; d2++) {

                if(j1==j2){
                    max = Math.max(max, grid[i][j1] + findMaxCherry(grid, directions, i + 1, j1 + directions[d1], j2 + directions[d2], dp));
                }
                else {
                    max = Math.max(max, grid[i][j1] + grid[i][j2] + findMaxCherry(grid, directions, i + 1, j1 + directions[d1], j2 + directions[d2], dp));
                }
            }


        }
        dp[i][j1][j2]=max;
        return max;

    }


    //Tabulation
    public int cherryPickup2(int[][] grid) {

        int[] directions= new int[]{-1,0,1};
        int [][][]dp = new int[grid.length][grid[0].length][grid[0].length];

        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,Integer.MIN_VALUE);
            }
        }
        dp[0][0][grid[0].length-1]=grid[0][0]+grid[0][grid[0].length-1];


        for(int i=1;i<grid.length;i++) {

           for (int j1=0;j1<grid[0].length;j1++){
               for(int j2=0;j2<grid[0].length;j2++){
                   for (int d1 = 0; d1 < directions.length; d1++) {
                       for (int d2 = 0; d2 < directions.length; d2++) {
                           if(j1+d1<0 ||j1+d1>grid[0].length-1||j2+d2<0 ||j2+d2>grid[0].length-1){
                              continue;
                           }
                           if(j1==j2){
                              dp[i][j1][j2]=Math.max(dp[i][j1][j2],grid[i][j1]+dp[i-1][j1+d1][j2+d2]);
                           }
                           else {
                               dp[i][j1][j2]=Math.max(dp[i][j1][j2],grid[i][j1]+grid[i][j2]+dp[i-1][j1+d1][j2+d2]);
                           }
                       }


                   }
               }
           }
        }

                return dp[grid.length-1][grid[0].length-1][grid[0].length-1];

    }

    public static void main(String[] args) {
        CherryPickUpII solution = new CherryPickUpII();

        // Test case 1
        int[][] grid1 = {
                {3, 1, 1},
                {2, 5, 1},
                {1, 5, 5},
                {2, 1, 1}
        };
        // Expected result: 24
        System.out.println(solution.cherryPickup2(grid1));

        // Test case 2
        int[][] grid2 = {
                {1, 0, 0, 0, 0, 0, 1},
                {2, 0, 0, 0, 0, 3, 0},
                {2, 0, 9, 0, 0, 0, 0},
                {0, 3, 0, 5, 4, 0, 0},
                {1, 0, 2, 3, 0, 0, 6}
        };
        // Expected result: 28
        System.out.println(solution.cherryPickup(grid2));

        // Test case 3
        int[][] grid3 = {
                {1, 1},
                {1, 1}
        };
        // Expected result: 4
        System.out.println(solution.cherryPickup(grid3));
    }

}
