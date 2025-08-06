import javax.swing.text.StyleContext;

public class SpiralMatrixGiveN {

    public int[][] spiralMatrix(int n){

        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        int count=0;
        int [][]matrix= new int[n][n];
        while(count<n*n) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = count++;
            }
            right--;
            for(int i=right;i>=left;i--){
                matrix[bottom][i] = count++;
            }
            bottom--;
            for(int i=bottom;i>=top;i--){
                matrix[i][left]=count++;
            }
            left++;

        }
        return matrix;
    }

    public static void main(String[] args) {
        SpiralMatrixGiveN solution = new SpiralMatrixGiveN();

        // Test Case 1: n = 3
        int[][] result1 = solution.spiralMatrix(3);
        printMatrix(result1);
        // Expected:
        // 0 1 2
        // 7 8 3
        // 6 5 4

        // Test Case 2: n = 1
        int[][] result2 = solution.spiralMatrix(1);
        printMatrix(result2);
        // Expected:
        // 0

        // Test Case 3: n = 4
        int[][] result3 = solution.spiralMatrix(4);
        printMatrix(result3);
        // Expected:
        // 0 1 2 3
        // 11 12 13 4
        // 10 15 14 5
        // 9 8 7 6
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

}
