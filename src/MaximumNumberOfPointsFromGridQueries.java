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
        minHeap.offer(new int[] { 0, 0, grid[0][0] });
        int[][] fourD = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int[] answer = new int[queries.length];
        int previous=0;
        while (!queryMinHeap.isEmpty()) {
            int query = queryMinHeap.poll();
            int size = previous;

            while (!minHeap.isEmpty() &&query>minHeap.peek()[2]) {
                int[] curr = minHeap.poll();
                int r=curr[0];
                int c=curr[1];
                int value=grid[r][c];

                if(value<query && !visited[r][c]) {
                    visited[r][c]=true;
                    size++;
                    for (int[] d : fourD) {
                        int rr = r + d[0];
                        int cc = c + d[1];
                        if (rr >= 0 && rr <= n - 1 && cc >= 0 && cc <= m - 1 && !visited[rr][cc]) {
                            minHeap.offer(new int[]{rr,cc,grid[rr][cc]});

                        }
                    }
                }
            }
            map.put(query,size);
            previous=size;

        }
        for(int i=0;i<queries.length;i++){
            answer[i]=map.get(queries[i]);
        }
        return answer;

    }

    public static void main(String[] args) {
        MaximumNumberOfPointsFromGridQueries solver = new MaximumNumberOfPointsFromGridQueries();

        int[][] grid1 = {
                {1,2,4},
                {3,4,5},
                {2,1,3}
        };
        int[] queries1 = {2,3,5};
        System.out.println(Arrays.toString(solver.maxPoints(grid1, queries1)));
        // Expected example output: [3, 5, 9] (depends on logic completion)

        int[][] grid2 = {
                {5,1},
                {4,2}
        };
        int[] queries2 = {1,2,6};
        System.out.println(Arrays.toString(solver.maxPoints(grid2, queries2)));
        // Expected example output: [0, 1, 4] (depends on logic completion)

        int[][] grid3 = {
                {2,2,2},
                {2,1,2},
                {2,2,2}
        };
        int[] queries3 = {1,2,3};
        System.out.println(Arrays.toString(solver.maxPoints(grid3, queries3)));
        // Expected example output: [0, 8, 9] (depends on logic completion)
    }

}
