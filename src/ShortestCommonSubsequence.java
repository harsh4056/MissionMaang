import java.util.Arrays;

public class ShortestCommonSubsequence {

    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length();
        int m=str2.length();
        StringBuilder answer= new StringBuilder();
        int [][]memo= new int[n][m];

        for (int i = 1; i < n; i++) {
            memo[i][0]=str1.charAt(i)==str2.charAt(0) ? 1 : memo[i - 1][0];

        }
        for (int j = 1; j < m; j++) {
            memo[0][j]=str1.charAt(0)==str2.charAt(j) ? 1 : memo[0][j-1];

        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(str1.charAt(i)==str2.charAt(j)){
                    memo[i][j]=1+memo[i-1][j-1];
                    if(memo[i][j]>answer.length() ){
                        if(memo[i-1][j-1]==1 && answer.isEmpty())
                         answer.append(str1.charAt(i-1));
                        answer.append(str1.charAt(i));
                    }
                }
                else{
                    memo[i][j]=Math.max(memo[i][j-1],memo[i-1][j]);
                }
            }
        }
        return answer.toString();
    }

/*if(s1b.isEmpty()){
           answer.append(s1a).append(s2a).append(s2b).append(s1b).append(common);
       }
       else if(s2b.isEmpty()){
           answer.append(s1a).append(s2a).append(s1b).append(s2b).append(common);
       }
       else if(s1a.isEmpty()){
           answer.append(common).append(s1a).append(s2a).append(s1b).append(s2b);
       }
       else if(s2a.isEmpty()){
           answer.append(common).append(s2a).append(s1a).append(s1b).append(s2b);
       }
       else{
           answer.append(s2a).append(s1a).append(common).append(s1b).append(s2b);
       }*/

    public static void main(String[] args) {
        ShortestCommonSubsequence solution = new ShortestCommonSubsequence();

        // Test Case 1
        String result1 = solution.shortestCommonSupersequence("bbbaaaba", "bbababbb");
        System.out.println("Result 1: " + result1); // Expected output: "bbaba" or similar shortest common supersequence
        // Test Case 2
        String result2 = solution.shortestCommonSupersequence("geek", "eke");
        System.out.println("Result 2: " + result2); // Expected output: "ek" or similar

        // Test Case 3
        String result3 = solution.shortestCommonSupersequence("abac", "cab");
        System.out.println("Result 3: " + result3); // Expected output: "ab" or any merge since no common subsequence

    }

}
