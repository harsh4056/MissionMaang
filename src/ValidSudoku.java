public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            int []rowsFreq= new int[10];
            int []colsFreq= new int[10];
            for (int j = 0; j < 9; j++) {
                if(board[i][j]!='.'){
                    colsFreq[board[i][j]-'0']+=1;
                    if(colsFreq[board[i][j]-'0']>1)
                        return false;
                }
                if(board[j][i]!='.'){
                    rowsFreq[board[j][i]-'0']+=1;
                    if(rowsFreq[board[j][i]-'0']>1)
                        return false;
                }
            }
        }

        int jStart = 0;
        int iStart = 0;

        for (int k = 0; k < 9; k++) {
            int []gridsFreq= new int[10];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    char c = board[i + iStart][j + jStart];
                    if(c!='.') {

                        gridsFreq[c - '0'] += 1;
                        if (gridsFreq[c - '0'] > 1)
                            return false;
                    }
                }
            }

            jStart = (jStart + 3) % 9;
            if (jStart == 0) {
                iStart += 3;
            }
        }

        return true;


    }

    public static void main(String[] args) {


    }

}
