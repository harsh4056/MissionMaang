import java.util.HashSet;

public class SetMatrixZeros {



    public void setZeroes(int[][] matrix) {

        HashSet<Integer> rows= new HashSet<>();
        HashSet<Integer> columns= new HashSet<>();

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[0].length; j++) {

                int val=matrix[i][j];
                if(val==0){
                    rows.add(i);
                    columns.add(j);
                }

            }

        }
        for (Integer column : columns) {
            for (int i = 0; i < matrix.length; i++) {
               matrix[i][column]=0;

            }
        }
        for (Integer row : rows) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[row][i]=0;

            }
        }


    }

    public static void main(String[] args) {
        // Example 1
        int[][] input1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };



        // Example 2
        int[][] input2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };

      SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
      setMatrixZeros.setZeroes(input2);
        System.out.println();
    }

}
