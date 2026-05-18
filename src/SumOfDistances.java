import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SumOfDistances {


    public long[] distance(int[] nums) {
        HashMap<Integer, List<Integer>> hashMap= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            hashMap.computeIfAbsent(num,k-> new ArrayList<>()).add(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];

        }



        return null;

    }
}
