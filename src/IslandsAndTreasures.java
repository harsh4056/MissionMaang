import java.util.*;

public class IslandsAndTreasures {

    int LAND=2147483647;
    int TRES=0;
    int WALL=-1;
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> bfsq = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == TRES) {
                    bfsq.offer(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int last = -2;
        while (!bfsq.isEmpty()) {
            int[] curr = bfsq.poll();
            int r = curr[0];
            int c = curr[1];
            last = grid[r][c];
            for (int[] dir : dirs) {
                int rr = r + dir[0];
                int cc = c + dir[1];
                if (rr >= 0 && rr < n && cc >= 0 && cc < m && grid[rr][cc] == LAND) {
                    grid[rr][cc] =Math.min( last + 1,grid[rr][cc]);
                    bfsq.offer(new int[]{rr,cc});
                }
            }
        }
    }

    public static void main(String[] args) {
        IslandsAndTreasures obj = new IslandsAndTreasures();

        // Test case 1
        int INF = 2147483647;
        int[][] grid1 = {
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF}
        };

        obj.islandsAndTreasure(grid1);

        // Expected:
        // [
        //  [3,-1,0,1],
        //  [2,2,1,-1],
        //  [1,-1,2,-1],
        //  [0,-1,3,4]
        // ]
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                System.out.print(grid1[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();

        // Test case 2

        int[][] grid2 = {
                {-1,0, INF},
                {INF, INF,-1}
        };

        obj.islandsAndTreasure(grid2);

        // Expected:
        // [
        //  [0,1],
        //  [1,2]
        // ]
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                System.out.print(grid2[i][j] + " ");
            }
            System.out.println();
        }
    }

}
