public class ScoreAfterFlippingMatrix {

    public int matrixScore(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<n;i++){
            if(grid[i][0]==0) flipRow(grid,i);
        }
        for(int i=1;i<m;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(grid[j][i]==0) count++;
            }
            if(count>(n/2)) {
                flipColumn(grid, i);
            }


        }
        int sum=0;
        for(int i=0;i<n;i++){
            int curr=0;
            for(int j=0;j<m;j++){
                int shift=m-j-1;
                curr=curr|grid[i][j]<<shift;
            }
            sum+=curr;
        }

        return sum;

    }

    public void flipRow(int[][]grid,int rowID){
        for(int i=0;i<grid[0].length;i++){
            grid[rowID][i]=1-grid[rowID][i];
        }
    }

    public void flipColumn(int[][]grid,int columnID){
        for(int i=0;i<grid.length;i++){
            grid[i][columnID]=1-grid[i][columnID];
        }
    }


    public static void main(String[] args) {
        ScoreAfterFlippingMatrix sol = new ScoreAfterFlippingMatrix();

        int[][] grid1 = {
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        };
        //System.out.println(sol.matrixScore(grid1)); // Expected: 39

        int[][] grid2 = {
                {0,1},
                {1,1}
        };
        //System.out.println(sol.matrixScore(grid2)); // Expected: 5

        int[][] grid3 = {
                {1,1,1},
                {1,0,1},
                {0,0,1}
        };
        System.out.println(sol.matrixScore(grid3)); // Expected: 18
    }

}
