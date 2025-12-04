import java.util.*;

class AllOne {
    HashSet<String>[] freq;
    int max=Integer.MIN_VALUE;
    int min=Integer.MIN_VALUE;
    HashMap<String,Integer> keyCountMap;

    public AllOne() {
        max=1;
        min=1;
        keyCountMap= new HashMap<>();
        freq= new HashSet[50001];
        for (int i = 0; i < 50001; i++) {
            freq[i]= new HashSet<>();
        }
    }

    public void inc(String key) {
        int oldCount=keyCountMap.getOrDefault(key,0);
        if(oldCount>0){
            freq[oldCount].remove(key);
        }
        freq[oldCount+1].add(key);
        keyCountMap.put(key,keyCountMap.getOrDefault(key,0)+1);
        max=Math.max(max,oldCount+1);
        min=Math.min(min,oldCount+1);
        if(oldCount==min && freq[min].isEmpty()){
            min=min+1;
        }

    }

    public void dec(String key) {
        int oldCount=keyCountMap.getOrDefault(key,0);

        if(oldCount==1){
            keyCountMap.remove(key);

        }
        else{
            min=Math.min(min,oldCount-1);
            keyCountMap.put(key,keyCountMap.getOrDefault(key,0)-1);
        }
        freq[oldCount].remove(key);
        if(oldCount-1>0)
         freq[oldCount-1].add(key);

        for (int i = 0; i < freq.length; i++) {
            if(!freq[i].isEmpty()) {
                min=i;
                break;
            }
        }
        if(oldCount==max && freq[max].isEmpty()){
            max=oldCount-1;
        }

    }

    public String getMaxKey() {
        for(String ans:freq[max]){
            return ans;
        }
        return "";
    }

    public String getMinKey() {
        for(String ans:freq[min]){
            return ans;
        }
        return "";
    }

    public static void main(String[] args) {
        AllOne all = new AllOne();

        all.inc("a");
        all.inc("b");
        all.inc("b");
        all.inc("c");
        all.inc("c");
        all.inc("c");

        all.dec("b");
        all.dec("b");

        System.out.println(all.getMinKey()); // expected "a"

        all.dec("a");

        System.out.println(all.getMaxKey()); // expected "c"
        System.out.println(all.getMinKey()); // expected "c"
    }



}
