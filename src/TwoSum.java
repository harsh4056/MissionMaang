import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {


        HashMap<Integer,Integer> map= new HashMap<>();
        HashSet<Integer> hashSet= new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            map.put( target-nums[i],i);

        }
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])  && map.get(nums[i])!=i){
                return new int[]{map.get(nums[i]),i};
            }

        }

        return new int[]{};

    }

    public static void main(String[] args) {
        TwoSum sum= new TwoSum();
        int[] twoSum= sum.twoSum(new int[]{2,7,11,15},9);
        int[] twoSum1= sum.twoSum(new int[]{3,2,4},6);
        int[] twoSum2= sum.twoSum(new int[]{3,3},6);
        System.out.println(twoSum);
    }
}
