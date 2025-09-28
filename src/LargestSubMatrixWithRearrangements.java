import java.util.*;

public class LargestSubMatrixWithRearrangements {

    public int largestSubmatrix(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[j][i]!=0){
                    matrix[j][i]=matrix[j-1][i]+matrix[j][i];
                }
            }
        }
        int max=0;
        for(int []mat:matrix){
            Arrays.sort(mat);
            int runMin=Integer.MAX_VALUE;
            for(int i=m-1;i>=0;i--){
                int curr=mat[i];
                runMin=Math.min(runMin,curr);
                max=Math.max(runMin*(m-i),max);
            }
        }
        return max;
    }




    public static void main(String[] args) {
        LargestSubMatrixWithRearrangements solver = new LargestSubMatrixWithRearrangements();

        int[][] matrix2 = {
                {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,0,1,1},
                {0,1,1,0,1,1,1,1,0,1,1,0,0,1,0,1,1,1,1,0,1,1,1,1,1,1}
        };
        System.out.println("Example 2: " + solver.largestSubmatrix(matrix2)); // Expected: 3

        int[][] matrix3 = {
                {1, 1, 0},
                {1, 0, 1}
        };
        System.out.println("Example 3: " + solver.largestSubmatrix(matrix3)); // Expected: 2

        int[][] matrix1 = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println("Test Case 1: " + solver.largestSubmatrix(matrix1)); // Expected: 4



    }

}
