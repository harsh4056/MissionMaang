import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
   /* Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].*/
    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]); // Tie-breaker on end
        });


        int start=-1;
        int end=-1;
        List<int[]> ints = new ArrayList<>();

        for (int[] interval : intervals) {
            if(end==-1){
                end=interval[1];
                start=interval[0];
            }
            if(end>=interval[0]){
                int tempEnd= Math.max(end, interval[1]);
                int[]newInterval=   new int[]{start,tempEnd};
                if(!ints.isEmpty())
                    ints.remove(ints.size()-1);
                ints.add(newInterval);
                end=interval[1];
            }
            else{
                ints.add(interval);
                end=interval[1];
                start=interval[0];
            }


        }
        int[][] newIntervals= new int[ints.size()][2];
        for (int i = 0; i < ints.size(); i++) {
            int[] newInterval = ints.get(i);
            newIntervals[i]=newInterval;
        }

            return newIntervals;

    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals= new MergeIntervals();
        //mergeIntervals.merge(new int[][]{{1,3},{2,6},{8,15},{15,18}});
        mergeIntervals.merge(new int[][]{{1,5},{2,3}});

    }

}
