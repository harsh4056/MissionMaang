import java.util.Arrays;

public class MinimumIntervalToIncludeEachQuery {

    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)->{
            if(a[0]==b[0]){
                return (a[1]-a[0])-(b[1]-b[0]);
            }
            return a[0]-b[0];
        });
        for(int query:queries){
            int left=0,right=intervals.length;
            while (left<right){

            }
        }
        return null;
    }
}
