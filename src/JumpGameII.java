import java.util.Arrays;

public class JumpGameII {

    public int jump(int[] nums) {
        int n=nums.length;

        int []dp= new int[n];
        Arrays.fill(dp,10000);

        return findJumps(nums,0,dp);
    }

    public int findJumps(int[] nums,int index,int[]dp){
        if(index>=nums.length-1){
            return 0;
        }
        if(dp[index]<10000){
            return dp[index];
        }
        int value=10000;

        for(int i=1;i<=nums[index];i++){
            value=Math.min(value,1+findJumps(nums,index+i,dp));
        }
        dp[index]=value;
        return value;
    }

    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();

        System.out.println(solution.jump(new int[]{2,3,1,1,4})); // 2
        System.out.println(solution.jump(new int[]{2,3,0,1,4})); // 2
        System.out.println(solution.jump(new int[]{1,1,1,1}));   // 3
    }

}
