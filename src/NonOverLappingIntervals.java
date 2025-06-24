import java.util.Arrays;
import java.util.Comparator;

public class NonOverLappingIntervals {


    public int eraseOverlapIntervals(int[][] intervals) {

        if (intervals.length == 0) return 0;

        // Sort by end time, then by start time
        Arrays.sort(intervals,
                Comparator.comparingInt((int[] a) -> a[1])
                        .thenComparingInt(a -> a[0])
        );

        int count = 0;
        int[] holder = intervals[0]; // keep the first interval

        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];

            if (current[0] >= holder[1]) {
                holder = current; // no overlap, keep it
            } else {
                count++; // overlap, remove current
            }
        }

        return count;


    }

    public static void main(String[] args) {
        NonOverLappingIntervals noi = new NonOverLappingIntervals();



        System.out.println(noi.eraseOverlapIntervals(new int[][]{
                {1,7},{2,6},{3,7},{3,5},{5,9}
        })); // Expected: 3

        System.out.println(noi.eraseOverlapIntervals(new int[][]{
                {0,3},{2,4},{3,5},{5,7},{6,8},{8,10}
        })); // Expected: 2

        System.out.println(noi.eraseOverlapIntervals(new int[][]{
                {-10,1},{0,2},{1,3},{2,4},{3,5},{4,6}
        })); // Expected: 3
    }

}
