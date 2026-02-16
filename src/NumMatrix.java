class NumMatrix {
    int[][]P;
    public NumMatrix(int[][] matrix) {
        int n= matrix.length;;
        int m= matrix[0].length;
        P = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                P[i][j]= matrix[i-1][j-1]+P[i-1][j]+P[i][j-1]-P[i-1][j-1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        row1=row1+1;
        row2=row2+1;
        col1=col1+1;
        col2=col2+1;
        return (P[row2][col2]-P[row1-1][col2]-P[row2][col1-1]+P[row1-1][col1-1]);

    }

    public static void main(String[] args) {



        int[][] matrix2 = {
                {1, 2},
                {3, 4}
        };

        NumMatrix obj2 = new NumMatrix(matrix2);

        System.out.println(obj2.sumRegion(0, 0, 1, 1)); // Expected: 10
        System.out.println(obj2.sumRegion(0, 1, 1, 1)); // Expected: 6
        System.out.println(obj2.sumRegion(1, 0, 1, 0)); // Expected: 3


        int[][] matrix1 = {
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        };

        NumMatrix obj1 = new NumMatrix(matrix1);

        System.out.println(obj1.sumRegion(2, 1, 4, 3)); // Expected: 8
        System.out.println(obj1.sumRegion(1, 1, 2, 2)); // Expected: 11
        System.out.println(obj1.sumRegion(1, 2, 2, 4)); // Expected: 12



        int[][] matrix3 = {
                {5}
        };

        NumMatrix obj3 = new NumMatrix(matrix3);

        System.out.println(obj3.sumRegion(0, 0, 0, 0)); // Expected: 5
    }

}
