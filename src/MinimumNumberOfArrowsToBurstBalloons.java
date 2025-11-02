import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfArrowsToBurstBalloons

{

    public int findMinArrowShots(int[][] points) {
        int n=points.length;
        Arrays.sort(points,(a,b)->{
            if(a[0]==b[0])
                return a[1]-b[1];
            return a[0]-b[0];
        });
        int start=points[0][0];
        int end=points[0][1];
        int count=1;
        for(int i=1;i<n;i++){
            int []curr= points[i];

            if(curr[0]>=start && curr[0]<=end){
                start=Math.max(start,curr[0]);

            }
            else{
                count++;
                 start=curr[0];
                 end=curr[1];
            }
        }
        return count;
    }
    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons sol = new MinimumNumberOfArrowsToBurstBalloons();

        int[][] points1 = {{3,9},{7,12},{3,8},{6,8},{9,10},{2,9},{0,9},{3,9},{0,6},{2,8}};
        int[][] points2 = {{10,16},{2,8},{1,6},{7,12}};
        int[][] points3 = {{1,2},{3,4},{5,6},{7,8}};
        int[][] points4 = {{9,12},{1,10},{4,11},{8,12},{3,9},{6,9},{6,7}};
        System.out.println(sol.findMinArrowShots(points4)); // Expected: 2
        System.out.println(sol.findMinArrowShots(points1)); // Expected: 2
        System.out.println(sol.findMinArrowShots(points2)); // Expected: 2
        System.out.println(sol.findMinArrowShots(points3)); // Expected: 4

    }



}
