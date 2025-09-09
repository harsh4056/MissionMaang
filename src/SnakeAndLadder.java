import java.util.*;

public class SnakeAndLadder {


    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int loc = curr[0], step = curr[1];

            for (int i = 1; i <= 6 && loc + i <= n * n; i++) {
                int next = loc + i;
                int[] cell = getIndex(next, n);
                int r = cell[0], c = cell[1];
                if (board[r][c] != -1) next = board[r][c];
                if (next == n * n) return step + 1;

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, step + 1});
                }
            }
        }
        return -1;
    }

        public int[] getIndex(int location,int n){
            int temp=Math.ceilDiv(location,n);
            int i=n-temp;
            int j=0;
            if(temp%2==1){
                j=(location+(n-1))%n;
            }
            else{
                j=(n-(location%n))%n;
            }
            return new int[]{i,j};
        }


    public static void main(String[] args) {
        SnakeAndLadder sol = new SnakeAndLadder();

        // Test case 1
        int[][] board1 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 15, -1, -1, -1, -1}
        };
        System.out.println(sol.snakesAndLadders(board1)); // Expected: 4

        // Test case 2
        int[][] board2 = {
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, 35, -1, -1, 13, -1},
                {-1, -1, -1, -1, -1, -1},
                {-1, -1, -1, -1, -1, -1}
        };
        System.out.println(sol.snakesAndLadders(board2)); // Expected: 4

        // Test case 3
        int[][] board3 = {
                {-1, -1},
                {-1, 3}
        };
        System.out.println(sol.snakesAndLadders(board3)); // Expected: 2

        int[][] board4 = {
                {1, 1, -1},
                {1, 1, 1},
                {-1, 1, 1}
        };
        System.out.println(sol.snakesAndLadders(board4)); // Expected: -1

    }


}
