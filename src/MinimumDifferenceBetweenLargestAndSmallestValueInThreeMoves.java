import java.util.ArrayList;
import java.util.Arrays;

public class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {


    public int minDifference(int[] nums) {
        Arrays.sort(nums);
        if(nums.length<=4){
            return 0;
        }
        int mini= nums[nums.length-4]-nums[0];

        for(int i=0;i<3;i++){
            nums[i]=nums[nums.length-1];
        }
        Arrays.sort(nums);
        int x=nums[nums.length-1]-nums[0];
        mini=Math.min(x,mini);
        return mini;
    }

    public static void main(String[] args) {
        MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves soln = new MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves();
        System.out.println(soln.minDifference(new int[]{90,35,67,53,61}));
        System.out.println(soln.minDifference(new int[]{61,61,67,53,61}));
        System.out.println(soln.minDifference(new int[]{1,5,0,10,14}));
        System.out.println(soln.minDifference(new int[]{6,6,0,1,1,4,6}));
    }
}
