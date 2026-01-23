import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int t=0;
        int b=n-1;
        int l=0;
        int r=m-1;
        int count=n*m;
        List<Integer> list= new ArrayList<>();
        while(count>0){
            for(int i=l;i<=r && count>0;i++){
                list.add(matrix[t][i]);
                count--;
            }
            t++;

            for(int i=t;i<=b&& count>0;i++){
                list.add(matrix[i][r]);
                count--;
            }
            r--;

            for(int i=r;i>=l&& count>0;i--){
                list.add(matrix[b][i]);
                count--;
            }
            b--;

            for(int i=b;i>=t&& count>0;i--){
                list.add(matrix[i][l]);
                count--;
            }
            l++;


        }
        return list;
    }


    public static void main(String[] args) {
        int[][] matrix5 = {
                { 1,  2,  3,  4,  5},
                { 6,  7,  8,  9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };
        int[][] matrix6 = {
                { 1,  2,  3,  4,  5,  6},
                { 7,  8,  9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };
// 8×8 matrix
        int[][] matrix8 = {
                { 1,  2,  3,  4,  5,  6,  7,  8},
                { 9, 10, 11, 12, 13, 14, 15, 16},
                {17, 18, 19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30, 31, 32},
                {33, 34, 35, 36, 37, 38, 39, 40},
                {41, 42, 43, 44, 45, 46, 47, 48},
                {49, 50, 51, 52, 53, 54, 55, 56},
                {57, 58, 59, 60, 61, 62, 63, 64}
        };

// 9×9 matrix
        int[][] matrix9 = {
                {  1,  2,  3,  4,  5,  6,  7,  8,  9},
                { 10, 11, 12, 13, 14, 15, 16, 17, 18},
                { 19, 20, 21, 22, 23, 24, 25, 26, 27},
                { 28, 29, 30, 31, 32, 33, 34, 35, 36},
                { 37, 38, 39, 40, 41, 42, 43, 44, 45},
                { 46, 47, 48, 49, 50, 51, 52, 53, 54},
                { 55, 56, 57, 58, 59, 60, 61, 62, 63},
                { 64, 65, 66, 67, 68, 69, 70, 71, 72},
                { 73, 74, 75, 76, 77, 78, 79, 80, 81}
        };

        SpiralMatrix spiralMatrix= new SpiralMatrix();
        System.out.println(
        spiralMatrix.spiralOrder(matrix8));
    }
}
