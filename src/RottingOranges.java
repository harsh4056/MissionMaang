import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue= new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               if(grid[i][j]==2){
                   queue.add(new int[]{i,j,0});
               }

            }

        }

        int [][]directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        int max=0;
        while (!queue.isEmpty()){
            int[] current=queue.poll();
            for (int[] direction : directions) {

                int i=current[0]+direction[0];
                int j=current[1]+direction[1];
                max=Math.max(max,current[2]);
                 if((i>=0 && i<grid.length && j>=0 && j< grid[0].length) &&
                         !(grid[i][j]==0 || grid[i][j]==2)
                ){
                    grid[i][j]=2;
                    queue.offer(new int[]{i,j,current[2]+1});

                }

            }
        }
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 1) {
                    return -1;
                }

            }

        }
        return max;
    }

    public static void main(String[] args) {
        RottingOranges solution = new RottingOranges();

        int[][] grid1 = {
                {2,1,1},
                {1,1,0},
                {0,1,1}
        };
        System.out.println(solution.orangesRotting(grid1)); // Expected: 4

        int[][] grid2 = {
                {2,1,1},
                {0,1,1},
                {1,0,1}
        };
        System.out.println(solution.orangesRotting(grid2)); // Expected: -1

        int[][] grid3 = {
                {0}
        };
        System.out.println(solution.orangesRotting(grid3)); // Expected: 0
    }

}
