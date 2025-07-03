import java.util.HashSet;

public class FrogJump {

    public boolean canCross(int[] stones) {

        HashSet<Integer> stonesSet= new HashSet<>();
        for (Integer integer : stones) {
            stonesSet.add(integer);
        }

        int[][]memo= new int[stones.length][stones.length];
        for (int i = 0; i < memo.length; i++) {

            for (int j = 0; j < memo[0].length; j++) {

                
            }
        }

        return solveCross(stonesSet, 0,0,stones[stones.length-1]);
        //return true;
    }

    public boolean solveCross(HashSet<Integer> set, int value,int jump, int lastValue){
        if (value == lastValue) {
            return true;
        }
            if(set.contains(value)) {
                set.remove(value);
                for (int i = jump - 1; i <= jump + 1; i++) {
                    if (solveCross(set, value+i,i, lastValue))
                        return true;
                }
                set.add(value);
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
