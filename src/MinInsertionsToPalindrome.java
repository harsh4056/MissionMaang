import java.util.Arrays;

public class MinInsertionsToPalindrome {
    public int minInsertions(String s) {
        String reverse= new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[][]memo= new int[n][n];
        for (int[] ints : memo) {
            Arrays.fill(ints,-1);
        }
        int lcs=lcs(s,reverse,0,0,memo);
        return n-lcs;

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
}
