import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;

        int verticalStart   = 0;
        int verticalEnd     = matrix.length;
        int horizontalStart = 0;
        int horizontalEnd   = matrix[0].length;

        while (horizontalStart < horizontalEnd
                && verticalStart   < verticalEnd) {

            // 1) top row, left→right
            for (int col = horizontalStart; col < horizontalEnd; col++) {
                list.add(matrix[verticalStart][col]);
            }
            verticalStart++;

            // 2) right column, top→bottom
            for (int row = verticalStart; row < verticalEnd; row++) {
                list.add(matrix[row][horizontalEnd - 1]);
            }
            horizontalEnd--;

            // 3) bottom row, right→left (if still valid)
            if (verticalStart < verticalEnd) {
                for (int col = horizontalEnd - 1; col >= horizontalStart; col--) {
                    list.add(matrix[verticalEnd - 1][col]);
                }
                verticalEnd--;
            }

            // 4) left column, bottom→top (if still valid)
            if (horizontalStart < horizontalEnd) {
                for (int row = verticalEnd - 1; row >= verticalStart; row--) {
                    list.add(matrix[row][horizontalStart]);
                }
                horizontalStart++;
            }
        }

        return list;
    }

    /*
*
* public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int m = matrix.length;
    int n = matrix[0].length;

    int top = 0, bottom = m - 1;
    int left = 0, right = n - 1;

    while (top <= bottom && left <= right) {

        // Traverse top row
        for (int j = left; j <= right; j++) {
            result.add(matrix[top][j]);
        }
        top++;

        // Traverse right column
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
        right--;

        // Traverse bottom row (if still within bounds)
        if (top <= bottom) {
            for (int j = right; j >= left; j--) {
                result.add(matrix[bottom][j]);
            }
            bottom--;
        }

        // Traverse left column (if still within bounds)
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
    }

    return result;
}

* */
    public static void main(String[] args) {
        int[][] matrix5 = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] matrix6 = {
                { 1,  2,  3,  4,  5,  6},
                { 7,  8,  9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };
// 8×8 matrix
        int[][] matrix8 = {
                { 1,  2,  3,  4,  5,  6,  7,  8},
                { 9, 10, 11, 12, 13, 14, 15, 16},
                {17, 18, 19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30, 31, 32},
                {33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48},
                {49, 50, 51, 52, 53, 54, 55, 56},
                {57, 58, 59, 60, 61, 62, 63, 64}
        };

// 9×9 matrix
        int[][] matrix9 = {
                {  1,  2,  3,  4,  5,  6,  7,  8,  9},
                { 10, 11, 12, 13, 14, 15, 16, 17, 18},
                { 19, 20, 21, 22, 23, 24, 25, 26, 27},
                { 28, 29, 30, 31, 32, 33, 34, 35, 36},
                { 37, 38, 39, 40, 41, 42, 43, 44, 45},
                { 46, 47, 48, 49, 50, 51, 52, 53, 54},
                { 55, 56, 57, 58, 59, 60, 61, 62, 63},
                { 64, 65, 66, 67, 68, 69, 70, 71, 72},
                { 73, 74, 75, 76, 77, 78, 79, 80, 81}
        };

        SpiralMatrix spiralMatrix= new SpiralMatrix();
        System.out.println(
        spiralMatrix.spiralOrder(matrix8));
    }
}
