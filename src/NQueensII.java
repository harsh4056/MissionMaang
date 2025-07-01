import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueensII {

    int answer=0;
    public int totalNQueens(int n) {
        boolean [] lowerDiagonal= new boolean[(2*n-1)];
        boolean [] upperDiagonal= new boolean[(2*n-1)];
        boolean [] leftRow= new boolean[n];
        solve(n,0,lowerDiagonal,upperDiagonal,leftRow);
        return answer;
    }





    public void solve(int n,int column, boolean [] lowerDiagonal,boolean [] upperDiagonal,boolean [] leftRow){
        if(column>n ){
            return;
        }
        if(column==n){
          answer++;
          return;
        }
        for (int row = 0; row < n; row++) {
            if(lowerDiagonal[row+column] || upperDiagonal[(n-1)+(column-row)] || leftRow[row]){
                continue;
            }
            lowerDiagonal[row+column] =true;
            upperDiagonal[(n-1)+(column-row)] =true;
            leftRow[row]=true;

            solve(n,column+1,lowerDiagonal,upperDiagonal,leftRow);
            lowerDiagonal[row+column] =false;
            upperDiagonal[(n-1)+(column-row)] =false;
            leftRow[row]=false;
        }
    }

    public static void main(String[] args) {
        NQueensII nQueens= new NQueensII();
        System.out.println(nQueens.totalNQueens(15));
    }

}
