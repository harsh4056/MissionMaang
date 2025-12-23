import java.util.Arrays;

public class MinimumFallingPathSumII {
    public int minFallingPathSum(int[][] grid) {
        int smallest=Integer.MAX_VALUE;
        int secondSmallest=Integer.MAX_VALUE;
        int smi=-1;
        for (int j = 0; j < grid[0].length; j++) {
            if(grid[0][j]<=smallest){
                secondSmallest=smallest;
                smallest=grid[0][j];
                smi=j;
            }
            if(grid[0][j]>smallest && grid[0][j]<=secondSmallest){
                secondSmallest=grid[0][j];
            }
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                grid[i][j]+= j==smi?secondSmallest:smallest;
            }
            smallest=Integer.MAX_VALUE;
            secondSmallest=Integer.MAX_VALUE;
            smi=-1;
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j]<=smallest){
                    secondSmallest=smallest;
                    smallest=grid[i][j];
                    smi=j;
                }
                if(grid[i][j]>smallest && grid[i][j]<=secondSmallest){
                    secondSmallest=grid[i][j];
                }
            }
        }
        int mini=Integer.MAX_VALUE;
        for(int val: grid[grid.length-1]) mini=Math.min(mini,val);
        return mini;

    }



    public static void main(String[] args) {
        MinimumFallingPathSumII obj = new MinimumFallingPathSumII();

        int[][] grid1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(obj.minFallingPathSum(grid1));
        // Expected: 13 (1 -> 5 -> 7)

        int[][] grid2 = {
                {7}
        };
        System.out.println(obj.minFallingPathSum(grid2));
        // Expected: 7

        int[][] grid3 = {
                {1, 2},
                {3, 4}
        };
        System.out.println(obj.minFallingPathSum(grid3));
        // Expected: 5 (1 -> 4)
    }
}

