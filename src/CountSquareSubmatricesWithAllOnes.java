public class CountSquareSubmatricesWithAllOnes {

    public int countSquares(int[][] matrix) {
    int n=matrix.length;
    int m=matrix[0].length;


        int count=0;




        for (int i = 1; i <n ; i++) {
            for (int j = 1; j <m ; j++) {
                if(matrix[i][j]==1){
                    int val=Math.min(Math.min(matrix[i-1][j-1],matrix[i-1][j]),matrix[i][j-1]);
                    matrix[i][j]=1+val;
                }

            }
        }
        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<m; j++)
            {
                count += matrix[i][j];
            }
        }

        return count;
    }
    public static void main(String[] args) {
        CountSquareSubmatricesWithAllOnes solution = new CountSquareSubmatricesWithAllOnes();

        int[][] matrix1 = {
                {1, 0, 1},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(solution.countSquares(matrix1)); // Expected: 7

        int[][] matrix2 = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };
        System.out.println(solution.countSquares(matrix2)); // Expected: 15

        int[][] matrix3 = {
                {1, 1},
                {1, 1}
        };
        System.out.println(solution.countSquares(matrix3)); // Expected: 5
    }

}
