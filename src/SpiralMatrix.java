import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {

        int i = 0;
        int j = 0;
        int startRow=0;
        int startColumn=0;
        int rowsLength=matrix.length-1;
        int columnsLength= matrix[0].length-1;
        int mainCount=(matrix[0].length)* (matrix.length);
        List<Integer> list= new ArrayList<>();
        while(mainCount>0){

            i=startColumn;
            for (j = startColumn; j <=columnsLength; j++) {
                int value=matrix[i][j];
                list.add(value);
                mainCount--;
            }
            if(mainCount==0){
                break;
            }

            startRow++;
            j=columnsLength;
            for (i=startRow; i <=rowsLength; i++) {
                int value=matrix[i][j];
                list.add(value);
                mainCount--;
            }
            if(mainCount==0){
                break;
            }
            columnsLength--;
            i=rowsLength;
            for (j = columnsLength; j >=startColumn; j--) {
                int value=matrix[i][j];
                list.add(value);
                mainCount--;
            }
            if(mainCount==0){
                break;
            }
            j=startColumn;
            rowsLength--;
            for(i=rowsLength;i>=startRow;i--){
                int value=matrix[i][j];
                list.add(value);
                mainCount--;
            }
            if(mainCount==0){
                break;
            }
            startColumn++;


        }

        return list;
    }
/*
*
* public List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    int m = matrix.length;
    int n = matrix[0].length;

    int top = 0, bottom = m - 1;
    int left = 0, right = n - 1;

    while (top <= bottom && left <= right) {

        // Traverse top row
        for (int j = left; j <= right; j++) {
            result.add(matrix[top][j]);
        }
        top++;

        // Traverse right column
        for (int i = top; i <= bottom; i++) {
            result.add(matrix[i][right]);
        }
        right--;

        // Traverse bottom row (if still within bounds)
        if (top <= bottom) {
            for (int j = right; j >= left; j--) {
                result.add(matrix[bottom][j]);
            }
            bottom--;
        }

        // Traverse left column (if still within bounds)
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
            }
            left++;
        }
    }

    return result;
}

* */
    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13,14, 15, 16}
        };


        SpiralMatrix spiralMatrix= new SpiralMatrix();
        spiralMatrix.spiralOrder(matrix);
    }
}
