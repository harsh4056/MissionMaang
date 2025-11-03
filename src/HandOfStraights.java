import java.util.Arrays;
import java.util.HashMap;

public class HandOfStraights {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n=hand.length;
        if(n%groupSize!=0) return false;
        Arrays.sort(hand);
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int num:hand){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        int i=0;
        while(i<n){
            int curr=hand[i];
            for (int j = curr; j < curr + groupSize; j++) {
                if(map.getOrDefault(j,0)>0){
                    map.put(j,map.getOrDefault(j,0)-1);
                    if(map.getOrDefault(j,0)==0){
                        while(i<n&& hand[i]==j){
                            i++;
                        }
                    }
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        HandOfStraights obj = new HandOfStraights();

        int[] hand1 = {1,2,3,6,2,3,4,7,8};
        int groupSize1 = 3;
        System.out.println(obj.isNStraightHand(hand1, groupSize1)); // Expected: true

        int[] hand2 = {1,2,3,4,5};
        int groupSize2 = 4;
        System.out.println(obj.isNStraightHand(hand2, groupSize2)); // Expected: false

        int[] hand3 = {1,2,3,4,5,6};
        int groupSize3 = 2;
        System.out.println(obj.isNStraightHand(hand3, groupSize3)); // Expected: true
    }

}
