public class JumpGame {


    public boolean canJump(int[] nums) {

        int n=nums.length;
        int lowestIndexToReach=n-1;

        for(int i=n-2;i>=0;i--){

            if(nums[i]+i>=lowestIndexToReach){
                lowestIndexToReach=i;
            }
        }
        return lowestIndexToReach==0;

    }

    public static void main(String[] args) {
        JumpGame solution = new JumpGame();

     /*   System.out.println(solution.canJump(new int[]{2,3,1,1,4})); // true
        System.out.println(solution.canJump(new int[]{3,2,1,0,4})); // false*/
        System.out.println(solution.canJump(new int[]{1,0,2,0,3})); // true
    }


}
