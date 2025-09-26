public class MinimumOperationsToMakeColumnIncreasing {

    public int minimumOperations(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int sum=0;
        for(int j=0;j<m;j++){
            int prev=grid[0][j];
            for(int i=1;i<n;i++){
                if(prev>=grid[i][j]){
                    int diff= prev-grid[i][j]+1;
                    sum+=diff;
                    prev=diff+grid[i][j];
                }
                else{
                    prev=grid[i][j];
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        MinimumOperationsToMakeColumnIncreasing sol = new MinimumOperationsToMakeColumnIncreasing();

        int[][] grid1 = {{3, 2, 1}, {2, 1, 1}, {1, 1, 1}};
        System.out.println(sol.minimumOperations(grid1)); // Expected: 14

        int[][] grid2 = {{1, 2, 3}, {2, 3, 4}, {3, 4, 5}};
        System.out.println(sol.minimumOperations(grid2)); // Expected: 0

        int[][] grid3 = {{5}, {4}, {3}, {2}, {1}};
        System.out.println(sol.minimumOperations(grid3)); // Expected: 20
    }

}
