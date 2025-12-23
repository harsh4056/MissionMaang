public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        int mini = Integer.MAX_VALUE;
        for (int i = 1; i < matrix.length; i++) {
            int[] currMatrix = matrix[i - 1];
            for (int j = 0; j < currMatrix.length; j++) {
                int up = currMatrix[j];
                int upLeft = j - 1 >= 0 ? currMatrix[j - 1] : Integer.MAX_VALUE;
                int upRight = j + 1 < currMatrix.length ? currMatrix[j + 1] : Integer.MAX_VALUE;
                matrix[i][j] += Math.min(up, Math.min(upLeft, upRight));

            }

        }
        for(int val: matrix[matrix.length-1]) mini=Math.min(mini,val);
        return mini;
    }

    public static void main(String[] args) {
        MinimumFallingPathSum obj = new MinimumFallingPathSum();

        int[][] matrix1 = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}
        };
        System.out.println(obj.minFallingPathSum(matrix1));
        // Expected: 13 (2 -> 1 -> 4 -> 6 is invalid, correct path: 1 + 5 + 7 = 13)

        int[][] matrix2 = {
                {-19, 57},
                {-40, -5}
        };
        System.out.println(obj.minFallingPathSum(matrix2));
        // Expected: -59 (-19 + -40)

        int[][] matrix3 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(obj.minFallingPathSum(matrix3));
        // Expected: 12 (1 + 4 + 7)
    }

}
