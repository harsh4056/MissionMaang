import java.util.*;

public class DistinctSquareIslands {
    static int n, m;
    static boolean[][] visited;

    public static void main(String[] args) {
        List<char[][]> grids = new ArrayList<>();

        grids.add(new char[][]{
                {'A','A','A','B','B'},
                {'A','A','A','B','B'},
                {'C','C','D','D','E'},
                {'B','C','D','D','B'}
        });

        grids.add(new char[][]{
                {'A','B','C'},
                {'B','B','A'},
                {'A','B','C'}
        });

        int caseNo = 1;
        for (char[][] grid : grids) {
            System.out.println("Grid " + caseNo++ + " result: " + countSquareIslands(grid));
        }
    }

    static int countSquareIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    List<int[]> comp = new ArrayList<>();
                    char ch = grid[i][j];
                    dfs(grid, i, j, ch, comp);
                    if (isSquare(comp, grid, ch)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    static void dfs(char[][] g, int i, int j, char ch, List<int[]> comp) {
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || g[i][j] != ch) return;
        visited[i][j] = true;
        comp.add(new int[]{i, j});
        dfs(g, i + 1, j, ch, comp);
        dfs(g, i - 1, j, ch, comp);
        dfs(g, i, j + 1, ch, comp);
        dfs(g, i, j - 1, ch, comp);
    }

    static boolean isSquare(List<int[]> comp, char[][] g, char ch) {
        int minR = Integer.MAX_VALUE, minC = Integer.MAX_VALUE;
        int maxR = Integer.MIN_VALUE, maxC = Integer.MIN_VALUE;

        for (int[] c : comp) {
            minR = Math.min(minR, c[0]);
            minC = Math.min(minC, c[1]);
            maxR = Math.max(maxR, c[0]);
            maxC = Math.max(maxC, c[1]);
        }

        int h = maxR - minR + 1, w = maxC - minC + 1;
        if (h != w) return false;

        for (int r = minR; r <= maxR; r++) {
            for (int c = minC; c <= maxC; c++) {
                if (g[r][c] != ch) return false;
            }
        }
        return true;
    }
}
