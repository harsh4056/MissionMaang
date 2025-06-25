public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {

                int upLeft=(j-1)>=0?matrix[i-1][j-1]:Integer.MAX_VALUE;
                int upRight=(j+1)<matrix[0].length?matrix[i-1][j+1]:Integer.MAX_VALUE;
                int up=matrix[i-1][j];
                matrix[i][j]=matrix[i][j]+Math.min(up,Math.min(upLeft,upRight));
            }

        }
        int min=Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            min=Math.min(min,matrix[matrix.length-1][j]);
        }
        return min;
    }
}
