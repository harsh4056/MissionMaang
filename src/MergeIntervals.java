import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
   /* Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
    Output: [[1,6],[8,10],[15,18]]
    Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].*/
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b)->{
            return a[0]-b[0];
        });
        int []can= intervals[0];
        int n=intervals.length;
        List<int[]> list= new ArrayList<>();
        for(int i=0;i<n;i++){
            int[]curr=intervals[i];
            if(curr[0]<=can[1]){
                can[1]=curr[1];
            }
            else{
                list.add(can);
                can=curr;

            }
            if(i==n-1){
                list.add(can);
            }
        }
        int[][]ans= new int[list.size()][2];
        int i=0;
        for(int[]arr:list){
            ans[i++]=arr;
        }
        return ans;


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
