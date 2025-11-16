public class IncrementSubmatricesByOne {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][]matrix= new int[n][n];

        for (int[] query : queries) {
            int r1=query[0];
            int c1=query[1];
            int r2=query[2];
            int c2=query[3];
            for(int i=r1;i<=r2;i++){
                for (int j = c1; j <=c2 ; j++) {
                    matrix[i][j]++;
                }

            }
        }

        return matrix;
    }

    public static void main(String[] args) {
        IncrementSubmatricesByOne sol = new IncrementSubmatricesByOne();

        int[][] q1 = {
                {1, 1, 2, 2},
                {0, 0, 1, 1}
        };
        int[][] r1 = sol.rangeAddQueries(3, q1);
        print(r1); // expected: [[1,1,0],[1,2,1],[0,1,1]]

        int[][] q2 = {
                {0, 0, 1, 1}
        };
        int[][] r2 = sol.rangeAddQueries(2, q2);
        print(r2); // expected: [[1,1],[1,1]]
    }

    private static void print(int[][] m) {
        for (int[] row : m) System.out.println(java.util.Arrays.toString(row));
        System.out.println();
    }


}
