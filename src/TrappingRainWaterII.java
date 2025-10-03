import java.util.Comparator;
import java.util.PriorityQueue;

public class TrappingRainWaterII {

    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));

        int m = heightMap[0].length;
        int n = heightMap.length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            visited[i][0] = true;
            visited[i][m - 1] = true;
            minHeap.offer(new int[] { i, 0, heightMap[i][0] });
            minHeap.offer(new int[] { i, m - 1, heightMap[i][m - 1] });
        }
        for (int j = 1; j < m - 1; j++) {
            visited[0][j] = true;
            visited[n - 1][j] = true;
            minHeap.offer(new int[] { 0, j, heightMap[0][j] });
            minHeap.offer(new int[] { n - 1, j, heightMap[n - 1][j] });
        }
        int[][] fourD = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int water = 0;
        while (!minHeap.isEmpty()) {

            int[] curr = minHeap.poll();
            int r = curr[0];
            int c = curr[1];
            int h = curr[2];
            for (int[] d : fourD) {
                int rr = r + d[0];
                int cc = c + d[1];
                if (rr > 0 && rr < n - 1 && cc > 0 && cc < m - 1 && !visited[rr][cc]) {
                    int currH = heightMap[rr][cc];
                    if (currH < h) {
                        water += h - currH;
                        minHeap.offer(new int[] { rr, cc, h });
                    } else {
                        minHeap.offer(new int[] { rr, cc, currH });
                    }
                    visited[rr][cc] = true;
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {
        TrappingRainWaterII solver = new TrappingRainWaterII();


        int[][] heightMap2 = {
                {3,3,3,3,3},
                {3,2,2,2,3},
                {3,2,1,2,3},
                {3,2,2,2,3},
                {3,3,3,3,3}
        };
        System.out.println(solver.trapRainWater(heightMap2)); // Expected: 10


        int[][] heightMap1 = {
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        };
        System.out.println(solver.trapRainWater(heightMap1)); // Expected: 4



        int[][] heightMap3 = {
                {12,13,1,12},
                {13,4,13,12},
                {13,8,10,12},
                {12,13,12,12},
                {13,13,13,13}
        };
        System.out.println(solver.trapRainWater(heightMap3)); // Expected: 14
    }

}
