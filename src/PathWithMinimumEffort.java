import java.util.*;

public class PathWithMinimumEffort {

    public int minimumEffortPath(int[][] heights) {

        int n=heights.length;
        int m=heights[0].length;
        int[][] matrix = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for(int []arr:matrix){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        int [][]directions=new int[][]{
                {0,1},
                {1,0},
                {0,-1},
                {-1,0}
        };

        matrix[0][0]=0;
        PriorityQueue<int[]> minHeap= new PriorityQueue<>(Comparator.comparingInt(a->a[0]));
        minHeap.offer(new int[]{0,0,0});
        while(!minHeap.isEmpty()){
            int [] current=minHeap.poll();
            int prevDiff=current[0];
            int cr=current[1];
            int cc=current[2];
            if (visited[cr][cc]) continue;


            for(int[]direction:directions){

                int r= cr+direction[0];
                int c= cc+direction[1];

                if(r>=0 && r<n && c>=0 && c<m && !visited[r][c]/*if not visited*/){
                    int diff= Math.abs(heights[cr][cc]-heights[r][c]);
                    if(matrix[r][c]>diff ){
                        int newDiff=Math.max(diff,prevDiff);
                        matrix[r][c]=newDiff;
                        minHeap.offer(new int[]{newDiff,r,c});
                    }
                }
            }
            visited[cr][cc]=true;

        }
        return matrix[n-1][m-1];

    }
    public static void main(String[] args) {
        PathWithMinimumEffort solution = new PathWithMinimumEffort();

        int[][] heights1 = {
                {1,2,2},
                {3,8,2},
                {5,3,5}
        };
        System.out.println(solution.minimumEffortPath(heights1)); // Expected: 2

        int[][] heights2 = {
                {1,2,3},
                {3,8,4},
                {5,3,5}
        };
        System.out.println(solution.minimumEffortPath(heights2)); // Expected: 1

        int[][] heights3 = {
                {1,2,1,1,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,2,1,2,1},
                {1,1,1,2,1}
        };
        System.out.println(solution.minimumEffortPath(heights3)); // Expected: 0
    }

}
