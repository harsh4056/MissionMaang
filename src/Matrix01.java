import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Matrix01 {

    public int[][] updateMatrix(int[][] mat) {
        int[][]answer=new int[mat.length][mat[0].length];
        Queue<int[]> queue= new ArrayDeque<>();
        for (int i = 0; i < (mat.length); i++) {
            for (int j = 0; j < mat[0].length; j++) {
                answer[i][j]=Integer.MAX_VALUE;
                if(mat[i][j]==0) {
                    answer[i][j]=0;
                  queue.offer(new int[]{i,j});
                }
            }
        }
        int [][] directions= new int[][]{{1,0},{0,1},{-1,0},{0,-1}};

        while (!queue.isEmpty()){

            int []zeroTemp= queue.poll();
            for (int[] direction : directions) {
                int i=direction[0]+zeroTemp[0];
                int j=direction[1]+zeroTemp[1];
                if(i>=0 && i< mat.length && j>=0 && j<mat[0].length && mat[i][j]!=0){
                    if(answer[i][j]==Integer.MAX_VALUE){
                        answer[i][j] = answer[zeroTemp[0]][zeroTemp[1]] + 1;
                        queue.offer(new int[]{i,j});
                    }
                }

            }

        }

        return answer;
    }




    public static void main(String[] args) {
        Matrix01 matrix01 = new Matrix01();

        int[][] mat1 = {
                {1, 0},
                {1, 1},
        };
        printMatrix(matrix01.updateMatrix(mat1));

        int[][] mat2 = {
                {0, 1, 1},
                {1, 1, 1},
                {1, 1, 0}
        };
        printMatrix(matrix01.updateMatrix(mat2));

        int[][] mat3 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        printMatrix(matrix01.updateMatrix(mat3));
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
