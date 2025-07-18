import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class NumberOfDistinctIslands {

    public static int distinctIsland(int [][] arr, int n, int m)
    {
        HashSet<Integer> hashSet= new HashSet<>();
        for (int i = 0; i < arr.length; i++) {

            for (int j = 0; j < arr[0].length; j++) {
                List<int[]> list = new ArrayList<>();
              if(arr[i][j]==1){
                  dfs(arr,i,j,list,new int[]{i,j});
                  if(!list.isEmpty()){
                      hashSet.add(Arrays.deepHashCode(list.toArray()));
                  }
              }

            }
        }
       return hashSet.size();
    }

    public static void dfs(int[][]grid, int i, int j, List<int[]> list, int[] ints){
        if(i< grid.length &&i>=0 && j<grid[0].length && j>=0){


            if(grid[i][j]==1){

                grid[i][j]=-1;
                list.add(new int[]{i-ints[0],j-ints[1]});
                dfs(grid,i+1,j,list, ints);
                dfs(grid,i,j+1,list, ints);
                dfs(grid,i-1,j,list, ints);
                dfs(grid,i,j-1,list, ints);

            }

        }
    }

    public static void main(String[] args) {
        int[][] grid1 = {
                {1,1,0,0,0},
                {1,0,0,0,0},
                {1,1,0,1,1},
                {0,1,0,1,1}
        }; // Expected: 3

        int[][] grid2 = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,0,1},
                {1,1,0,1,1}
        }; // Expected: 3

        int[][] grid3 = {
                {1,1,0,0,0},
                {0,1,0,0,1},
                {1,0,0,1,1},
                {0,0,0,1,0}
        }; // Expected: 3

        System.out.println(NumberOfDistinctIslands.distinctIsland(grid1, 4, 5));
        System.out.println(NumberOfDistinctIslands.distinctIsland(grid2, 4, 5));
        System.out.println(NumberOfDistinctIslands.distinctIsland(grid3, 4, 5));
    }

}
