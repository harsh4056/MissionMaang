public class CaughtUnguardedCellsInGrid {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
       int [][]matrix= new int[m][n];
       int green=0;

        for(int[]wall:walls){
            matrix[wall[0]][wall[1]]=1;
        }
        for(int[]guard:guards){
            int row=guard[0];
            int column=guard[1];

            //left
            for(int i=column;i>=0;i--){
                if(matrix[row][i]==1) break;
                matrix[row][i]=2;
            }
            //right
            for(int i=column;i<n;i++){
                if(matrix[row][i]==1) break;
                matrix[row][i]=2;
            }
            //up
            for(int i=row;i>=0;i--){
                if(matrix[i][column]==1) break;
                matrix[i][column]=2;
            }
            //down
            for(int i=row;i<m;i++){
                if(matrix[i][column]==1) break;
                matrix[i][column]=2;
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j]==0) green++;
            }
        }
        return green;

    }

    public static void main(String[] args) {
        CaughtUnguardedCellsInGrid solution = new CaughtUnguardedCellsInGrid();

        // Test case 1
        int m1 = 4, n1 = 6;
        int[][] guards1 = {{0,0},{1,1},{2,3}};
        int[][] walls1 = {{0,1},{2,2},{1,4}};
        int result1 = solution.countUnguarded(m1, n1, guards1, walls1);
        System.out.println("Test Case 1 Result: " + result1); // Expected: (depends on logic fix, likely >0)

        // Test case 2
        int m2 = 3, n2 = 3;
        int[][] guards2 = {{1,1}};
        int[][] walls2 = {{0,1}};
        int result2 = solution.countUnguarded(m2, n2, guards2, walls2);
        System.out.println("Test Case 2 Result: " + result2); // Expected: (depends on logic fix, likely >0)

        // Test case 3
        int m3 = 2, n3 = 2;
        int[][] guards3 = {};
        int[][] walls3 = {};
        int result3 = solution.countUnguarded(m3, n3, guards3, walls3);
        System.out.println("Test Case 3 Result: " + result3); // Expected: 4 (since no guards/walls)
    }

}
