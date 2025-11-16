public class CountDistinctIntegersAfterRemovingZeros {
    public long countDistinct(long n) {
        String s=n+"";
        int tens=0;
        long answer=0;
        while (n>0){
            tens++;
            long rem=n%10;
            n=n/10;

            if (rem != 0) {// only worth it if remainder has a zero

                long temp=1;
                for (int i = 0; i < tens-1; i++) {
                    temp*=9;
                }
                temp=(rem-1)*temp;
                if(tens==1)
                    temp=rem;
                if(!constainsZeroBeforeI(s,tens))// Tens also acts as a position
                    // from the end which is directly pass to check if
                    // there is a leading zero relative to the digit 7
                 answer+=temp;
            }
        }
        long min10=get10s(tens);// 10,100 ,1000 will have to have a some numbers that are valid to be added here
        answer+=min10;
        return answer;
    }
    public boolean constainsZeroBeforeI(String s,int pos){
        char[] cs= s.toCharArray();
        for(int i=cs.length-1-pos;i>=0;i--){
            if(cs[i]=='0') return true;
        }
        return false;
    }
    // function that calculates 10 raised to the power k have how many valid numbers
    public long get10s(int places){
        long ans=0;
        for (int i = 0; i <places-1; i++) {
            long temp=1;
            for (int j = i; j <places-1; j++) {
                temp*=9;
            }
            ans+=temp;
        }
        return ans;

    }



    public static void main(String[] args) {
        CountDistinctIntegersAfterRemovingZeros soln= new CountDistinctIntegersAfterRemovingZeros();
        System.out.println(soln.countDistinct(2307));
    }
}
