import java.util.*;

public class PacificAtlanticWaterFlow {

    static final int PACIFIC = 1;   // 01
    static final int ATLANTIC = 2;  // 10
    static final int[][] DIRS = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;
        int[][] dp = new int[n][m];             // bitmask for oceans
        boolean[][] visiting = new boolean[n][m];
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int state = dfs(i, j, heights, dp, visiting);
                if ((state & PACIFIC) != 0 && (state & ATLANTIC) != 0)
                    ans.add(Arrays.asList(i, j));
            }
        }
        return ans;
    }

    private int dfs(int i, int j, int[][] heights, int[][] dp, boolean[][] visiting) {
        if (dp[i][j] != 0) return dp[i][j];   // memoized
        if (visiting[i][j]) return 0;         // avoid cycles

        visiting[i][j] = true;
        int n = heights.length, m = heights[0].length;
        int state = 0;
        if (i == 0 || j == 0) state |= PACIFIC;
        if (i == n - 1 || j == m - 1) state |= ATLANTIC;

        for (int[] d : DIRS) {
            int ni = i + d[0], nj = j + d[1];
            if (ni < 0 || nj < 0 || ni >= n || nj >= m) continue;
            if (heights[ni][nj] <= heights[i][j]) {
                state |= dfs(ni, nj, heights, dp, visiting);
                if ((state & PACIFIC) != 0 && (state & ATLANTIC) != 0) break; // early stop
            }
        }

        visiting[i][j] = false;
        return dp[i][j] = state;
    }

    public static void main(String[] args) {
        PacificAtlanticWaterFlow sol = new PacificAtlanticWaterFlow();

        int[][] heights1 = {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        System.out.println(sol.pacificAtlantic(heights1));

        int[][] heights2 = {{2,1},{1,2}};
        System.out.println(sol.pacificAtlantic(heights2));

        int[][] heights3 = {
                {10,10,10},
                {10,1,10},
                {10,10,10}
        };
        System.out.println(sol.pacificAtlantic(heights3));
    }
}
