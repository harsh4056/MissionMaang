import java.util.Arrays;

public class LongestIncreasingPathInMatrix {

    public int longestIncreasingPath(int[][] matrix) {
        int [][]dp= new int[matrix.length][matrix[0].length];
        /*for (int[] ints : dp) {
                Arrays.fill(ints,1);
        }*/
        int max=Integer.MIN_VALUE;
        for(int i=0;i< matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
               int value= dfs(matrix,i,j,dp);
               max=Math.max(max,value);
            }
        }
        return max;

    }
    public int dfs(int[][] matrix,int i,int j, int[][]dp){

        if(dp[i][j]!=0) return dp[i][j];
        int [][]directions={{0,1},{1,0},{0,-1},{-1,0}};
        int max=1;
        for (int[] direction : directions) {
            int rr=i+direction[0];
            int cc=j+direction[1];
            int value=0;
            if(rr>=0 && rr< matrix.length && cc>=0 && cc<matrix[0].length && matrix[i][j]<matrix[rr][cc]){
                value=1+dfs(matrix,rr,cc,dp);
            }
            max=Math.max(max,value);
        }
        return dp[i][j]=max;
    }
    public static void main(String[] args) {
        LongestIncreasingPathInMatrix sol = new LongestIncreasingPathInMatrix();

        int[][] matrix1 = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(sol.longestIncreasingPath(matrix1));
        // Expected: 4 (Path: 1 → 2 → 6 → 9)

        int[][] matrix2 = {
                {3,4,5},
                {3,2,6},
                {2,2,1}
        };
        System.out.println(sol.longestIncreasingPath(matrix2));
        // Expected: 4 (Path: 3 → 4 → 5 → 6)

        int[][] matrix3 = {
                {1}
        };
        System.out.println(sol.longestIncreasingPath(matrix3));
        // Expected: 1 (Only one element)
    }

}
