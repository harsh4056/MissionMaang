public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows= matrix.length;
        int columns=matrix[0].length;
        int left=0;
        int right=rows*columns-1;

        while (left<right){
            int mid=(left+right)>>>1;
            int i=mid/columns;
            int j=mid%columns;

            if(matrix[i][j]>=target){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        int i=left/columns;
        int j=left%columns;
        return  matrix[i][j]==target;


    }

    public static void main(String[] args) {
        SearchIn2DMatrix obj = new SearchIn2DMatrix();

        int[][] matrix1 = {
                {1, 2, 4, 8},
                {10, 11, 12, 13},
                {14, 20, 30, 40}
        };
        System.out.println(obj.searchMatrix(matrix1, 10)); // expected: true

        int[][] matrix2 = {
                {1, 2, 4, 8},
                {10, 11, 12, 13},
                {14, 20, 30, 40}
        };
        System.out.println(obj.searchMatrix(matrix2, 15)); // expected: false

        int[][] matrix3 = {
                {1, 3, 5},
                {7, 9, 11}
        };
        System.out.println(obj.searchMatrix(matrix3, 11)); // expected: true
    }


}
