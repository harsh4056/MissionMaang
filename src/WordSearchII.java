import java.util.*;

public class WordSearchII {

    public List<String> findWords(char[][] board, String[] words) {
        Trie root= new Trie();
        HashSet<String > list= new HashSet<>();
        for (String word : words) {
            root.insert(word);
        }
        Trie start= root;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i,j,board,start,list,new StringBuilder());
                start=root;
            }
        }
        List<String > answer= new ArrayList<>();
        for (String string : list) {
            answer.add(string);
        }

        return answer;
    }
    public void dfs(int i, int j, char[][]board, Trie root, HashSet<String> hashSet, StringBuilder sb){

        if(i>=0 && i< board.length && j>=0 && j<board[0].length && root!=null && board[i][j]!='*'){
            root=root.tries[board[i][j]-'a'];
            if(root==null) return;
            sb.append(board[i][j]);
            char temp=board[i][j];
            board[i][j]='*';
            if(root.present){
                hashSet.add(sb.toString());
            }
            dfs(i+1,j,board,root,hashSet, sb);
            dfs(i,j+1,board,root,hashSet, sb);
            dfs(i-1,j,board,root,hashSet, sb);
            dfs(i,j-1,board,root,hashSet, sb);

            board[i][j]=temp;
            sb.deleteCharAt(sb.length()-1);

        }
    }
    class Trie{
        Trie[] tries;
        boolean present;

        public Trie() {
            tries=new Trie[26];
            present=false;
        }

        public void insert(String word){
            char[]cs =word.toCharArray();
            Trie curr=this;
            for (char c : cs) {
               if(curr.tries[c-'a']==null){
                   curr.tries[c-'a']=new Trie();
               }
               curr=curr.tries[c-'a'];

            }
            curr.present=true;

        }

    }
    public static void main(String[] args) {
        WordSearchII ws = new WordSearchII();

        // Test case 1
        char[][] board1 = {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words1 = {"oath","pea","eat","rain"};
        printResult(ws.findWords(board1, words1));
        // Expected: [oath, eat]

        // Test case 2
        char[][] board2 = {
                {'a','b'},
                {'c','d'}
        };
        String[] words2 = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
        printResult(ws.findWords(board2, words2));
        // Expected: [ab, ac, bd, ca, db]

        // Test case 3
        char[][] board3 = {
                {'a','a'}
        };
        String[] words3 = {"aaa"};
        printResult(ws.findWords(board3, words3));
        // Expected: []
    }

    private static void printResult(List<String> result) {
        System.out.println(result);
    }



}
