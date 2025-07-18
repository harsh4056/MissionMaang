public class NumberOfEnclaves {

    public int numEnclaves(int[][] grid) {


        int lastColumn=grid[0].length-1;
        int lastRow=grid.length-1;
        for (int i = 0; i <= lastColumn; i++) {
            if(grid[0][i]==1){
                dfs(grid,0,i);
            }
        }

        for (int i = 0; i <= lastRow; i++) {
            if(grid[i][0]==1){
                dfs(grid,i,0);
            }
        }

        for (int i = 0; i <= lastRow; i++) {
            if(grid[i][lastColumn]==1){
                dfs(grid,i,lastColumn);
            }
        }

        for (int i = 0; i <= lastColumn; i++) {
           if(grid[lastRow][i]==1){
               dfs(grid,lastRow,i);
           }
        }

        int count=0;

        for (int[] ints : grid) {
            for (int anInt : ints) {
                if(anInt==1){
                    count++;
                }
            }
        }
        return count;
    }
    public void dfs(int[][]grid, int i,int j){
        if(i< grid.length &&i>=0 && j<grid[0].length && j>=0){


            if(grid[i][j]==1){
                grid[i][j]=Integer.MIN_VALUE;
                dfs(grid,i+1,j);
                dfs(grid,i,j+1);
                dfs(grid,i-1,j);
                dfs(grid,i,j-1);
            }

        }
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {0,0,0,1,1,1,0,1,0,0},
                {1,1,0,0,0,1,0,1,1,1},
                {0,0,0,1,1,1,0,1,0,0},
                {0,1,1,0,0,0,1,0,1,0},
                {0,1,1,1,1,1,0,0,1,0},
                {0,0,1,0,1,1,1,1,0,1},
                {0,1,1,0,0,0,1,1,1,1},
                {0,0,1,0,0,1,0,1,0,1},
                {1,0,1,0,1,1,0,0,0,0},
                {0,0,0,0,1,1,0,0,0,1}
        };
        int[][] grid2 = {
                {0,0,0},
                {1,0,1},
                {0,1,0}
        }; // Expected: 0

        int[][] grid3 = {
                {0,1,1,0},
                {0,0,1,0},
                {0,0,1,0},
                {0,0,0,0}
        }; // Expected: 0

        NumberOfEnclaves sol = new NumberOfEnclaves();
        System.out.println(sol.numEnclaves(grid1)); // Expected: 3
        System.out.println(sol.numEnclaves(grid2)); // Expected: 0
        System.out.println(sol.numEnclaves(grid3)); // Expected: 0
    }

}
