import java.util.ArrayList;
import java.util.List;

public class GameOfLife {

    public void gameOfLife(int[][] board) {
        List<int[]> zeros = new ArrayList<>();
        List<int[]> ones = new ArrayList<>();

        int[][] dirs = {
                {-1, -1}, {-1, 0}, {-1, 1},
                {0, -1},          {0, 1},
                {1, -1},  {1, 0},  {1, 1}
        };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int neighbourCount = 0;

                for (int[] dir : dirs) {
                    int ni = i + dir[0];
                    int nj = j + dir[1];
                    if (ni >= 0 && ni < board.length && nj >= 0 && nj < board[0].length) {
                        if (board[ni][nj] == 1) {
                            neighbourCount++;
                        }
                    }
                }

                if (board[i][j] == 0) {
                    if (neighbourCount == 3) {
                        ones.add(new int[]{i, j}); // dead cell becomes alive
                    }
                } else { // board[i][j] == 1
                    if (neighbourCount < 2 || neighbourCount > 3) {
                        zeros.add(new int[]{i, j}); // live cell dies
                    }
                }
            }
        }

        for (int[] cell : ones) {
            board[cell[0]][cell[1]] = 1;
        }
        for (int[] cell : zeros) {
            board[cell[0]][cell[1]] = 0;
        }
    }


    public static void main(String[] args) {
        int[][] board = {
                {1, 1},
                {1, 0}
        };

        GameOfLife g = new GameOfLife();
        g.gameOfLife(board);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


}
