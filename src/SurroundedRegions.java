public class SurroundedRegions {
    public void solve(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            dfs( board, i, 0);
        }
        for (int i = 0; i < board.length; i++) {
            dfs( board, i, board[0].length-1);
        }
        for (int j = 0; j < board[0].length; j++) {

            dfs( board, 0, j);
        }
        for (int j = 0; j < board[0].length; j++) {

            dfs( board, board.length-1, j);
        }


        for (int i = 0; i < board.length; i++) {
            char[] chars = board[i];
            for (int j = 0; j < chars.length; j++) {
                char aChar = chars[j];
                if(aChar=='O'){
                   board[i][j]='X';

                }
                if(aChar=='#'){
                    board[i][j]='O';

                }
            }
        }
    }
    public void dfs(char[][] grid,int i,int j){
        if(i>=0 && i< grid.length && j>=0 && j<grid[0].length){


            char c=grid[i][j];
            if(c=='X'|| c=='#')
                return ;

            grid[i][j]='#';

            dfs(grid, i+1, j);
            dfs(grid, i, j+1);
            dfs(grid, i-1, j);
            dfs(grid, i, j-1);



        }

    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'X', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        SurroundedRegions surroundedRegions= new SurroundedRegions();
        surroundedRegions.solve(board);

        printBoard(board);
    }



    public static void printBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }


}
