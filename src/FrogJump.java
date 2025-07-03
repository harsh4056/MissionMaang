public class FrogJump {

    public boolean canCross(int[] stones) {

        boolean[] stonesVisited= new boolean[stones.length];
        solveCross(stones,stonesVisited,1,0);
        return stonesVisited[stones.length-1];
    }

    public void solveCross(int[]stones,boolean[]stonesVisited,int index,int jump){
        if(index>=stones.length){
            return;
        }


            for (int i = jump-1; i<=jump+1 ; i++) {
                int currentStone=0;
                for(int j=index;j<stones.length;j++) {
                    currentStone = stones[j];
                    int possibleJump = (i + stones[index - 1]);
                    if (currentStone == possibleJump) {
                        stonesVisited[index] = true;
                        solveCross(stones, stonesVisited, index + 1, i);
                    }
                    if(possibleJump<stones[j]){
                        break;
                    }
                }
            }

    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();

        int[] stones1 = {0,1,3,5,6,8,12,17};
        System.out.println(frogJump.canCross(stones1)); // Expected: true

        int[] stones2 = {0,1,3,6,7};
        System.out.println(frogJump.canCross(stones2)); // Expected: false

        int[] stones3 = {0,1,2,3,4,5,6,7,8,9,10};
        System.out.println(frogJump.canCross(stones3)); // Expected: true
    }


}
