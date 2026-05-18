import java.util.LinkedList;
import java.util.Queue;

public class MultiSourceFloodFill {
    public int[][] colorGrid(int n, int m, int[][] sources) {
        Element[][] elements = new Element[n][m];
        Queue<int[]> queue = new LinkedList<>();

        for (int[] source : sources) {
            int r = source[0], c = source[1], color = source[2];
            elements[r][c] = new Element(0, color);
            queue.offer(new int[]{r, c, color, 0});
        }

        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int r = curr[0], c = curr[1], color = curr[2], time = curr[3];

            for (int[] direction : directions) {
                int rr = r + direction[0];
                int cc = c + direction[1];

                if (rr >= 0 && cc >= 0 && rr < n && cc < m) {

                    int newTime = time + 1;

                    if (elements[rr][cc] == null) {
                        elements[rr][cc] = new Element(newTime, color);
                        queue.offer(new int[]{rr, cc, color, newTime});
                    } else {
                        Element e = elements[rr][cc];

                        if (newTime < e.time) {
                            e.time = newTime;
                            e.color = color;
                            queue.offer(new int[]{rr, cc, color, newTime});
                        } else if (newTime == e.time) {
                            if (color > e.color) {
                                e.color = color;
                                queue.offer(new int[]{rr, cc, color, newTime});
                            }
                        }
                    }
                }
            }
        }

        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = elements[i][j].color;
            }
        }

        return grid;
    }

    class Element{
        int time;
        int color;

        public Element(int time, int color) {
            this.time = time;
            this.color = color;
        }
    }



    public static void main(String[] args) {
        MultiSourceFloodFill sol = new MultiSourceFloodFill();

        int[][] sources1 = {
                {0, 0, 1},
                {2, 2, 2}
        };
        int[][] res1 = sol.colorGrid(3, 3, sources1);
        printGrid(res1);
        // Expected:
        // 1 1 2
        // 1 2 2
        // 2 2 2

        int[][] sources2 = {
                {0, 1, 3},
                {1, 1, 5}
        };
        int[][] res2 = sol.colorGrid(3, 3, sources2);
        printGrid(res2);
        // Expected:
        // 3 3 3
        // 5 5 5
        // 5 5 5

        int[][] sources3 = {
                {1, 1, 5}
        };
        int[][] res3 = sol.colorGrid(2, 2, sources3);
        printGrid(res3);
        // Expected:
        // 5 5
        // 5 5
    }

    private static void printGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
