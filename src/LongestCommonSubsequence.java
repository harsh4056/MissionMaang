import java.lang.foreign.StructLayout;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class LongestCommonSubsequence {


    public int longestCommonSubsequence(String text1, String text2) {
      int [][]memo= new int[text1.length()][text2.length()];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
       return lcs(text1,text2,0,0,memo);
    }


    int lcs(String text1, String text2, int i, int j, int[][] memo){
        if (i >= text1.length() || j >= text2.length()) return 0;

        if (memo[i][j] != -1) return memo[i][j];

        if (text1.charAt(i) == text2.charAt(j)) {
            memo[i][j] = 1 + lcs(text1, text2, i + 1, j + 1, memo);
        } else {
            memo[i][j] = Math.max(
                    lcs(text1, text2, i + 1, j, memo),
                    lcs(text1, text2, i, j + 1, memo)
            );
        }

        return memo[i][j];

    }
    public int longestCommonSubsequence2(String text1, String text2) {

        int n=text1.length();
        int m=text2.length();
        int [][]memo= new int[n][m];
        if(text1.charAt(0)==text2.charAt(0)){
            memo[0][0]=1;
        }
        for (int i = 1; i < n; i++) {
            memo[i][0]=text1.charAt(i)==text2.charAt(0) ? 1 : memo[i - 1][0];

        }
        for (int j = 1; j < m; j++) {
            memo[0][j]=text1.charAt(0)==text2.charAt(j) ? 1 : memo[0][j-1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
               if(text1.charAt(i)==text2.charAt(j)){
                   memo[i][j]=1+memo[i-1][j-1];
               }
               else{
                   memo[i][j]=Math.max(memo[i][j-1],memo[i-1][j]);
               }
            }
        }
        return memo[n-1][m-1];
        

    }


    public static void main(String[] args) {


        LongestCommonSubsequence sol = new LongestCommonSubsequence();


        System.out.println(sol.longestCommonSubsequence("bbbab","babbb"));




    }

    private static String rand(int len) {
        ThreadLocalRandom r = ThreadLocalRandom.current();
        char[] buf = new char[len];
        for (int i = 0; i < len; i++) buf[i] = (char)('a' + r.nextInt(26));
        return new String(buf);
    }

}
