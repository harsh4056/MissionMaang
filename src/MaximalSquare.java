public class MaximalSquare {


    public int maximalSquare(char[][] matrix) {
        int max=0;
        int [][]dp= new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                dp[i][j]=matrix[i][j]-'0';
                max=Math.max(dp[i][j],max);
                if(i-1>=0 && j-1>=0){
                    if(dp[i][j]==1) {
                       int val= Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                        dp[i][j]=val;
                       max=Math.max(val,max);
                    }
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        MaximalSquare ms = new MaximalSquare();
        char[][] matrix = {
                {'1', '0'},
                {'0', '1'},

        };
        int result = ms.maximalSquare(matrix);
        System.out.println("Largest square area: " + (result * result));
    }

}
