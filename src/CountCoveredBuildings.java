import java.util.Arrays;
import java.util.TreeMap;
import java.util.TreeSet;

public class CountCoveredBuildings {


    public int countCoveredBuildings(int n, int[][] buildings) {
        int size=buildings.length;
        Arrays.sort(buildings,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return a[0]-b[0];
        });
        TreeMap<Integer, TreeSet<Integer>> treeSetTreeMap= new TreeMap<>();
        for (int[] building : buildings) {
            treeSetTreeMap.putIfAbsent(building[1],new TreeSet<>());
            treeSetTreeMap.get(building[1]).add(building[0]);
        }
        int count=0;
        for (int i = 0; i < buildings.length; i++) {
            int[] building = buildings[i];

            boolean left= i - 1 >= 0 && buildings[i - 1][0] == building[0];
            boolean right= i + 1 < size && buildings[i +1][0] == building[0];
            TreeSet<Integer> treeSet= treeSetTreeMap.get(building[1]);
            boolean up=treeSet!=null && treeSet.lower(building[0])!=null;
            boolean down=treeSet!=null && treeSet.higher(building[0])!=null;
            if(up && down && right && left){
                count++;
            }

        }
        return count;


    }

    public static void main(String[] args) {
        CountCoveredBuildings soln = new CountCoveredBuildings();

        // Test case 1
        System.out.println(soln.countCoveredBuildings(
                3,
                new int[][]{{1,2},{2,2},{3,2},{2,1},{2,3}}
        ));
        // Expected: 1

        // Test case 2
        System.out.println(soln.countCoveredBuildings(
                3,
                new int[][]{{1,1},{1,2},{2,1},{2,2}}
        ));
        // Expected: 0

        // Test case 3
        System.out.println(soln.countCoveredBuildings(
                5,
                new int[][]{{1,3},{3,2},{3,3},{3,5},{5,3}}
        ));
        // Expected: 1
    }

}
