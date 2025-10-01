import java.util.*;

public class StringWithRepeatLimit {


    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<CharFreq> maxHeap= new PriorityQueue<>((a, b)-> b.c-a.c);
        CharFreq[] freq=new CharFreq[26];
        char[]cs=s.toCharArray();
        for(char c:cs){
            if(freq[c-'a']==null){
                freq[c-'a']=new CharFreq(c,1);
            }else{
                freq[c-'a'].freq++;
            }
        }
        for(CharFreq cf:freq){
            if(cf!=null)
             maxHeap.offer(cf);
        }
        StringBuilder sb= new StringBuilder();
        if(!maxHeap.isEmpty()) {
            CharFreq cfTop = maxHeap.poll();
            while (cfTop!=null) {
                int limit = Math.min(repeatLimit,cfTop.freq);
                if (!maxHeap.isEmpty()&&maxHeap.peek().c > cfTop.c) {
                    limit = 1;
                }
                while (limit > 0) {
                    sb.append(cfTop.c);
                    cfTop.freq--;
                    limit--;
                }
                CharFreq temp = maxHeap.isEmpty()?null:maxHeap.poll();
                if (cfTop.freq > 0) maxHeap.offer(cfTop);
                cfTop = temp;

            }
        }
        return sb.toString();

    }

    class CharFreq{
        char c;
        int freq;
        CharFreq(char c,int freq){
            this.c=c;
            this.freq=freq;
        }
    }

    public static void main(String[] args) {


        /*StringWithRepeatLimit soln=new StringWithRepeatLimit();
        System.out.println(soln.repeatLimitedString("aababab",2));
        System.out.println(soln.repeatLimitedString("cczazcc",3));*/
    }
}
