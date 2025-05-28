import java.util.List;

public class PrintBorderOfMatrix {

    public void printBorders(int [][]matrix){
        int horizontalEnd=matrix.length;
        int horizontalStart=0;
        int verticalEnd= matrix[0].length;
        int verticalStart=0;

        int i=0;int j=0;
        for (; j < matrix[0].length; j++) {
            System.out.print(matrix[i][j]);
            System.out.print(" ");
        }
        j=j-1;
        i=i+1;

        for (; i < matrix.length; i++) {
            System.out.print(matrix[i][j]);
            System.out.print(" ");
        }
        i=i-1;
        j=j-1;
        for (; j >= 0; j--) {
            System.out.print(matrix[i][j]);
            System.out.print(" ");
        }
        j=j+1;
        i=i-1;
        for (; i > 0; i--) {
            System.out.print(matrix[i][j]);
            System.out.print(" ");
        }
        i=i+1;
    }


    public List<Integer> spiralOrder(int[][] matrix) {

        int horizontalEnd=matrix[0].length;
        int horizontalStart=0;
        int verticalEnd= matrix.length; ;
        int verticalStart=0;

        int i=0;int j=0;
        while (horizontalStart<matrix[0].length-1) {
            for (; j < horizontalEnd; j++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            j = j - 1;
            i = i + 1;

            for (; i < verticalEnd; i++) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            i = i - 1;
            j = j - 1;
            for (; j >= horizontalStart; j--) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            j = j + 1;
            i = i - 1;
            for (; i > verticalStart; i--) {
                System.out.print(matrix[i][j]);
                System.out.print(" ");
            }
            i = i + 1;
            j=  j + 1;
            verticalEnd--;
            horizontalEnd--;
            verticalStart = 1;
            horizontalStart++;
        }
        return null;
    }


    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        PrintBorderOfMatrix printBorderOfMatrix= new PrintBorderOfMatrix();
        printBorderOfMatrix.printBorders(matrix);
    }
}
