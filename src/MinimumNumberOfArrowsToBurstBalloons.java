import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumNumberOfArrowsToBurstBalloons

{

    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return 0;
        });


        int end=-1;

        int count=0;
        for (int[] interval : points) {
            if(end==-1){
                end=interval[1];
                count++;
            }
            if(end<=interval[1] && end>=interval[0]){
                continue;

            }
            count++;
            end=interval[1];

        }
        return count;
    }

    public static void main(String[] args) {
        MinimumNumberOfArrowsToBurstBalloons solution = new MinimumNumberOfArrowsToBurstBalloons();

        int[][] points1 = {{10,16}, {2,8}, {1,6}, {7,12}};
        int result1 = solution.findMinArrowShots(points1);
        System.out.println("Minimum arrows needed (Test 1): " + result1);

        int[][] points2 = {{1,2}, {3,4}, {5,6}, {7,8}};
        int result2 = solution.findMinArrowShots(points2);
        System.out.println("Minimum arrows needed (Test 2): " + result2);

        int[][] points3 = {{1,2}, {2,3}, {3,4}, {4,5}};
        int result3 = solution.findMinArrowShots(points3);
        System.out.println("Minimum arrows needed (Test 3): " + result3);
    }

}
