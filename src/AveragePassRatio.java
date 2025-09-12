import java.util.*;

public class AveragePassRatio {

        public double maxAverageRatio(int[][] classes, int extraStudents) {

            PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                    (a, b) -> {
                        double x= (double) (a[1] - a[0]) /(a[1]*(a[1]+1));
                        double y= (double) (b[1] - b[0]) /(b[1]*(b[1]+1));
                        return Double.compare(y,x);

                    });
            for(int[]cls:classes){
                minHeap.offer(cls);
            }
            while(extraStudents>0){
                int []cls=minHeap.poll();
                cls[0]++;
                cls[1]++;
                minHeap.offer(cls);
                extraStudents--;
            }
            double sum = 0.0;
            for (int[] cls : classes) {
                sum += ((double) cls[0]) /((double)  cls[1]);
            }
            return sum / (classes.length);

        }

    public static void main(String[] args) {
        AveragePassRatio apr = new AveragePassRatio();

        int[][] classes1 = {{1,2},{3,5},{2,2}};
        int extra1 = 2;
        System.out.println(apr.maxAverageRatio(classes1, extra1));
        // Expected output: 0.7833... (approx)

        int[][] classes2 = {{2,4},{3,9},{4,5},{2,10}};
        int extra2 = 4;
        System.out.println(apr.maxAverageRatio(classes2, extra2));
        // Expected output: 0.5347... (approx)

        int[][] classes3 = {{1,3},{2,6}};
        int extra3 = 1;
        System.out.println(apr.maxAverageRatio(classes3, extra3));
        // Expected output: 0.4166... (approx)
    }

}
