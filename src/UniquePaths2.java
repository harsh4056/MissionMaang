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

    public static void main(String[] args) {
        UniquePaths2 solver = new UniquePaths2();

        int[][] grid1 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println("Expected: 2, Actual: " + solver.uniquePathsWithObstacles(grid1));

        int[][] grid2 = {
                {0, 1},
                {0, 0}
        };
        System.out.println("Expected: 1, Actual: " + solver.uniquePathsWithObstacles(grid2));

        int[][] grid3 = {
                {1}
        };
        System.out.println("Expected: 0, Actual: " + solver.uniquePathsWithObstacles(grid3));
    }

}