public class CountOfIntegers {


    int mod= 1_000_000_007;
    public int count(String num1, String num2, int min_sum, int max_sum) {

        Long[][][][] dp= new Long[Math.max(num1.length(),num2.length())][2][2][220];
      long a1=solve(0,true,false,0,min_sum,max_sum,num1.toCharArray(),dp);
        dp= new Long[Math.max(num1.length(),num2.length())][2][2][220];
      long a2=solve(0,true,false,0,min_sum,max_sum,num2.toCharArray(),dp);

        boolean valid = check(num1, min_sum, max_sum);
        return (int)((a2 - a1 + (valid ? 1 : 0) ) % mod);

    }


    public long solve(int i, boolean tight, boolean started, int sum, int min, int max, char[]cn, Long[][][][] dp){
        if(i==cn.length){
            if(sum>=min && sum<=max){
                return 1;
            }
            return 0;
        }

        if(dp[i][tight?1:0][started?1:0][sum]!=null) return dp[i][tight?1:0][started?1:0][sum];
        int limit =tight? cn[i]-'0':9;
        long count=0;
        for (int d = 0; d <=limit; d++) {
            boolean newTight= tight && (d==limit);
            if(!started && d==0){

                count+=solve(i+1,newTight,true,sum+d,min,max,cn, dp)%mod;
            }
            else{
                if(sum+d<=max){
                    count+=solve(i+1,newTight,true,sum+d,min,max,cn, dp)%mod;
                }
            }

        }
        return dp[i][tight?1:0][started?1:0][sum]=count;

    }

    boolean check(String s, int min, int max){
        int sum = 0;
        for(char c : s.toCharArray()){
            sum += c - '0';
        }
        return sum >= min && sum <= max;
    }

    public static void main(String[] args) {
        CountOfIntegers soln= new CountOfIntegers();
        System.out.println(soln.count("1","12",1,8));
        System.out.println(soln.count("1","5",1,5));
    }
}
