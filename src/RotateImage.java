public class RotateImage {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        int len=n/2;
        for(int i=0;i<len;i++){
            for(int j=i;j<n-i;i++){
                int lastIndex=n-i-1;
                int temp= matrix[j][lastIndex];
                matrix[j][lastIndex]=matrix[i][j];
                matrix[i][j]=matrix[lastIndex-j][i];
                matrix[lastIndex-j][i]=matrix[i][lastIndex-j];
                matrix[i][lastIndex-j]=temp;

            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {
                { 5,  1,  9, 11},
                { 2,  4,  8, 10},
                {13,  3,  6,  7},
                {15, 14, 12, 16}
        };

        RotateImage rotateImage= new RotateImage();
        rotateImage.rotate(matrix);
        System.out.println();
    }
}
