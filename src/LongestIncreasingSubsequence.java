import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestIncreasingSubsequence {



    public int lengthOfLIS(int[] nums) {
        int []dp= new int[nums.length];
        Arrays.fill(dp,1);
        int max=0;
        for (int i = nums.length-1; i >=0 ; i--) {
            for (int j = i; j <nums.length ; j++) {
                if(nums[i]<nums[j]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }

            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence= new LongestIncreasingSubsequence();
        System.out.println(
        longestIncreasingSubsequence.lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
    }
}
