import java.util.*;


public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;

        HashMap<Integer, List<Pair>> map = new HashMap<>();

        HashSet<List<Integer>> set= new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int sum = nums[i] + nums[j];
                int remaining = target - sum;

                map.computeIfAbsent(remaining, k -> new ArrayList<>()).add(new Pair(i, j));

            }
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(map.containsKey(nums[i]+nums[j])){
                    int sum2 = nums[i] + nums[j];
                    if (map.containsKey(sum2)) {
                        for (Pair pair : map.get(sum2)) {
                            if (pair.index1 != i && pair.index1 != j && pair.index2 != i && pair.index2 != j) {
                                List<Integer> list= new ArrayList<>();
                                list.add(nums[i]);
                                list.add(nums[j]);
                                list.add(nums[pair.index1]);
                                list.add(nums[pair.index2]);

                                set.add(list);
                            }
                        }
                    }
                }
            }
        }
        List<List<Integer>> lists= new ArrayList<>(set);
        lists.sort((a, b) -> {
            for (int i = 0; i < 4; i++) {
                int cmp = Integer.compare(a.get(i), b.get(i));
                if (cmp != 0) return cmp;
            }
            return 0;
        });
        return lists;

    }
    class Pair{

        public  int index1;
        public  int index2;

        public Pair(int i1,int i2){
            index1=i1;
            index2=i2;
        }
    }
}
