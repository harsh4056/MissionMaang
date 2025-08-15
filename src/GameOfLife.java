import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int[][] directions = new int[][] {
                { 0, 1 },
                { 0, -1 },
                { 1, 0 },
                { -1, 0 },
                { -1, -1 },
                { 1, 1 },
                { -1, 1 },
                { 1, -1 }
        };


        int n = board.length;
        int m = board[0].length;
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int nei = 0;
                for (int[] direction : directions) {
                    int rr = i + direction[0];
                    int cc = j + direction[1];

                    if (rr >= 0 && rr < n && cc >= 0 && cc < m) {
                        nei += board[rr][cc];
                    }

                }
                if (nei < 2) {
                    grid[i][j] = 0;
                } else if ((nei == 2 || nei == 3) && board[i][j] == 1) {
                    grid[i][j] = 1;
                } else if (nei > 3) {
                    grid[i][j] = 0;
                } else if (nei == 3 && board[i][j] == 0) {
                    grid[i][j] = 1;
                }
            }
        }
        System.arraycopy(grid, 0, board, 0, grid.length);
    }


    public static void main(String[] args) {
        GameOfLife g = new GameOfLife();

        // Test case 1
        int[][] board1 = {
                {1, 1},
                {1, 0}
        };
        g.gameOfLife(board1);
        System.out.println("Test Case 1 Result:");
        for (int[] row : board1) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        // Expected output:
        // 1 1
        // 1 1

        // Test case 2
        int[][] board2 = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        g.gameOfLife(board2);
        System.out.println("Test Case 2 Result:");
        for (int[] row : board2) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        // Expected output:
        // 0 0 0
        // 1 0 1
        // 0 1 1
        // 0 1 0

        // Test case 3
        int[][] board3 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        g.gameOfLife(board3);
        System.out.println("Test Case 3 Result:");
        for (int[] row : board3) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        // Expected output:
        // 1 0 1
        // 0 0 0
        // 1 0 1
    }



}
