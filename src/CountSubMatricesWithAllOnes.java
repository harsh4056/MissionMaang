public class CountSubMatricesWithAllOnes {

    public int numSubmat(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] height = new int[n];
        int res = 0;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                // update height
                height[j] = mat[i][j] == 0 ? 0 : height[j] + 1;

                System.out.println("i=" + i + " j=" + j +
                        " height[j]=" + height[j] +
                        " res(before inner)=" + res);

                for (int k = j, min = height[j]; k >= 0 && min > 0; k--) {

                    int beforeMin = min;
                    int hk = height[k];

                    min = Math.min(min, hk);

                    System.out.println(
                            "    i=" + i +
                                    " j=" + j +
                                    " k=" + k +
                                    " height[j]=" + height[j] +
                                    " height[k]=" + hk +
                                    " min(before)=" + beforeMin +
                                    " min(after)=" + min +
                                    " res(before add)=" + res
                    );

                    res += min;

                    System.out.println(
                            "    res(after add)=" + res
                    );
                }

                System.out.println("-----------------------------");
            }
        }

        System.out.println("FINAL RESULT = " + res);
        return res;
    }

    public static void main(String[] args) {
        CountSubMatricesWithAllOnes sol = new CountSubMatricesWithAllOnes();

        int[][] mat1 = {
                {1,0,1},
                {1,1,0},
                {1,1,0}
        };
        System.out.println(sol.numSubmat(mat1)); // Expected: 13

  /*      int[][] mat2 = {
                {1,1,1},
                {1,1,1}
        };
        System.out.println(sol.numSubmat(mat2)); // Expected: 18

        int[][] mat3 = {
                {0,1,1,0},
                {1,1,1,1},
                {0,1,1,1}
        };
        System.out.println(sol.numSubmat(mat3)); // Expected: 24*/
    }

}
