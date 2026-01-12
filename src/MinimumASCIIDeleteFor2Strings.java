import java.util.Arrays;

public class MinimumASCIIDeleteFor2Strings {
    public int minimumDeleteSum(String s1, String s2) {

        int m=s1.length();
        int n=s2.length();
        int [][]dp = new int[m+1][n+1];

        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        char[]w1Arr= s1.toCharArray();
        char[]w2Arr= s2.toCharArray();
        int sum=0;
        for(char c:w1Arr){
            sum+=c;
        }
        for(char c:w2Arr){
            sum+=c;
        }
        int common=solve(w1Arr,w2Arr,0,0,dp);

        return sum-common;
    }



    public int solve(char[]s1, char[]s2, int i1, int i2, int[][] dp){
        if(i1==s1.length || i2==s2.length) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        int take=0;
        if(s1[i1]==s2[i2]){
            take=s1[i1]+s2[i2]+solve(s1,s2,i1+1,i2+1, dp);
        }
        int skip1=solve(s1,s2,i1+1,i2, dp);
        int skip2=solve(s1,s2,i1,i2+1, dp);

        return dp[i1][i2]=Math.max(take,Math.max(skip1,skip2));

    }



    public int minimumDeleteSum2(String s1, String s2) {

        int m=s1.length();
        int n=s2.length();
        int [][]dp = new int[m+1][n+1];


        char[]w1Arr= s1.toCharArray();
        char[]w2Arr= s2.toCharArray();
        int sum=0;
        for(char c:w1Arr){
            sum+=c;
        }
        for(char c:w2Arr){
            sum+=c;
        }
        for(int i1=m-1;i1>=0;i1--){
            for(int i2=n-1;i2>=0;i2--){
                int take=0;
                if(w1Arr[i1]==w2Arr[i2]){
                    take=w1Arr[i1]+w2Arr[i2]+dp[i1+1][i2+1];
                }
                int skip1=dp[i1+1][i2];
                int skip2=dp[i1][i2+1];
                dp[i1][i2]=Math.max(take,Math.max(skip1,skip2));
            }
        }

        int common=dp[0][0];

        return sum-common;
    }

    public static void main(String[] args) {
        MinimumASCIIDeleteFor2Strings solution = new MinimumASCIIDeleteFor2Strings();

        System.out.println(solution.minimumDeleteSum2("sea", "eat")); // Expected: 231
        System.out.println(solution.minimumDeleteSum2("delete", "leet")); // Expected: 403
        System.out.println(solution.minimumDeleteSum2("abc", "abc")); // Expected: 0
    }


}
