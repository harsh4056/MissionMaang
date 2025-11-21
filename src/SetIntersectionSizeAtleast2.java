import java.util.Arrays;

public class SetIntersectionSizeAtleast2 {

    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->{
            if(a[1]==b[1]){
                return b[0]-a[0];
            }
            return a[1]-b[1];
        });
        int count=0;
        int a=-1;
        int b=-1;
        for (int[]interval:intervals){
            int start=interval[0];
            int end=interval[1];
            if(a>=start && a<=end  && b>=start && b<=end ){
                continue;
            }
            else if(b>=start && b<=end ){
                a=b;
                b=end;
                count++;
            }
            else{
                a=end-1;
                b=end;
                count+=2;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        SetIntersectionSizeAtleast2 sol = new SetIntersectionSizeAtleast2();

        // Test case 1
        int[][] intervals1 = {{1,3},{1,4},{2,5},{3,5}};
        System.out.println(sol.intersectionSizeTwo(intervals1));
        // Expected: 3

        // Test case 2
        int[][] intervals2 = {{1,2},{2,3},{2,4},{4,5}};
        System.out.println(sol.intersectionSizeTwo(intervals2));
        // Expected: 5

        // Test case 3
        int[][] intervals3 = {{1,3},{3,7},{8,9}};
        System.out.println(sol.intersectionSizeTwo(intervals3));
        // Expected: 5
    }

}
