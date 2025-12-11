import java.util.*;

public class TopKFrequentElements {


    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num,0);
            map.put(num,map.get(num)+1);
        }
        TreeMap<Integer,ArrayList<Integer>> treeMap= new TreeMap<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            treeMap.putIfAbsent(entry.getValue(), new ArrayList<>());
            treeMap.get(entry.getValue()).add(entry.getKey());
        }
        int[] arr= new int[k];
        k--;
        int last=treeMap.lastKey();
         while(k>=0){
             List<Integer> temp=treeMap.get(last);
             for (Integer i : temp) {
                 arr[k--]=i;
             }
             if(k>=0)
              last=treeMap.lowerKey(last);
         }
         return arr;


    }

    public static void main(String[] args) {
        TopKFrequentElements sol = new TopKFrequentElements();

        // Test case 1
        System.out.println(Arrays.toString(
                sol.topKFrequent(new int[]{1,1,1,2,2,3}, 2)
        ));
        // Expected: [1, 2]

        // Test case 2
        System.out.println(Arrays.toString(
                sol.topKFrequent(new int[]{1,2,1,2,1,2,3,1,3,2}, 2)
        ));
        // Expected: [4]

        // Test case 3
        System.out.println(Arrays.toString(
                sol.topKFrequent(new int[]{1}, 1)
        ));
        // Expected: [8, 7]
    }


}
