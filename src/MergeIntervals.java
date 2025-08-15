import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
   /* Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].*/
    public int[][] merge(int[][] intervals) {


        Arrays.sort(intervals, Comparator.comparingInt(a->a[0]));
        int n=intervals.length;
        int []prev= new int[]{intervals[0][0],intervals[0][1]};
        List<int[]> list= new ArrayList<>();
        for(int i=1;i<n;i++){
            int []interval=intervals[i];
            if(interval[0]>=prev[0] && interval[0]<=prev[1]){
                prev[0]=Math.min(prev[0],interval[0]);
                prev[1]=Math.max(prev[1],interval[1]);
            }
            else{
                list.add(prev);
                prev=interval;
            }
        }

        int []interval=intervals[n-1];
        if(interval[0]>=prev[0] && interval[0]<=prev[1]){
            prev[0]=Math.min(prev[0],interval[0]);
            prev[1]=Math.max(prev[1],interval[1]);
            list.add(prev);
        }
        else{
            list.add(prev);

        }

        int[][] answer= new int[list.size()][2];
        for(int i=0;i<answer.length;i++){
            answer[i]=list.get(i);
        }
        return answer;

    }

    public static void main(String[] args) {
        MergeIntervals mergeIntervals = new MergeIntervals();

        int[][] result1 = mergeIntervals.merge(new int[][]{{1,3},{2,6},{8,10},{15,18}});
        System.out.println(Arrays.deepToString(result1));
        // Expected: [[1,6],[8,10],[15,18]]

        int[][] result2 = mergeIntervals.merge(new int[][]{{1,4},{4,5}});
        System.out.println(Arrays.deepToString(result2));
        // Expected: [[1,5]]

        int[][] result3 = mergeIntervals.merge(new int[][]{{2,3},{4,5},{6,7},{8,9},{1,10}});
        System.out.println(Arrays.deepToString(result3));
        // Expected: [[1,10]]
    }


}
