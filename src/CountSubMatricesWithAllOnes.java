public class CountSubMatricesWithAllOnes {

    public int numSubmat(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] nums = new int[rows][cols];
        int total = 0;

        // Step 1: Build histogram heights
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    nums[i][j] = 0;
                } else {
                    nums[i][j] = (i == 0 ? 1 : nums[i - 1][j] + 1);
                }
            }
        }

        // Step 2: For each row, count rectangles ending at this row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int minHeight = Integer.MAX_VALUE;
                for (int k = j; k < cols; k++) {
                    minHeight = Math.min(minHeight, nums[i][k]);
                    total += minHeight; // add contribution
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        CountSubMatricesWithAllOnes sol = new CountSubMatricesWithAllOnes();

        int[][] mat1 = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(sol.numSubmat(mat1)); // Expected: 13

        int[][] mat2 = {
                {1,1,1},
                {1,1,1}
        };
        System.out.println(sol.numSubmat(mat2)); // Expected: 18

        int[][] mat3 = {
                {0,1,1,0},
                {1,1,1,1},
                {0,1,1,1}
        };
        System.out.println(sol.numSubmat(mat3)); // Expected: 24
    }

}
