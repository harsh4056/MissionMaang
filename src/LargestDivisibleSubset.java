import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargestDivisibleSubset {

    public List<Integer> largestDivisibleSubset(int[] nums) {
        int[]dp= new int[nums.length];
        int[]hash= new int[nums.length];
        Arrays.fill(dp,1);
        Arrays.fill(hash,-1);
        Arrays.sort(nums);
        int maximum=-1;
        int maxIndex=-1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <i ; j++) {
                if(nums[i]%nums[j]==0 &&dp[i]<=dp[j]){
                    dp[i]=1+dp[j];
                    hash[i]=j;
                }
            }
            if(maximum<dp[i]){
                maximum=dp[i];
                maxIndex=i;
            }

        }
        List<Integer> data= new ArrayList<>();
        int index=maxIndex;
        while(hash[index]!=-1){
            data.add(nums[index]);
            index=hash[index];
        }
        data.add(nums[index]);
        return data;

    }

    public static void main(String[] args) {
        LargestDivisibleSubset solution = new LargestDivisibleSubset();

        System.out.println(solution.largestDivisibleSubset(new int[]{4,8,10,240})); // Expected: [2, 1] or [3, 1]
        System.out.println(solution.largestDivisibleSubset(new int[]{1,2,4,8})); // Expected: [8, 4, 2, 1]
        System.out.println(solution.largestDivisibleSubset(new int[]{3,4,16,8})); // Expected: [16, 8, 4]
    }

}
