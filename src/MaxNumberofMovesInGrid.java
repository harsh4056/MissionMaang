public class MaxNumberofMovesInGrid {
    int max=0;
    public int maxMoves(int[][] grid) {
        max=0;
        int n=grid.length;;
        int m=grid[0].length;
        Boolean[][]visited= new Boolean[n][m];
        for(int i=0;i<n;i++)
            dfs(grid,visited,i,0,-1);
        return max;

    }
    public void dfs(int[][] grid,Boolean[][]visited,int i,int j,int previous){

        if(i>=0 && i<grid.length && j>=0 &&j<grid[0].length ){

            if((visited[i][j]==null && previous<grid[i][j])|| (visited[i][j]!=null && visited[i][j])){
                max=Math.max(j,max);
                visited[i][j]=true;
                dfs(grid,visited,i-1,j+1,grid[i][j]);
                dfs(grid,visited,i,j+1,grid[i][j]);
                dfs(grid,visited,i+1,j+1,grid[i][j]);
            }
            else if(visited[i][j]==null && previous>=grid[i][j]){
                visited[i][j]=false;
            }
        }
    }
    public static void main(String[] args) {
        MaxNumberofMovesInGrid solver = new MaxNumberofMovesInGrid();

        // Test case 1
        int[][] grid1 = {
                {2, 4, 3, 5},
                {5, 4, 9, 3},
                {3, 4, 2, 11},
                {10, 9, 13, 15}
        };
        System.out.println("Result 1: " + solver.maxMoves(grid1));
        // Expected: 3

        // Test case 2
        int[][] grid2 = {
                {3, 2, 4},
                {2, 1, 9},
                {1, 1, 7}
        };
        System.out.println("Result 2: " + solver.maxMoves(grid2));
        // Expected: 0

        // Test case 3
        int[][] grid3 = {
                {1, 2, 3},
                {2, 3, 4},
                {3, 4, 5}
        };
        System.out.println("Result 3: " + solver.maxMoves(grid3));
        // Expected: 2
    }

}
