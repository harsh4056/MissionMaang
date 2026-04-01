public class CountSubmatricesWithTopLeftElementAndSumLessThank {

    public int countSubmatrices(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int up= (i-1)>=0?grid[i-1][j]:0;
                int left=(j-1)>=0?grid[i][j-1]:0;
                int common= (i-1)>=0 && (j-1)>=0?grid[i-1][j-1]:0;
                grid[i][j]=grid[i][j]+up+left-common;
                if(grid[i][j]<=k) count++;
            }
        }
        return count;
    }

}
