import java.util.Arrays;

public class DecodeWays {

    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return decode(s.toCharArray(),0,dp);
    }
    public int decode(char[]s, int index, int[] dp){
        if(index>=s.length) return 1;
        if(dp[index]!=-1) return dp[index];
        int total=0;
        for(int i=index;i<s.length;i++){
            String temp=new String(s,index,i-index+1);

            int value=Integer.parseInt(temp);
            if(value>0 &&value<27){
                total+= decode(s,i+1, dp);
            }
            else {
                total+=0;
            }
        }
        dp[index]=total;
        return total;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays= new DecodeWays();
        System.out.println(decodeWays.numDecodings("2101"));
    }
}
