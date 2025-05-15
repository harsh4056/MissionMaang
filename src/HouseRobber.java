public class HouseRobber {


    public int rob(int[] nums) {
        int max;
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==0){
            return 0;
        }
        int[] dp =new int[nums.length];
        dp[0]=nums[0];
        dp[1]=nums[1];
        max=nums[0];
        for (int i = 2; i < nums.length; i++) {
                dp[i]= Math.max(dp[i-2]+nums[i],max+nums[i]);
                max=Math.max(max,dp[i-1]);
            }

        return Math.max(dp[nums.length-2],dp[nums.length-1]);
    }

    public static void main(String[] args) {
        HouseRobber houseRobber=  new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{9,1,1,1,1,7 }));
    }
}
