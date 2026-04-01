public class MaximumNonNegativeProductinMatrix {
    public int maxProductPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int mod = 1_000_000_007;

        long[][] minGrid = new long[n][m];
        long[][] maxGrid = new long[n][m];

        // Base case
        minGrid[0][0] = grid[0][0];
        maxGrid[0][0] = grid[0][0];

        // First row
        for (int j = 1; j < m; j++) {
            minGrid[0][j] = maxGrid[0][j] = maxGrid[0][j-1] * grid[0][j];
        }

        // First column
        for (int i = 1; i < n; i++) {
            minGrid[i][0] = maxGrid[i][0] = maxGrid[i-1][0] * grid[i][0];
        }

        // Fill rest
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long val = grid[i][j];

                long a = maxGrid[i-1][j] * val;
                long b = minGrid[i-1][j] * val;
                long c = maxGrid[i][j-1] * val;
                long d = minGrid[i][j-1] * val;

                maxGrid[i][j] = Math.max(Math.max(a, b), Math.max(c, d));
                minGrid[i][j] = Math.min(Math.min(a, b), Math.min(c, d));
            }
        }

        long ans = maxGrid[n-1][m-1];
        return ans >= 0 ? (int)(ans % mod) : -1;
    }

    public static void main(String[] args) {
        MaximumNonNegativeProductinMatrix obj = new MaximumNonNegativeProductinMatrix();
        int[][] grid3 = {
                {-1, -2, -3},
                {-2, -3, -3},
                {-3, -3, -2}
        };
        System.out.println(obj.maxProductPath(grid3)); // -1
        int[][] grid1 = {
                {1, -2, 1},
                {1, -2, 1},
                {3, -4, 1}
        };
        System.out.println(obj.maxProductPath(grid1)); // 8

        int[][] grid2 = {
                {1, 3},
                {0, -4}
        };
        System.out.println(obj.maxProductPath(grid2)); // 0


    }
}
