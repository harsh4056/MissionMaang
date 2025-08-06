import java.util.Arrays;

public class BurstBalloons {

    public int maxCoins(int[] nums) {
        int[][]dp= new int[nums.length+1][nums.length+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        int []arr= new int[nums.length+2];
        arr[0]=1;
        arr[arr.length-1]=1;
        System.arraycopy(nums, 0, arr, 1, nums.length);
        return solve(arr,1,nums.length,dp);


    }
    public int solve(int[]nums,int i,int j,int[][]dp){
        if(i>j) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int maxim=Integer.MIN_VALUE;
        for(int k=i;k<=j;k++){
            int cost= nums[i-1]*nums[k]*nums[j+1]+solve(nums,i,k-1,dp)+solve(nums,k+1,j,dp);
            maxim=Math.max(cost,maxim);
        }
        dp[i][j]=maxim;
        return maxim;

    }

    public static void main(String[] args) {
        BurstBalloons bb = new BurstBalloons();

        int[] test1 = {3, 1, 5, 8};
        //System.out.println(bb.maxCoins(test1)); // Expected: 167

        int[] test2 = {9};
        System.out.println(bb.maxCoins(test2)); // Expected: 10

        int[] test3 = {9, 76, 64, 21};
        System.out.println(bb.maxCoins(test3)); // Expected: 116718
    }


}
