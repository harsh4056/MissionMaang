import java.util.Arrays;

public class EditDistanceSolver {
    public int editDistance(String s1, String s2) {

        int[][]memo= new int[s1.length()][s2.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        dfs(memo,0,0,s1,s2);
        return memo[0][0];
    }

    int dfs( int [][]memo,int i, int j, String s1, String s2) {
        if (i == s1.length()) return s2.length() - j;
        if (j == s2.length()) return s1.length() - i;
        if (memo [i][j]!=-1)return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j]= dfs(memo,i + 1, j + 1, s1, s2);
        } else {
            int insert = 1 + dfs(memo,i, j + 1, s1, s2);
            int delete = 1 + dfs(memo,i + 1, j, s1, s2);
            int replace = 1 + dfs(memo,i + 1, j + 1, s1, s2);
            memo[i][j]=  Math.min(insert, Math.min(delete, replace));
        }
        return  memo[i][j];
    }

    public static void main(String[] args) {
        System.out.println(new EditDistanceSolver().editDistance("abc","yabd"));
    }
}
