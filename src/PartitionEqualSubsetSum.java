import java.util.Arrays;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;
        total=total/2;
        Boolean[][]dp= new Boolean[nums.length][total+1];
        return find(total,nums,nums.length-1,dp);
    }


public static boolean find(int target, int[] arr, int index, Boolean[][] dp){
    if(target<0){
        return false;
    }
    if(index<0){
        return target==0;
    }
    if(dp[index][target]!=null) return dp[index][target];
    if(find(target-arr[index], arr,index-1,dp)||find(target, arr,index-1,dp)){

        return true;
    }
    dp[index][target]=false;
    return false;
}


    public static boolean canPartition2(int[] nums) {

            int total = Arrays.stream(nums).sum();
            if (total % 2 != 0) return false;
            int target = total / 2;

            BitSet dp = new BitSet(target + 1);
            dp.set(0);

            for (int num : nums) {
                BitSet shifted = (BitSet) dp.clone();
                for (int i = dp.length() - 1; i >= 0; i--) {
                    if (dp.get(i) && i + num <= target) {
                        shifted.set(i + num);
                    }
                }
                dp = shifted;
            }

            return dp.get(target);


    }

    public static void main(String[] args) {
        int[] arr1 = {1, 5, 11, 5};
        System.out.println("Can partition: " + canPartition2(arr1)); // true

        int[] arr2 = {1, 2, 3, 5};
        System.out.println("Can partition: " + canPartition2(arr2)); // false

        int[] arr3 = {2, 2, 3, 5};
        System.out.println("Can partition: " + canPartition2(arr3)); // false
    }

}
