import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContinuousSubarraySum {

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, CountIndexPair> modMap = new HashMap<>();
        modMap.put(0, new CountIndexPair(1,new ArrayList<>(List.of(-1))));

        CountIndexPair count;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            int mod = (sum % k);  // handle negative values

            count = modMap.getOrDefault(mod, new CountIndexPair(0, new ArrayList<>()));

            if(modMap.containsKey(mod)){
                modMap.get(mod).indexes.add(i);
                modMap.get(mod).count=modMap.get(mod).count+1;
            }
            else{
                List<Integer> indexes=new ArrayList<>();
                indexes.add(i);
                modMap.put(mod, modMap.getOrDefault(mod, new CountIndexPair(1, indexes)));
            }

                if(Math.abs(modMap.get(mod).indexes.getFirst()-i)>1){
                    return true;
                }


        }

        return false;
    }


    class CountIndexPair{
        int count=0;
        List<Integer> indexes;

        public CountIndexPair(int count, List<Integer> indexes) {
            this.count = count;
            this.indexes = indexes;
        }

        public CountIndexPair() {
            this.count = 0;
            this.indexes = null;
        }
    }



    public static void main(String[] args) {
        ContinuousSubarraySum solution = new ContinuousSubarraySum();

       /* System.out.println(solution.checkSubarraySum(new int[]{23, 2, 4, 6, 7}, 6)); // true
        System.out.println(solution.checkSubarraySum(new int[]{23, 2, 6, 4, 7}, 6)); // true
        System.out.println(solution.checkSubarraySum(new int[]{1, 2, 3}, 5)); // true*/
        System.out.println(solution.checkSubarraySum(new int[]{23,2,4,6,6}, 7)); // false

    }

}
