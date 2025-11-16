import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class CarPooling {

    public boolean carPooling(int[][] trips, int capacity) {
        PriorityQueue<int[]> minHeap=new PriorityQueue<>((a,b)-> {
            if (a[0] == b[0]) {
                return a[2] - b[2];
            }
            return a[0]-b[0];
        }
        );

        for (int[] trip : trips) {
            minHeap.offer(new int[]{trip[1], trip[0],0});
            minHeap.offer(new int[]{trip[2],0,-trip[0]});
        }
        int count=0;
        while (!minHeap.isEmpty()){
            int[]curr= minHeap.poll();
            count+=curr[1];
            count+=curr[2];
            if(count>capacity) return false;
        }
        return true;

    }
    public static void main(String[] args) {
        CarPooling cp = new CarPooling();

        int[][] t3 = {{2,2,6},{2,4,7},{8,6,7}};
        System.out.println(cp.carPooling(t3, 11)); // true

        int[][] t1 = {{2,1,5},{3,3,7}};
        System.out.println(cp.carPooling(t1, 4)); // false

        int[][] t2 = {{2,1,5},{3,3,7}};
        System.out.println(cp.carPooling(t2, 5)); // true


    }

}
