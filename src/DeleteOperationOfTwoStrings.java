public class DeleteOperationOfTwoStrings {

    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int [][]dp = new int[m+1][n+1];


        char[]w1Arr= word1.toCharArray();
        char[]w2Arr= word2.toCharArray();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if(w2Arr[j-1]==w1Arr[i-1]){

                    dp[i][j]=1+dp[i-1][j-1];

                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }

            }
        }
       return m+n- (2*dp[m][n]);

    }
    public static void main(String[] args) {
        DeleteOperationOfTwoStrings solution = new DeleteOperationOfTwoStrings();

        System.out.println(solution.minDistance("sea", "eat")); // Expected: 2
        System.out.println(solution.minDistance("leetcode", "etco")); // Expected: 4
        System.out.println(solution.minDistance("abc", "def")); // Expected: 6
    }

}
