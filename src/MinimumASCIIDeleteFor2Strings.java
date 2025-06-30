import java.util.Arrays;

public class MinimumASCIIDeleteFor2Strings {
    public int minimumDeleteSum(String s1, String s2) {

        int[][]memo= new int[s1.length()][s2.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        dfs(memo,0,0,s1,s2);
        return memo[0][0];
    }

    int dfs( int [][]memo,int i, int j, String s1, String s2) {
        if (i == s1.length())  {
            int counter=0;
            for (int k = j; k < s2.length(); k++) {
                counter+=s2.charAt(k);
            }
            return counter;
        }
        if (j == s2.length()) {
            int counter=0;
            for (int k =  i; k < s1.length(); k++) {
                counter+=s1.charAt(k);
            }
           return counter;
        }
        if (memo [i][j]!=-1)return memo[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            memo[i][j]= dfs(memo,i + 1, j + 1, s1, s2);
        } else {

            int deleteS1 = s1.charAt(i) + dfs(memo,i + 1, j, s1, s2);
            int deleteS2 = s2.charAt(j)  + dfs(memo,i , j + 1, s1, s2);
            memo[i][j]=   Math.min(deleteS1, deleteS2);
        }
        return  memo[i][j];
    }
    public static void main(String[] args) {
        MinimumASCIIDeleteFor2Strings solution = new MinimumASCIIDeleteFor2Strings();

        System.out.println(solution.minimumDeleteSum("sea", "eat")); // Expected: 231
        System.out.println(solution.minimumDeleteSum("delete", "leet")); // Expected: 403
        System.out.println(solution.minimumDeleteSum("abc", "abc")); // Expected: 0
    }


}
