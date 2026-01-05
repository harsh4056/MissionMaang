import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class NumberOfFlowersInFullBloom {


    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        TreeMap<Integer,int[]> map= new TreeMap<>();

        for (int[] flower : flowers) {
            map.putIfAbsent(flower[0],new int[]{0,0});
            map.putIfAbsent(flower[1],new int[]{0,0});
            map.get(flower[0])[0]++;
            map.get(flower[1])[1]--;

        }
        for (int person : people) {
            map.put(person,map.getOrDefault(person,new int[]{0,0}));
        }

        int count=0;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int[]curr=entry.getValue();
            count+=curr[0];
            map.get(entry.getKey())[0]=count;
            count+=curr[1];
        }int[]ans= new int[people.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i]= map.get(people[i])[0];

        }

        return ans;
    }

    public static void main(String[] args) {
        NumberOfFlowersInFullBloom obj = new NumberOfFlowersInFullBloom();

        // Test case 1
        int[][] flowers1 = {
                {1, 6},
                {3, 7},
                {9, 12},
                {4, 13}
        };
        int[] people1 = {2, 3, 7, 11};
        int[] res1 = obj.fullBloomFlowers(flowers1, people1);
        for (int x : res1) System.out.print(x + " ");
        // Expected: 1 2 2 2

        System.out.println();

        // Test case 2
        int[][] flowers2 = {
                {1, 10},
                {3, 3}
        };
        int[] people2 = {3, 4};
        int[] res2 = obj.fullBloomFlowers(flowers2, people2);
        for (int x : res2) System.out.print(x + " ");
        // Expected: 2 1

        System.out.println();

        // Test case 3
        int[][] flowers3 = {
                {5, 5},
                {6, 6},
                {7, 7}
        };
        int[] people3 = {4, 5, 6, 7, 8};
        int[] res3 = obj.fullBloomFlowers(flowers3, people3);
        for (int x : res3) System.out.print(x + " ");
        // Expected: 0 1 1 1 0
    }

}
