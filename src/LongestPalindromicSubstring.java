public class LongestPalindromicSubstring {



    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0) return "";

        boolean[][] dp = new boolean[n][n];
        int start = 0, maxLength = 1;

        // Step 1: Single chars
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        // Step 2: Two char substrings
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        // Step 3: Longer substrings
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLength) {
                        start = i;
                        maxLength = len;
                    }
                }
            }
        }

        return s.substring(start, start + maxLength);
    }


    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring= new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }


}
