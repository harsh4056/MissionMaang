public class DistinctSubsequences {

    public int numDistinct(String s, String t) {
        char[]cs=s.toCharArray();
        char[]ct=t.toCharArray();
        //int ans= solve(cs,ct,0,0);

        int n = cs.length;
        int m = ct.length;

        int[][] dp = new int[n + 1][m + 1];


        for (int i = 0; i <= n; i++) {
            dp[i][m] = 1;
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {

                int take = 0;
                if (cs[i] == ct[j]) {
                    take = dp[i + 1][j + 1];
                }

                int skip = dp[i + 1][j];

                dp[i][j] = take + skip;
            }
        }

        return dp[0][0];
    }
    public int solve(char[]cs,char[]ct,int is,int it){
        if(it==ct.length){
            return 1;
        }
        int take=0;
        if(is<cs.length && cs[is]==ct[it]){
            take= solve(cs,ct,is+1,it+1);
        }

        int skip=0;
        if(is<cs.length){
            skip=solve(cs,ct,is+1,it);
        }

        return take+skip;
    }


    public static void main(String[] args) {
        DistinctSubsequences soln= new DistinctSubsequences();
        System.out.println(soln.numDistinct("caaat","cat"));
        System.out.println(soln.numDistinct("xxyxy","xy"));
    }
}
