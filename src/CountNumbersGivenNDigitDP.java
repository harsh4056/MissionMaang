public class CountNumbersGivenNDigitDP {

    public long getCount(long n){
        char[] digits= String.valueOf(n).toCharArray();
        Long[][]dp= new Long[20][2];
        long ans1=solve(0,true,digits,dp);
        //long ans2=solveWithoutDP(0,true,digits);
        return ans1;
    }
    //425
    public long solve(int i, boolean tight, char[] n, Long[][] dp){
        if(i==n.length) return 1;
        if( dp[i][tight?1:0]!=null) return  dp[i][tight?1:0];

        int limit= tight?n[i]-'0':9;
        long count=0;
        for(int d=0;d<=limit;d++){
            boolean newTight= tight && (d==limit);

            count+=solve(i+1,newTight,n, dp);
        }
        dp[i][tight?1:0]=count;

        return count;

    }

    public long solveWithoutDP(int i, boolean tight, char[] n){
        if(i==n.length) return 1;


        int limit= tight?n[i]-'0':9;
        long count=0;
        for(int d=0;d<=limit;d++){
            boolean newTight= tight && (d==limit);

            count+=solveWithoutDP(i+1,newTight,n);
        }


        return count;

    }

    public long range(long left,long right){
        long ans=getCount(right)- getCount(left);
        return ans;
    }

    public static void main(String[] args) {
        CountNumbersGivenNDigitDP soln= new CountNumbersGivenNDigitDP();
        System.out.println(soln.getCount(1));
        System.out.println(soln.getCount(9223372036854775806L));
        System.out.println(soln.range(123,425));
    }
}
