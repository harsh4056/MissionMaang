import java.util.Arrays;

public class ShortestCommonSubsequence {

    public String shortestCommonSupersequence(String str1, String str2) {
        char[]string1=str1.toCharArray();
        char[]string2=str2.toCharArray();
        int[][] memo= new int[string1.length][string2.length];
        int str1LI=-1;
        int str2LJ=-1;
        int max=Integer.MIN_VALUE;
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < memo[0].length; j++) {

                if(string1[i]==string2[j]){
                    memo[i][j]=1+ ((i-1<0 || j-1<0)?0:memo[i-1][j-1]);
                    if(max<=memo[i][j]){
                        str1LI=i;
                        str2LJ=j;
                        max=memo[i][j];
                    }
                }
                else{
                    memo[i][j]=0;
                }
            }

        }
        if(max==Integer.MIN_VALUE)
            return str1+str2;

        String common= String.valueOf(string2,str2LJ+1-max,max);

        String s1a=String.valueOf(string1,0,str1LI+1-max);
        String s2a=String.valueOf(string2,0,str2LJ+1-max);

        String s1b=String.valueOf(string1,str1LI+1,string1.length-(str1LI+1));
        String s2b=String.valueOf(string2,str2LJ+1,string2.length-(str2LJ+1));


        StringBuilder answer= new StringBuilder();
        answer.append(s1a).append(s2a).append(common).append(s1b).append(s2b);


        return answer.toString();
    }



    public static void main(String[] args) {
        ShortestCommonSubsequence solution = new ShortestCommonSubsequence();

        // Test Case 1
        String result1 = solution.shortestCommonSupersequence("bbbaaaba", "bbababbb");
        System.out.println("Result 1: " + result1); // Expected output: "aaaaaaaaaa" or similar shortest common supersequence
        // Test Case 2
        String result2 = solution.shortestCommonSupersequence("geek", "eke");
        System.out.println("Result 2: " + result2); // Expected output: "geeke" or similar

        // Test Case 3
        String result3 = solution.shortestCommonSupersequence("abc", "def");
        System.out.println("Result 3: " + result3); // Expected output: "abcdef" or any merge since no common subsequence

    }

}
