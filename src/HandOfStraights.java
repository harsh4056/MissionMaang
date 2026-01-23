import java.util.*;
import java.util.HashMap;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int h:hand){
            map.putIfAbsent(h,0);
            map.put(h,map.get(h)+1);
        }

        while(!map.isEmpty()){
            int size=groupSize;
            int start=map.firstKey()-1;
            while(size>0){
                Integer first= map.higherKey(start);
                if(first==null) return false;
                if(start+1==first) {
                    int count= map.get(first);
                    count--;
                    if(count==0){
                        map.remove(first);

                    }
                    else{
                        map.put(first,count);
                    }
                    start=first;

                }
                else{
                    return false;
                }
                size--;
            }

        }
        return true;
    }
    public static void main(String[] args) {
        HandOfStraights obj = new HandOfStraights();

        int[] hand1 = {1,2,4,2,3,5,3,4};
        int groupSize1 = 4;
        System.out.println(obj.isNStraightHand(hand1, groupSize1)); // Expected: true

        int[] hand2 = {1,2,3,4,5,6,7,8,9};
        int groupSize2 = 4;
        System.out.println(obj.isNStraightHand(hand2, groupSize2)); // Expected: false

        int[] hand3 = {1,2,3,4,5,6};
        int groupSize3 = 2;
        System.out.println(obj.isNStraightHand(hand3, groupSize3)); // Expected: true
    }

}
