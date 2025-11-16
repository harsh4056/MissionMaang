public class NumberOfSubstringsWithOnly1sAttempted {


    public int numSub(String s) {
        int div=1000_000_007;
        char[]cs=s.toCharArray();
        long count=0;
        int ones=0;
        for(char c:cs){
            if(c=='1'){
                ones++;
            }
            else{
                count+=(((long) ones *(ones+1))/2)%div;
                ones=0;
            }
        }
        count+=(((long) ones *(ones+1))/2)%div;
        return (int)count;
    }
}
