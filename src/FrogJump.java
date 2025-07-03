import java.util.HashMap;
import java.util.HashSet;

public class FrogJump {

    public boolean canCross(int[] stones) {

        HashMap<Integer,Integer> stonesMap= new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            stonesMap.put(stones[i],i);

        }
        boolean[][]memo= new boolean[stones.length][stones.length];
        memo[0][0]=true;
        for (int i = 0; i < memo.length; i++) {

            for (int j = 0; j < memo[0].length; j++) {
                if(memo[i][j]){
                    int val1=stones[i]+j-1;
                    int val2=stones[i]+j;
                    int val3=stones[i]+j+1;
                    if(stonesMap.containsKey(val1)){
                        memo[stonesMap.get(val1)][j-1]=true;
                    }
                    if(stonesMap.containsKey(val2)){
                        memo[stonesMap.get(val2)][j]=true;
                    }
                    if(stonesMap.containsKey(val3)){
                        memo[stonesMap.get(val3)][j+1]=true;
                    }
                }
                
            }
        }

        for (int i = 0; i < memo[0].length; i++) {
            if(memo[stones.length-1][i]){
                return true;
            }
        }
        return false;
    }



   /* public boolean solveCross(HashSet<Integer> set, int value, int jump, int lastValue){
        if(value==lastValue){
            return true;
        }

        if(set.contains(value)){
            set.remove(value);
            if(
                    solveCross(set, value+jump-1,jump-1,lastValue)||
                            solveCross(set, value+jump,jump,lastValue)||
                            solveCross(set, value+jump+1,jump+1,lastValue))
                return true;
            set.add(value);
        }
        return false;



    }*/

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();

        int[] stones1 = {0,1,3,5,6,8,12,17};
        System.out.println(frogJump.canCross(stones1)); // Expected: true

        int[] stones2 = {0,1,3,6,7};
        System.out.println(frogJump.canCross(stones2)); // Expected: false
        int[] stones3 = new int[500];
        for(int i=0;i<500;i++){
            stones3[i]=i;
       }
        //stones3[stones3.length-1]=999;

        System.out.println(frogJump.canCross(stones3)); // Expected: true
    }


}
