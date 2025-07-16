import java.util.Arrays;

public class IntegerBreak {

    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }


        int[]dp= new int[n+1];
        Arrays.fill(dp,-1);
        return maxInteger(n,dp,true);

    }
    public int maxInteger(int N,int[]dp,boolean finding){

        int max=N;
        if(dp[N]!=-1) {
            if(finding){
                return dp[N];
            }
            else{
                return Math.max(dp[N],N);
            }
        }
        for(int i=1;i<N;i++){
           max=Math.max(max, i *maxInteger(N-i,dp,false));
        }
        dp[N]= max;
        return max;

    }

    public static void main(String[] args) {
        IntegerBreak aBreak= new IntegerBreak();
        System.out.println(aBreak.integerBreak(4));
    }
}
