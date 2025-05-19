public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count=0;
        for (int i = 0; i < grid.length; i++) {
            char[] chars = grid[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if(aChar=='1'){
                    search(grid,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    public void search(char[][] grid,int i,int j){
       if(i>=0 && i< grid.length && j>=0 && j<grid[0].length){
           char c=grid[i][j];
           if(c=='#' || c=='0'){
               return;
           }
           grid[i][j]='#';
           search(grid, i+1, j);
           search(grid, i, j+1);
           search(grid, i-1, j);
           search(grid, i, j-1);

       }
    }

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };

        NumberOfIslands obj = new NumberOfIslands();
        int count = obj.numIslands(grid);
        System.out.println("Number of islands: " + count); // Expected: 3
    }
}
