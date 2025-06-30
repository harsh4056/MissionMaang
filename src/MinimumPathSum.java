import java.util.Arrays;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        for (int i=0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if(j-1>=0 ){

                    if(i-1>=0){

                        grid[i][j]=grid[i][j]+Math.min(grid[i-1][j],grid[i][j-1]);
                    }

                }

                if(i>0 && j==0){
                    grid[i][0]=grid[i][0]+grid[i-1][0];
                }
                if(i==0 && j>0){
                    grid[0][j]=grid[0][j]+grid[0][j-1];
                }
            }



        }
        return grid[grid.length-1][grid[0].length-1];
    }


    public int minPathSum2(int[][] grid) {
        int[][] memo = new int[grid.length][grid[0].length];
        for (int[] row : memo) Arrays.fill(row, -1);
        dfs(0,0,grid,memo);
        return memo[0][0];
    }

    public int dfs(int i,int j,int[][]grid,int[][] memo){
        if(i>=grid.length ||j>=grid[0].length) return Integer.MAX_VALUE;

        if(i==grid.length-1 && j==grid[0].length-1) return grid[i][j];


        if (memo[i][j] != -1) return memo[i][j];
        int down=dfs(i+1,j,grid,memo);
        int right=dfs(i,j+1,grid,memo);




        memo[i][j]= grid[i][j]+Math.min(down,right);
        return memo[i][j];


    }

    /*
    *
    *
    *
    * public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] memo = new int[m][n];
        for (int[] row : memo) Arrays.fill(row, -1);
        return dfs(0, 0, grid, memo);
    }

    public int dfs(int i, int j, int[][] grid, int[][] memo) {
        if (i >= grid.length || j >= grid[0].length) return Integer.MAX_VALUE;
        if (i == grid.length - 1 && j == grid[0].length - 1) return grid[i][j];
        if (memo[i][j] != -1) return memo[i][j];

        int down = dfs(i + 1, j, grid, memo);
        int right = dfs(i, j + 1, grid, memo);
        memo[i][j] = grid[i][j] + Math.min(down, right);
        return memo[i][j];
    }
    * */

    public static void main(String[] args) {
        MinimumPathSum mps = new MinimumPathSum();

        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(mps.minPathSum2(grid1)); // Expected: 7

        int[][] grid2 = {
                {1, 2, 3},
                {4, 5, 6}
        };
        System.out.println(mps.minPathSum2(grid2)); // Expected: 12

        int[][] grid3 = {
                {3}
        };
        System.out.println(mps.minPathSum2(grid3)); // Expected: 5
    }


}
