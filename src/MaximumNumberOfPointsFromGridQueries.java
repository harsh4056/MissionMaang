import java.util.*;

public class MaximumNumberOfPointsFromGridQueries {

    public int[] maxPoints(int[][] grid, int[] queries) {

        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> queryMinHeap = new PriorityQueue<>();
        for (int q : queries) {
            queryMinHeap.offer(q);
        }
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        visited[0][0] = true;
        minHeap.offer(new int[] { 0, 0, grid[0][0] });
        int[][] fourD = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[] answer = new int[queries.length];
        while (!queryMinHeap.isEmpty()) {
            int query = queryMinHeap.poll();
            int size = map.getOrDefault(query, 0);
            PriorityQueue<int[]> temp = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            while (!minHeap.isEmpty()) {
                int[] curr = minHeap.poll();
                int r=curr[0];
                int c=curr[1];
                int value=grid[r][c];
                for (int[] d : fourD) {
                    int rr = r + d[0];
                    int cc = c + d[1];
                    if (rr >= 0 && rr <= n - 1 && cc >= 0 && cc <= m - 1 && !visited[rr][cc]) {

                    }
                }

            }
        }
        return answer;

    }
}
