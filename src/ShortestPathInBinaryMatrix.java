import java.util.*;

public class ShortestPathInBinaryMatrix {


    public int shortestPathBinaryMatrix(int[][] grid) {
        int[][]directions= new int[][]{
                {0,1},
                {0,-1},
                {1,0},
                {-1,0},
                {1,1},
                {-1,1},
                {1,-1},
                {-1,-1},
        };

        int n= grid.length;
        int [][]matrix= new int[n][n];
        matrix[0][0]=1;
        Queue<int[]> queue= new ArrayDeque<>();
        queue.offer(new int[]{0,0});

        while(!queue.isEmpty()){

            int []current= queue.poll();
            grid[current[0]][current[1]] = -1;
            for(int []direction:directions){

                int[]candidate= new int[]{current[0],current[1]};
                candidate[0]+=direction[0];
                candidate[1]+=direction[1];

                if(candidate[0]>=0 && candidate[0]<n && candidate[1]>=0 &&
                        candidate[1]<n && grid[candidate[0]][candidate[1]]==0) {
                    matrix[candidate[0]][candidate[1]] = matrix[current[0]][current[1]] + 1;
                    grid[candidate[0]][candidate[1]]=-1;
                    queue.offer(new int[]{candidate[0], candidate[1]});
                }
            }
        }

        return matrix[n-1][n-1];
    }

    public static void main(String[] args) {
        ShortestPathInBinaryMatrix spbm = new ShortestPathInBinaryMatrix();

        int[][] grid1 = {
                {0, 1},
                {1, 0}
        };
        System.out.println(spbm.shortestPathBinaryMatrix(grid1)); // Expected: 2

        int[][] grid2 = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(spbm.shortestPathBinaryMatrix(grid2)); // Expected: 4

        int[][] grid3 = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(spbm.shortestPathBinaryMatrix(grid3)); // Expected: 3
    }

}
