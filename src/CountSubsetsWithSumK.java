import java.util.Arrays;

public class CountSubsetsWithSumK {

    public static int findWays(int num[], int tar) {
        // Write your code here.
        int[][]dp= new int[num.length][tar+1];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        int ans=solve(num,tar,0,dp);
        return ans;
    }
    public static int solve(int []nums, int k, int index, int[][] dp){
        if(k==0) return 1;
        if(index==nums.length-1){
            if(nums[index]==k) return 1;
            return 0;
        }
        if(dp[index][k]!=-1) return dp[index][k];
        int take=0;
        if(nums[index]<=k)
         take = solve(nums,k-nums[index],index+1, dp);
        int skip=solve(nums,k,index+1, dp);
        return dp[index][k]= take+skip;
    }

    public static int findWays2(int []num, int tar) {
        int n=num.length;
        int[][]dp= new int[n+1][tar+1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0]=1;

        }
        for (int i = n-1; i >=0 ;i--) {
            for(int j=1;j<=tar;j++){
                int take=0;
                if(j-num[i]>=0){
                    take= dp[i+1][j-num[i]];
                }

                int skip=dp[i+1][j];
                dp[i][j]=take+skip;
            }

        }
        return dp[0][tar];

    }

    public static void main(String[] args) {

        //System.out.println(findWays2(new int[]{12 ,14 ,3 ,18, 2},13));
        System.out.println(findWays(new int[]{0,0,1},1));
        System.out.println(findWays(new int[]{1,4,4,5},5));
    }
}
