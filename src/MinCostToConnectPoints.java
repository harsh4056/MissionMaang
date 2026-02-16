import java.util.*;

public class MinCostToConnectPoints {

    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int visited=1;
        HashSet<Integer> set= new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(i);
        }
        PriorityQueue<Pair> minHeap= new PriorityQueue<>(Comparator.comparingInt(a -> a.distance));
        minHeap.offer(new Pair(0,0));
        int ans=0;
        while (!minHeap.isEmpty() && visited<n){
            Pair curr= minHeap.poll();
            if(!set.contains(curr.node)){
                continue;
            }
            set.remove(curr.node);
            ans+=curr.distance;
            for(int neighbor:set){
                int x=points[curr.node][0];
                int xn=points[neighbor][0];
                int y=points[curr.node][1];
                int yn=points[neighbor][1];

                int distance= Math.abs(xn-x)+Math.abs(yn-y);
                minHeap.offer(new Pair(neighbor,distance));
            }
        }
        return ans;

    }
    class Pair{
        int node;
        int distance;

        public Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
    public static void main(String[] args) {
        MinCostToConnectPoints obj = new MinCostToConnectPoints();

        int[][] points1 = {{0,0},{2,2},{3,3},{2,4},{4,2}};
        System.out.println("Test Case 1 Output: " + obj.minCostConnectPoints(points1));
        // Expected: 20

        int[][] points2 = {{3,12},{-2,5},{-4,1}};
        System.out.println("Test Case 2 Output: " + obj.minCostConnectPoints(points2));
        // Expected: 18

        int[][] points3 = {{0,0},{1,1},{1,0},{-1,1}};
        System.out.println("Test Case 3 Output: " + obj.minCostConnectPoints(points3));
        // Expected: 4
    }



}
