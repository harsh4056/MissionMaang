import java.util.HashSet;

public class FrogJumpII {

    public int maxJump(int[] stones) {

        HashSet<Integer> set= new HashSet<>();
        findMaxJump(stones,1,false);

        return 0;
    }
    public void findMaxJump(int[]stones, int i,boolean reverse){

        if(i>=stones.length){
            System.out.print(" "+stones[stones.length-1]);

            findMaxJump(stones,stones.length-1,true);
            return;
        }
        if(i==stones.length-1){
            System.out.print(" "+stones[stones.length-1]);
            findMaxJump(stones,stones.length-2,true);
            return;
        }


        if(!reverse) {

            System.out.print(" "+stones[i]);
            int temp = stones[i];
            stones[i] = -1;
            findMaxJump(stones, i+1, false);
            stones[i] = temp;
            findMaxJump(stones, i+1, false);
        }
        else{
            while( i>=0 && stones[i]==-1){
                i--;
            }
            if(i<0){
                System.out.print(" 0");
                System.out.println();
                return;
            }
            if(i==0){
                System.out.print(" 0");
                System.out.println();
                return;
            }
            System.out.print(" "+stones[i]);
            int temp = stones[i];
            stones[i] = -1;
            findMaxJump(stones, i-1, true);
            stones[i] = temp;
            findMaxJump(stones, i-1, true);
        }


    }

    public static void main(String[] args) {
        FrogJumpII solution = new FrogJumpII();

        int[] stones1 = {0, 2, 5, 6, 7};
        System.out.println(solution.maxJump(stones1)); // Expected: 5

        /* int[] stones2 = {0, 3, 9};
        System.out.println(solution.maxJump(stones2)); // Expected: 9

        int[] stones3 = {0, 1, 3, 6, 10, 15};
        System.out.println(solution.maxJump(stones3)); // Expected: 6*/
    }


}
