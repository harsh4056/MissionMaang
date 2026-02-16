import java.util.*;

public class TopKFrequentElements {


    public int[] topKFrequent(int[] nums, int k) {
      PriorityQueue<int[]> maxHeap= new PriorityQueue<>((a,b)->{
          return b[1]-a[1];
      });
      HashMap<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            map.putIfAbsent(num,0);
            map.put(num,map.get(num)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           maxHeap.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        int[] ans= new int[k];
        for(int i=0;i<k;i++){
            ans[i]=maxHeap.poll()[0];
        }
        return ans;




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
