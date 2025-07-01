import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        char[][]memo= new char[n][n];
        boolean [] lowerDiagonal= new boolean[(2*n-1)];
        boolean [] upperDiagonal= new boolean[(2*n-1)];
        boolean [] leftRow= new boolean[n];
        for (char[] chars : memo) {
            Arrays.fill(chars,'.');
        }
        List<List<String>> answer = new ArrayList<>();
        solve(n,0,memo,lowerDiagonal,upperDiagonal,leftRow,answer);
        return answer;
    }


    public void solve(int n,int column, char[][]memo,boolean [] lowerDiagonal,boolean [] upperDiagonal,boolean [] leftRow,List<List<String>> answer){
        if(column>n ){
            return;
        }
        if(column==n){
            List<String> list = new ArrayList<>();
            for (char[] chars : memo) {
                list.add(String.valueOf(chars,0,n));
            }
            answer.add(list);
            return;
        }

        for (int row = 0; row < n; row++) {
            if(lowerDiagonal[row+column] || upperDiagonal[(n-1)+(column-row)] || leftRow[row]){
                continue;
            }
            lowerDiagonal[row+column] =true;
            upperDiagonal[(n-1)+(column-row)] =true;
            leftRow[row]=true;
            memo[row][column]='Q';
            solve(n,column+1,memo,lowerDiagonal,upperDiagonal,leftRow,answer);
            lowerDiagonal[row+column] =false;
            upperDiagonal[(n-1)+(column-row)] =false;
            leftRow[row]=false;
            memo[row][column]='.';

        }


    }

    public static void main(String[] args) {
        NQueens nQueens= new NQueens();
        System.out.println(nQueens.solveNQueens(8));
    }
}
