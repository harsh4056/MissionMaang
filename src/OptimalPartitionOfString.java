import java.util.*;

public class OptimalPartitionOfString {
    public int partitionString(String s) {

        char []cs=s.toCharArray();
        boolean[] freq=new boolean[26];
        int subsetCount=0;
        for(char c:cs){
            if(!freq[c-'a']){
                freq[c-'a']=true;
            }
            else{
                subsetCount++;
                Arrays.fill(freq,false);
                freq[c-'a']=true;
            }
        }
        return subsetCount;
    }

    public static void main(String[] args) {
        OptimalPartitionOfString optimalPartitionOfString= new OptimalPartitionOfString();
        System.out.println(optimalPartitionOfString.partitionString("abacaba"));
    }
}
