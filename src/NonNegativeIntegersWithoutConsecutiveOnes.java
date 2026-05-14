public class NonNegativeIntegersWithoutConsecutiveOnes {


    public int findIntegers(int n) {
        String bin= Integer.toBinaryString(n);
        char[]cn= bin.toCharArray();
        Integer[][][][]dp= new Integer[cn.length][2][3][2];
        int ans=solve(0,true,-1,false,cn,dp);
        return ans;
    }

    public int solve(int i, boolean tight, int prev, boolean started, char[]cn, Integer[][][][] dp){

        if(i==cn.length){
            return 1;
        }
        if(dp[i][tight?1:0][prev+1][started?1:0]!=null) return dp[i][tight?1:0][prev+1][started?1:0];
        int limit =tight?cn[i]-'0':1;
        int count=0;
        for (int d = 0; d <=limit; d++) {
            boolean newTight= tight && (d==limit);

            if(!started && d==0){
                count+=solve(i+1,newTight,d,false,cn, dp);
            }
            else{
                if(prev!=d)
                 count+=solve(i+1,newTight,d,false,cn, dp);
            }
        }
        return dp[i][tight?1:0][prev+1][started?1:0]=count;
    }

    public static void main(String[] args) {
        NonNegativeIntegersWithoutConsecutiveOnes soln= new NonNegativeIntegersWithoutConsecutiveOnes();
        System.out.println(soln.findIntegers(7));
    }
}
