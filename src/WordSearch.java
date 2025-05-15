public class WordSearch {

    public boolean exist(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(backTrack(board,i,j,word.toCharArray(),0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean backTrack(char[][] board,int i,int j, char[]word,int wordIndex){
        if(i>=0 && i< board.length && j>=0&& j<board[0].length) {
            if (wordIndex == word.length - 1 && board[i][j]==word[wordIndex]) {
                return true;
            }

            if(board[i][j]==word[wordIndex]){
                char temp = board[i][j];
                board[i][j] = '#';
               if( backTrack(board, i + 1, j, word, wordIndex + 1)||
                backTrack(board, i, j + 1, word, wordIndex + 1)||
                backTrack(board, i - 1, j, word, wordIndex + 1)||
                backTrack(board, i, j - 1, word, wordIndex + 1)){
                   return true;
               }
                board[i][j] = temp;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        String word = "ABCCED";
        System.out.println(wordSearch.exist(board, word));  // Expected: true
    }

}
