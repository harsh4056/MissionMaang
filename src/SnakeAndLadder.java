import java.util.LinkedList;
import java.util.Queue;

public class SnakeAndLadder {

    public int snakesAndLadders(int[][] board) {
        Queue<int[]> q = new LinkedList<>();
        int n=board.length;
        boolean[] visited = new boolean[n * n + 1];

        q.offer(new int[]{1, 0});  // start at square 1 with 0 moves
        visited[1] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int currSquare = curr[0];
            int moves = curr[1];

            if (currSquare == n * n) return moves;

            int next = -1;

            for (int i = 1; i <= 6; i++) {
                int temp = currSquare + i;
                if (temp > n * n) break;

                int[] coords = getCoordinates(temp, n);
                int r = coords[0], c = coords[1];

                if (board[r][c] == -1) {
                    next = temp; // keep latest valid -1 square
                } else {
                    // enqueue snake or ladder directly
                    int jump = board[r][c];
                    if (!visited[jump]) {
                        visited[jump] = true;
                        q.offer(new int[]{jump, moves + 1});
                    }
                }
            }

            // Add best normal move
            if (next != -1 && !visited[next]) {
                visited[next] = true;
                q.offer(new int[]{next, moves + 1});
            }
        }
        return 0;

    }


    int[] getCoordinates(int square, int n) {
        int row = n - 1 - (square - 1) / n;
        int col = (square - 1) % n;
        if (((n - 1 - row) % 2) == 1) {
            col = n - 1 - col;
        }
        return new int[]{row, col};
    }

}
