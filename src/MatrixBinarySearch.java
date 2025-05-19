public class MatrixBinarySearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int left = 0;
        int right = rows * cols - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int i = mid / cols;
            int j = mid % cols;

            int value = matrix[i][j];

            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        MatrixBinarySearch ms = new MatrixBinarySearch();
        System.out.println(ms.searchMatrix(new int[][]{{1}}, 1));  // true
        System.out.println(ms.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 3));  // true
        System.out.println(ms.searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}}, 13)); // false
    }
}
