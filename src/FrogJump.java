import java.util.*;

//Hard Problem
public class FrogJump {

    public boolean canCross(int[] stones) {
        HashMap<Integer,Integer> stoneIndex= new HashMap<>();
        for (int i = 0; i < stones.length; i++) {
            int stone = stones[i];
            stoneIndex.put(stone,i);
        }
        HashMap<Integer,HashMap<Integer,Boolean>> memo= new HashMap<>();
        return solve(1,0,stones,stoneIndex,memo);

    }
    public boolean solve(int prevJump,int index,int []stones,HashMap<Integer,Integer> stoneIndex,HashMap<Integer,HashMap<Integer,Boolean>> memo){
        if(index== stones.length-1) return true;

        int currStone=stones[index];
        boolean canJump=false;
        if(index==0){
            int jumpedTo = currStone + 1;
            if (jumpedTo > currStone && stoneIndex.containsKey(jumpedTo)) {
                canJump = solve(1, stoneIndex.get(jumpedTo), stones, stoneIndex,memo);
            }
        }
        else {
            for (int i = prevJump - 1; i <= prevJump + 1; i++) {
                int jumpedTo = currStone + i;

                if (jumpedTo > currStone && stoneIndex.containsKey(jumpedTo)) {

                    canJump = canJump || solve(i, stoneIndex.get(jumpedTo), stones, stoneIndex,memo);
                }
            }
        }
        return canJump;
    }
    public boolean canCross2(int[] stones) {
        HashMap<Integer, List<Integer>> hashMap= new HashMap<>();
        hashMap.putIfAbsent(stones[0]+1,new ArrayList<>());
        hashMap.get(stones[0]+1).add(1);
        for (int i = 1; i < stones.length; i++) {
            int stone = stones[i];
            List<Integer> jumps=hashMap.get(stone);
            if(jumps!=null) {
                for (int jump : jumps) {
                    for (int j = jump - 1; j <= jump + 1; j++) {
                        int jumpTo = stone + j;
                        if (jumpTo>stone && exists(stones, jumpTo)) {
                            hashMap.putIfAbsent(jumpTo, new ArrayList<>());
                            hashMap.get(jumpTo).add(j);
                        }
                    }
                }
            }

        }

        return hashMap.get(stones[stones.length-1])!=null;


    }
    public boolean exists(int[] stones, int num) {

        int l = 0;
        int r = stones.length - 1;

        while (l <= r) {                // <= is required
            int mid = l + (r - l) / 2;

            if (stones[mid] == num) {
                return true;
            } else if (stones[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
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
        int[] stones4 = {0,1,3,5,6,8,12,17};
        System.out.println(frogJump.canCross2(stones4)); // Expected: true
        int[] stones1 = {0,2};
        System.out.println(frogJump.canCross2(stones1)); // Expected: false
        int[] stones2 = {0,1,3,6,7};
        System.out.println(frogJump.canCross(stones2)); // Expected: false
    }


}
