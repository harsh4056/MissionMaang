import java.util.HashSet;

public class SetMatrixZeros {



    public void setZeroes(int[][] matrix) {
        int SENTINEL=(int)1e9 +1;
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0){
                    matrix[i][0]=SENTINEL;
                    matrix[0][j]=SENTINEL;
                }
            }
        }
        boolean first=matrix[0][0]==SENTINEL;

        for(int i=0;i<n;i++){
            if(matrix[i][0]==SENTINEL){

                for(int j=0;j<m;j++){
                    matrix[i][j]=0;
                }

            }
        }
        if(first){
            matrix[0][0]=SENTINEL;
        }
        for(int j=0;j<m;j++){
            if(matrix[0][j]==SENTINEL){
                for(int i=0;i<n;i++){
                    matrix[i][j]=0;
                }
            }
        }
        int a=0;
        a=2;
    }

    public static void main(String[] args) {
        // Example 1
        int[][] input1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };

        int[][] input2 = {
                {0, 1},
                {1, 1},

        };


        int[][] input3 = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}

        };



      SetMatrixZeros setMatrixZeros = new SetMatrixZeros();
      setMatrixZeros.setZeroes(input3);
        System.out.println();
    }

}
