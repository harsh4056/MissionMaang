public class NumberOfDigitOne {

    public int countDigitOne(int n) {
        char[]cs= String.valueOf(n).toCharArray();
        Integer[][][] dp= new Integer[cs.length][2][20];
        int ans=solve(0,true,0,cs,dp);
        return ans;
    }

    public int solve(int i, boolean tight, int cnt, char[]cn, Integer[][][] dp){
        if(i==cn.length){
            return cnt;
        }
        int limit= tight?cn[i]-'0':9;
        if(dp[i][tight?1:0][cnt]!=null) return dp[i][tight?1:0][cnt];
        int count=0;
        for (int d = 0; d <=limit; d++) {
            boolean newTight= tight && (d==limit);
            int updateCnt= d==1?cnt+1:cnt;
            count += solve(i + 1, newTight, updateCnt, cn, dp);

        }
        return dp[i][tight?1:0][cnt]=count;
    }

    public static void main(String[] args) {
        NumberOfDigitOne soln= new NumberOfDigitOne();
        System.out.println(soln.countDigitOne(13));
    }
}
