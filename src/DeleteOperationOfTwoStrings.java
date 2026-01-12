import java.util.Arrays;

public class DeleteOperationOfTwoStrings {

    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int [][]dp = new int[m+1][n+1];

        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        char[]w1Arr= word1.toCharArray();
        char[]w2Arr= word2.toCharArray();
        int common=solve(w1Arr,w2Arr,0,0,dp);

        return m+n-2*common;

    }

    public int solve(char[]s1, char[]s2, int i1, int i2, int[][] dp){
        if(i1==s1.length || i2==s2.length) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        int take=0;
        if(s1[i1]==s2[i2]){
            take=1+solve(s1,s2,i1+1,i2+1, dp);
        }
        int skip1=solve(s1,s2,i1+1,i2, dp);
        int skip2=solve(s1,s2,i1,i2+1, dp);

        return dp[i1][i2]=Math.max(take,Math.max(skip1,skip2));

    }
    public static void main(String[] args) {
        DeleteOperationOfTwoStrings solution = new DeleteOperationOfTwoStrings();

        System.out.println(solution.minDistance("sea", "eat")); // Expected: 2
        System.out.println(solution.minDistance("leetcode", "etco")); // Expected: 4
        System.out.println(solution.minDistance("abc", "def")); // Expected: 6
    }

}
