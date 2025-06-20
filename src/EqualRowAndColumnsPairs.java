import java.util.*;

public class EqualRowAndColumnsPairs {

    public int equalPairs(int[][] grid) {

        int n=grid.length;

        HashMap<String,Integer> list1 = new HashMap<>();
        HashMap<String,Integer> list2 = new HashMap<>();
        int count=0;



        for (int i = 0; i < grid.length; i++) {
            StringBuilder stringBuilder1= new StringBuilder();
            StringBuilder stringBuilder2= new StringBuilder();
            for (int j = 0; j < grid[i].length; j++) {
                int a = grid[j][i];
                int b = grid[i][j];
                stringBuilder1.append(a);
                stringBuilder1.append(',');
                stringBuilder2.append(b);
                stringBuilder2.append(',');
            }
           list1.put(stringBuilder1.toString(),list1.getOrDefault(stringBuilder1.toString(),0)+1);
           list2.put(stringBuilder2.toString(),list2.getOrDefault(stringBuilder2.toString(),0)+1);

        }
        for (String s1 : list2.keySet()) {
            for (String s : list1.keySet()) {
                if(s.equals(s1))
                 count+= list1.getOrDefault(s1,0)*list2.getOrDefault(s,0);
            }
        }


        return count;
    }


    public int equalPairs2(int[][] grid) {

        int n=grid.length;
        int count=0;
        for (int[] ints : grid) {
            for (int i = 0; i < ints.length; i++) {
                boolean exists=true;
                for (int j = 0; j < ints.length; j++) {
                    if(grid[j][i]!=ints[j]){
                        exists=false;
                        break;
                    }
                }
                if(exists) {
                    count++;
                }

            }
        }

        return count;
    }

    public static void main(String[] args) {
        EqualRowAndColumnsPairs obj = new EqualRowAndColumnsPairs();

        int[][] grid1 = {{11, 1}, {1, 11}};
        System.out.println(obj.equalPairs2(grid1)); // Expected: 2

        int[][] grid2 = {{3,2,1},{1,7,6},{2,7,7}};
        System.out.println(obj.equalPairs2(grid2)); // Expected: 1

        int[][] grid3 = {{13,13},{13,13}};
        System.out.println(obj.equalPairs2(grid3)); // Expected: 4
    }

}
