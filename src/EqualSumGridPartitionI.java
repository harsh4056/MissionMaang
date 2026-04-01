public class EqualSumGridPartitionI {
    public boolean canPartitionGrid(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long[][] lGrid= new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                long up= (i-1)>=0?lGrid[i-1][j]:0;
                long left=(j-1)>=0?lGrid[i][j-1]:0;
                long common= (i-1)>=0 && (j-1)>=0?lGrid[i-1][j-1]:0;
                lGrid[i][j]=grid[i][j]+up+left-common;
            }
        }
        for(int i=0;i<n;i++){
            long curr= lGrid[i][m-1];
            long total= lGrid[n-1][m-1];
            if(curr==(total-curr)) return true;
        }

        for (int j = 0; j < m; j++) {
            long curr= lGrid[n-1][j];
            long total= lGrid[n-1][m-1];
            if(curr==(total-curr)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        EqualSumGridPartitionI obj = new EqualSumGridPartitionI();


        int[][] grid3 = {
                {3, 3, 3},
                {3, 3, 3}
        };
        System.out.println(obj.canPartitionGrid(grid3)); // true

        int[][] grid1 = {
                {1, 1},
                {1, 1}
        };
        System.out.println(obj.canPartitionGrid(grid1)); // true

        int[][] grid2 = {
                {2, 1},
                {1, 1}
        };
        System.out.println(obj.canPartitionGrid(grid2)); // false


    }
}
