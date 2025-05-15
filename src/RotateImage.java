public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Step 1: Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            int left = 0, right = n - 1;
            while (left < right) {
                int temp = matrix[i][left];
                matrix[i][left] = matrix[i][right];
                matrix[i][right] = temp;
                left++;
                right--;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                { 5,  1,  9, 11},
                { 2,  4,  8, 10},
                {13,  3,  6,  7},
                {15, 14, 12, 16}
        };

        RotateImage rotateImage= new RotateImage();
        rotateImage.rotate(matrix);
        System.out.println();
    }
}
