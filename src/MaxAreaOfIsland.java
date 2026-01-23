public class MaxAreaOfIsland {


    public int maxAreaOfIsland(int[][] grid) {
        int answer=0;
        int count =2;
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1) {
                    dfs(grid, i, j, count);
                    count++;
                }
            }
        }
        int[] arr= new int[count];
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                    arr[grid[i][j]]++;
            }
        }
        for(int i=2;i<count;i++){
            answer=Math.max(answer,arr[i]);
        }
        return answer;


    }
    public void dfs(int[][]grid,int i,int j,int marker){
        if(i>=0 && i<grid.length && j>=0 && j<grid[0].length && grid[i][j]==1){

            grid[i][j]=marker;
            dfs(grid,i+1,j,marker);
            dfs(grid,i,j+1,marker);
            dfs(grid,i-1,j,marker);
            dfs(grid,i,j-1,marker);
        }
    }

    public static void main(String[] args) {
        MaxAreaOfIsland obj = new MaxAreaOfIsland();


        // Test case 2
        int[][] grid2 = {
                {1,0,1,0},
                {1,1,1,0},
                {0,0,1,0},
                {0,0,0,1}
        };
        System.out.println(obj.maxAreaOfIsland(grid2)); // Expected: 6


        // Test case 1
        int[][] grid1 = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(obj.maxAreaOfIsland(grid1)); // Expected: 6


        // Test case 3
        int[][] grid3 = {
                {0,0,0},
                {0,0,0},
                {0,0,0}
        };
        System.out.println(obj.maxAreaOfIsland(grid3)); // Expected: 0
    }

}
