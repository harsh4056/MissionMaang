import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class AvoidFloodInTheCity {
    public int[] avoidFlood(int[] rains) {
        int n= rains.length;

        int[] ans=new int[n];
        PriorityQueue<int[]> maxHeap= new PriorityQueue<>((a,b)->{
            if(a[1]==b[1]) return b[0]-a[0];
            return b[1]-a[1];
        });
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < n; i++) {

            if(rains[i]>0) {
                map.put(rains[i], map.getOrDefault(rains[i], 0) + 1);
                if (map.get(rains[i]) > 1) return new int[]{};
                maxHeap.offer(new int[]{rains[i], 1});
                ans[i]=-1;
            }
            else{
                if(!maxHeap.isEmpty() && maxHeap.peek()[1]>0) {
                    int[] curr = maxHeap.poll();
                    curr[1] = curr[1] - 1;
                    ans[i]=curr[0];
                    map.put(curr[0], map.getOrDefault(curr[0], 0) - 1);
                }
                else{
                    ans[i]=1;
                }

            }

        }
        return ans;
    }
    public static void main(String[] args) {
        AvoidFloodInTheCity solution = new AvoidFloodInTheCity();

        int[] rains1 = {1,2,0,2,3,0,1};
        int[] result1 = solution.avoidFlood(rains1);
        System.out.println(java.util.Arrays.toString(result1)); // Expected: possible valid dry sequence or empty array if invalid

        int[] rains2 = {1,2,3,4};
        int[] result2 = solution.avoidFlood(rains2);
        System.out.println(java.util.Arrays.toString(result2)); // Expected: [-1, -1, -1, -1]

        int[] rains3 = {1,2,0,1,2};
        int[] result3 = solution.avoidFlood(rains3);
        System.out.println(java.util.Arrays.toString(result3)); // Expected: [] or some valid sequence if possible
    }


}
