import java.util.Arrays;

public class DecodeWays {

    int ans;
    public int numDecodings(String s) {
        ans=0;
        getWays(s.toCharArray(),0);
        return ans;

    }

    public int getWays(char[]cs,int index){
        if(index==cs.length){
            return 1;
        }
        for(int i=index;i<cs.length;i++){
            String digit= new String(cs,index,i-index+1);
            int num=Integer.parseInt(digit);
            if(num>=1 && num<=26){
                int temp=   getWays(cs,i+1);
                ans+=temp;
            }
            else{
                return 0;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        DecodeWays decodeWays= new DecodeWays();
        System.out.println(decodeWays.numDecodings("226"));
    }
}
