public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if(aChar!='.'){
                  boolean ans=  check(board,i,j,aChar);
                  if(!ans){
                      return false;
                  }
                }
            }
        }
        return true;
    }


    public boolean check(char[][]board,int i, int j,char value){
        for (int k = 0; k < board.length; k++) {
            if(board[k][j]==value &&k!=i){
                return false;
            }
        }
        int baseRow = (i / 3) * 3;
        int baseCol = (j / 3) * 3;
        for (int k = baseRow; k < baseRow+3; k++) {
            for (int l = baseCol; l < baseCol+3; l++) {
                if(board[k][l]==value &&k!=i &&j!=l){
                    return false;
                }
            }

        }
        for (int k = 0; k < board.length; k++) {
            if(board[i][k]==value &&k!=j){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        ValidSudoku solution = new ValidSudoku();
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
        System.out.println(solution.isValidSudoku(board1)); // true


        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board2)); // false (duplicate '8' in column and box)

        char[][] board3 = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','.'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solution.isValidSudoku(board3)); // true
    }


}
