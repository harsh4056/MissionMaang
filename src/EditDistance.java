import java.util.Arrays;

public class EditDistance {

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()+1][word2.length()+1];

        for (int i = 0; i < word1.length(); i++) {
            dp[i][0]=i;
        }

        for (int j = 0; j < word2.length(); j++) {
            dp[0][j]=j;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];  // no op
                } else {
                    dp[i][j] = 1 + Math.min(
                            dp[i - 1][j],     // delete
                            Math.min(
                                    dp[i][j - 1], // insert
                                    dp[i - 1][j - 1] // replace
                            )
                    );
                }


            }
        }

        return dp[word1.length()][word2.length()];



    }
    public static void main(String[] args) {
        EditDistance ed = new EditDistance();

        System.out.println(ed.minDistance2("horse", "ros"));    // Expected: 3
        System.out.println(ed.minDistance2("intention", "execution")); // Expected: 5
        System.out.println(ed.minDistance2("abc", "yabd"));     // Expected: 2
    }


    public int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] memo = new int[m][n];

        for (int[] row : memo) Arrays.fill(row, -1);
        int ans=dp(0, 0, word1, word2, memo);
        return ans;
    }

    private int dp(int i, int j, String w1, String w2, int[][] memo) {
        if (i == w1.length()) return w2.length() - j;  // insert all remaining of w2
        if (j == w2.length()) return w1.length() - i;  // delete all remaining of w1

        if (memo[i][j] != -1) return memo[i][j];

        if (w1.charAt(i) == w2.charAt(j)) {
            memo[i][j] = dp(i + 1, j + 1, w1, w2, memo);  // no operation
        } else {
            int insert = 1 + dp(i, j + 1, w1, w2, memo);     // insert w2[j]
            int delete = 1 + dp(i + 1, j, w1, w2, memo);     // delete w1[i]
            int replace = 1 + dp(i + 1, j + 1, w1, w2, memo); // replace w1[i] with w2[j]
            memo[i][j] = Math.min(insert, Math.min(delete, replace));
        }

        return memo[i][j];
    }



}
