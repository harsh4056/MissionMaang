import java.util.Arrays;

public class JumpGameII {

    public int jump(int[] nums) {
        int n=nums.length;

        int []dp= new int[n];
        Arrays.fill(dp,10000);

        return findJumps(nums,0,dp);
    }
        public int jump2(int[] nums) {
            int n=nums.length;
            if(n==1){
                return 0;
            }
            int count=0;
            int l=1;
            int r=nums[0];
            while(r<n-1){

                int farthest=0;
                for(int i=l;i<=r;i++){
                    farthest=Math.max(farthest,i+nums[i]);
                }
                l=r+1;
                r=farthest;
                count++;
            }

            return count+1;
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

        System.out.println(solution.jump2(new int[]{1,2})); // 3
        System.out.println(solution.jump2(new int[]{5,9,3,2,1,0,2,3,3,1,0,0})); // 3
        System.out.println(solution.jump2(new int[]{2,1,1,1,1})); // 3
        System.out.println(solution.jump2(new int[]{2,3,1,1,4})); // 2
        System.out.println(solution.jump2(new int[]{2,3,0,1,4})); // 2
        System.out.println(solution.jump2(new int[]{1,1,1,1}));   // 3
    }

}
