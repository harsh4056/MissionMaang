import java.util.Arrays;

public class OnesAndZeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][]dp=new int[m+1][n+1][strs.length];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,-1);
            }
        }
        return dfs(strs,m,n,0,dp);
    }

    public int dfs(String[] strs, int m, int n, int index,int[][][]dp){
        if(index>=strs.length){
            return 0;
        }
        if(dp[m][n][index]!=-1) return dp[m][n][index];
        int []count=countZeros(strs[index]);
        int take=0;
        if(m-count[0]>=0 && n-count[1]>=0)
         take=1+dfs(strs,m-count[0],n-count[1],index+1,dp);
        int skip=dfs(strs,m,n,index+1,dp);
        return dp[m][n][index]=Math.max(take,skip);
    }

    public int[] countZeros(String binary){
        int []count= new int[]{0,0};

        for(char c:binary.toCharArray()){
            count[c-'0']++;
        }
        return count;
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int[][][]dp=new int[m+1][n+1][strs.length];
        for (int[][] ints : dp) {
            for (int[] anInt : ints) {
                Arrays.fill(anInt,-1);
            }
        }
        return dfs(strs,m,n,0,dp);
    }

    public static void main(String[] args) {
        OnesAndZeros solution = new OnesAndZeros();

        String[] strs1 = {"10", "0001", "111001", "1", "0"};
        int m1 = 5, n1 = 3;
        System.out.println(solution.findMaxForm(strs1, m1, n1)); // Expected: 4

        String[] strs2 = {"10", "0", "1"};
        int m2 = 1, n2 = 1;
        System.out.println(solution.findMaxForm(strs2, m2, n2)); // Expected: 2

        String[] strs3 = {"10", "11", "00", "01"};
        int m3 = 2, n3 = 2;
        System.out.println(solution.findMaxForm(strs3, m3, n3)); // Expected: 2
    }

}
