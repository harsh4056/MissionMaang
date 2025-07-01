public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }

    public boolean solve(char[][] board, int i, int j) {
        if (i == 9) return true;

        int nextI = i + (j + 1) / 9;
        int nextJ = (j + 1) % 9;

        if (board[i][j] != '.') {
            return solve(board, nextI, nextJ);
        }

        for (char c = '1'; c <= '9'; c++) {
            if (checkGrid(board, i, j, c) && checkHorizontal(board, i, c) && checkVertical(board, j, c)) {
                board[i][j] = c;

                if (solve(board, nextI, nextJ)) {
                    return true;
                }

                board[i][j] = '.';
            }
        }

        return false;
    }


    public boolean checkVertical(char[][]board, int j,char value){
        for (int k = 0; k < board.length; k++) {
            if(board[k][j]==value){
                return false;
            }
        }
        return true;
    }

    public boolean checkHorizontal(char[][]board, int i,char value){
        for (int k = 0; k < board.length; k++) {
            if(board[i][k]==value){
                return false;
            }
        }
        return true;
    }
    public boolean checkGrid(char[][]board, int i,int j,char value){
        int baseRow = (i / 3) * 3;
        int baseCol = (j / 3) * 3;
        for (int k = baseRow; k < baseRow+3; k++) {
            for (int l = baseCol; l < baseCol+3; l++) {
                if(board[k][l]==value){
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver solver = new SudokuSolver();

        char[][] board1 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solver.solveSudoku(board1);
        printBoard(board1); // Expected: Fully solved valid Sudoku board

        char[][] board2 = {
                {'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}
        };
        solver.solveSudoku(board2);
        printBoard(board2); // Expected: Fully solved valid Sudoku board


        char[][] board3 = {
                {'.','8','7','6','5','4','3','2','1'},
                {'2','.','.','.','.','.','.','.','.'},
                {'3','.','.','.','.','.','.','.','.'},
                {'4','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','.','.'},
                {'6','.','.','.','.','.','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'8','.','.','.','.','.','.','.','.'},
                {'9','.','.','.','.','.','.','.','.'}
        };
        solver.solveSudoku(board3);
        printBoard(board3); // Expected: Fully solved valid Sudoku board

    }

    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
