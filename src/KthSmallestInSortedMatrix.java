import java.util.HashSet;
import java.util.PriorityQueue;

public class KthSmallestInSortedMatrix {


    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0]; // value
            if (a[1] != b[1]) return a[1] - b[1]; // row
            return a[2] - b[2]; // col
        });

        boolean[][] visited = new boolean[n][n];
        heap.add(new int[]{matrix[0][0], 0, 0});
        visited[0][0] = true;

        while (--k > 0) {
            int[] val = heap.poll();
            int i = val[1], j = val[2];

            if (i + 1 < n && !visited[i + 1][j]) {
                heap.add(new int[]{matrix[i + 1][j], i + 1, j});
                visited[i + 1][j] = true;
            }

            if (j + 1 < n && !visited[i][j + 1]) {
                heap.add(new int[]{matrix[i][j + 1], i, j + 1});
                visited[i][j + 1] = true;
            }
        }

        return heap.poll()[0];
    }

    public static void main(String[] args) {
        KthSmallestInSortedMatrix solution = new KthSmallestInSortedMatrix();

        int[][] matrix1 = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        System.out.println(solution.kthSmallest(matrix1, 8)); // Expected: 13

        int[][] matrix2 = {
                {1, 2},
                {1, 3}
        };
        System.out.println(solution.kthSmallest(matrix2, 2)); // Expected: 1

        int[][] matrix3 = {
                {1, 3, 5},
                {6, 7, 12},
                {11, 14, 14}
        };
        System.out.println(solution.kthSmallest(matrix3, 6)); // Expected: 11
    }

}
