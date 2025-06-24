public class UniquePaths {


    public int uniquePaths(int m, int n) {
       int[][]paths= new int[m][n];

        for (int i = 1; i <= paths.length; i++) paths[i-1][0]=1;
        for (int i = 1; i <= paths[0].length; i++) paths[0][i-1]=1;

        for (int i = 1; i <paths.length ; i++) {
            for (int j = 1; j <paths[0].length; j++) {
                paths[i][j]=paths[i-1][j]+paths[i][j-1];
            }
        }

        return paths[m-1][n-1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();

        System.out.println(uniquePaths.uniquePaths(3, 7)); // Expected: 28
        System.out.println(uniquePaths.uniquePaths(3, 2)); // Expected: 3
        System.out.println(uniquePaths.uniquePaths(10, 10)); // Expected: 48620
    }

}
