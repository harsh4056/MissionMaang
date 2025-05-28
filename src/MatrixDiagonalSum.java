public class MatrixDiagonalSum {

    public int diagonalSum(int[][] mat) {
        int sum=0;
        int n= mat.length-1;
        for (int i = 0; i < mat.length; i++) {
           sum+=mat[i][i];
        }
        for (int i = 0; i < mat.length; i++) {
            sum+=mat[i][n-i];
        }
        n= mat.length;
        if(n%2==1){
            sum-=mat[n/2][n/2];
        }
        return sum;
    }
}
