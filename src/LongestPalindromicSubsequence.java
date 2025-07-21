import java.util.Arrays;

public class LongestPalindromicSubsequence {


    public int longestPalindromeSubseq(String s) {

        int n=s.length();
        int [][]dp = new int[n+1][n+1];

        char[] arr=s.toCharArray();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
               if(arr[n-j]==arr[i-1]){
                   dp[i][j]=1+dp[i-1][j-1];
               }
               else{
                   dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
               }

            }
        }
        return dp[n][n];

    }
    public static void main(String[] args) {
        LongestPalindromicSubsequence solution = new LongestPalindromicSubsequence();

        System.out.println(solution.longestPalindromeSubseq("bbbab")); // Expected: 4 ("bbbb")
        System.out.println(solution.longestPalindromeSubseq("cbbd"));  // Expected: 2 ("bb")
        System.out.println(solution.longestPalindromeSubseq("abdba")); // Expected: 5 ("abdba")
    }

}
