import java.util.Arrays;
import java.util.Comparator;

public class MaximumNumberOfEventsThatCanBeAttended {
    public int maxEvents(int[][] events) {

        int count=0;
        int last=-1;
        int n=events.length;
        int[]start= new int[n];
        int[]end= new int[n];
        for (int i = 0; i < end.length; i++) {
            start[i]=events[i][0];
            end[i]=events[i][1];

        }
        Arrays.sort(start);
        Arrays.sort(end);
        for (int i = 0; i < n; i++) {
            if(last+1>=start[i] && last+1<=end[i]){
                last++;
                count++;
            }
            else{
                if(last+1<start[i]){
                    last=start[i];
                    count++;
                }
            }

        }
        return count;

    }

    public static void main(String[] args) {

        MaximumNumberOfEventsThatCanBeAttended solution =
                new MaximumNumberOfEventsThatCanBeAttended();

        // Test case 3
        int[][] events3 = {
                {1, 5},
                {1, 5},
                {1, 5},
                {2, 3},
                {2, 3}
        };
        System.out.println(solution.maxEvents(events3));
        // Expected output: 1 (only one event can be attended)

        // Test case 1
        int[][] events1 = {
                {1, 2},
                {1, 2},
                {1, 2}
        };
        System.out.println(solution.maxEvents(events1));
        // Expected output: 2 (attend  events on days 1,2)

        // Test case 2
        int[][] events2 = {
                {1, 2},
                {1, 2},
                {3, 3},
                {1, 5}
        };
        System.out.println(solution.maxEvents(events2));
        // Expected output: 4 (one per day: 1,2,3,4)


    }



}
