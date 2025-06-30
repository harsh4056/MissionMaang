import java.util.Arrays;

public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int[][] grid = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0]==0) {
            grid[0][0] = 1;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                        if(obstacleGrid[i][j]==0) {
                            if (i-1>=0 && obstacleGrid[i - 1][j] == 0) {
                                grid[i][j] = grid[i][j] + grid[i - 1][j];
                            }
                            if (j-1>=0 && obstacleGrid[i][j - 1] == 0) {
                                grid[i][j] = grid[i][j] + grid[i][j - 1];
                            }
                        }

            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if(obstacleGrid[obstacleGrid.length-1][obstacleGrid[0].length-1]==1){
            return 0;
        }
        if(obstacleGrid[0][0]==0 && obstacleGrid.length==1 && obstacleGrid[0].length==1){
            return 1;
        }
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int[][] memo = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int[] row : memo) Arrays.fill(row, -1);

        dfs(0,0,obstacleGrid,memo);
        return memo[0][0];
    }
    int dfs(int i, int j, int[][] grid, int[][] memo) {


        if(i>=grid.length ||j>=grid[0].length) return 0;
        if(i==grid.length-1 && j==grid[0].length-1) return 1;

        if (memo[i][j] != -1) return memo[i][j];

        if(grid[i][j]==1){
            return 0;
        }
        int right= (j+1< grid[0].length)?(grid[i][j+1]==0?dfs(i,j+1,grid,memo):0):0;
        int down= (i+1< grid.length)?(grid[i+1][j]==0?dfs(i+1,j,grid,memo):0):0;

        memo[i][j]= right+down;
        return memo[i][j];

    }
    public static void main(String[] args) {
        UniquePaths2 solver = new UniquePaths2();

        int[][] grid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Expected: 2, Actual: " + solver.uniquePathsWithObstacles2(grid1));

        int[][] grid2 = {
                {0, 1},
                {0, 0}
        };
        System.out.println("Expected: 1, Actual: " + solver.uniquePathsWithObstacles2(grid2));

        int[][] grid3 = {
                {1,0}
        };
        System.out.println("Expected: 0, Actual: " + solver.uniquePathsWithObstacles2(grid3));
    }

}