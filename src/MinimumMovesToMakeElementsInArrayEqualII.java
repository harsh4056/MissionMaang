import java.util.Arrays;

public class MinimumMovesToMakeElementsInArrayEqualII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int median= (n+1)/2;
        int sumOps=0;
        for (int num : nums) {
            sumOps=Math.abs(num-nums[median]);
        }
        return sumOps;
    }
}
