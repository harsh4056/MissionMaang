import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate2 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer,Integer> map= new HashMap<>();
        boolean check=false;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && map.get(nums[i]) != i) {
                if (Math.abs(i - map.get(nums[i])) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicate2 containsDuplicate2= new ContainsDuplicate2();

        containsDuplicate2.containsNearbyDuplicate( new int[]{1,0,1,1},1);
    }

}
