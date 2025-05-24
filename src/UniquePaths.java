public class UniquePaths {


    public int uniquePaths(int m, int n) {
        int up= m+n-2;
        int down=m-1;
        int div=1;
        long data=1;
        for (int i = up-down+1; i <= up; i++) {
            data*=i;
            data/=div;
            div++;
        }

        return Math.toIntExact(data);
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths= new UniquePaths();
        uniquePaths.uniquePaths(10,10);
    }
}
