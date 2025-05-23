public class InterleavingStrings {

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;

        for (int i = 1; i <= s1.length(); i++) {
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        }

        for (int j = 1; j <= s2.length(); j++) {
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        }

        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                int k = i + j - 1;
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(k)) ||
                        (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(k));
            }
        }

        return dp[s1.length()][s2.length()];
    }

    public boolean isInterleave2(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        boolean[][] visited = new boolean[s1.length() + 1][s2.length() + 1];
        traverse(s1, s2, s3, 0, 0, 0, visited);
        return visited[s1.length()][s2.length()];
    }

    public void traverse(String s1, String s2, String s3, int p1, int p2, int p3,  boolean[][] visited) {
        if (visited[p1][p2]) return;
        visited[p1][p2] = true;

        if (p3 == s3.length()) {
            
            return;
        }

        if (p1 < s1.length() && s1.charAt(p1) == s3.charAt(p3)) {
            traverse(s1, s2, s3, p1 + 1, p2, p3 + 1,  visited);
        }
        if (p2 < s2.length() && s2.charAt(p2) == s3.charAt(p3)) {
            traverse(s1, s2, s3, p1, p2 + 1, p3 + 1,  visited);
        }
    }







    public static void main(String[] args) {
        InterleavingStrings obj = new InterleavingStrings();


        System.out.println(obj.isInterleave("aab", "axy", "aaxaby")); // true
        System.out.println(obj.isInterleave("aab", "axy", "abaaxy")); // false
        System.out.println(obj.isInterleave("abc", "def", "adbcef")); // true
        System.out.println(obj.isInterleave("", "", ""));             // true
        System.out.println(obj.isInterleave("abc", "", "abc"));       // true
    }
}
