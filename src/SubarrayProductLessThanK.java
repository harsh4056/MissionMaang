import java.util.HashMap;

public class SubarrayProductLessThanK {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();

        int sum=1;
        int count=0;
        map.put(0,1);
        for (int num : nums) {
            sum += num;

            count += map.getOrDefault(sum - k, 0);

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        return count;
    }
}
