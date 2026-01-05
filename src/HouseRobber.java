import java.util.Arrays;

public class HouseRobber {


    public int rob(int[] nums) {

        int n=nums.length;
        int []dp= new int[n+2];
        for(int i=n-1;i>=0;i--){
            int take =nums[i]+dp[i+2];
            int skip =dp[i+1];
            dp[i]=Math.max(take,skip);
        }
        return dp[0];
    }

    public int rob2(int []nums){
        int[]dp= new int[nums.length+1];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);

    }
    public int solve(int[]nums, int index, int[] dp){
        if(index>= nums.length) return 0;
        int take= nums[index]+solve(nums,index+2, dp);
        int skip= solve(nums,index+1, dp);

        return Math.max(take,skip);
    }


    public static void main(String[] args) {
        HouseRobber houseRobber=  new HouseRobber();
        System.out.println(houseRobber.rob2(new int[]{9,1,1,1,1,7 }));
    }
}
