import java.util.Arrays;

public class JumpGameII {

    public int jump(int[] nums) {
        int n=nums.length;
        int maxRange=0;
        int jump=0;
        int i=0;
        while( maxRange<n-1){
            int max=maxRange;
            for(int j=0;j<=maxRange;j++){
                if(max<nums[j]+j){
                    max=nums[j]+j;
                }
            }
            maxRange=max;
            jump++;

        }
        return jump;
    }


    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();

        System.out.println(solution.jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3})); // 2
        System.out.println(solution.jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0})); // 3
        System.out.println(solution.jump(new int[]{2,1,1,1,1})); // 3
        System.out.println(solution.jump(new int[]{2,3,1,1,4})); // 2
        System.out.println(solution.jump(new int[]{2,3,0,1,4})); // 2
        System.out.println(solution.jump(new int[]{1,1,1,1}));   // 3
    }

}
