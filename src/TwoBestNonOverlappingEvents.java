import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TwoBestNonOverlappingEvents {

    int[][] dp;
    int[] next;
    int[][] events;

    public int maxTwoEvents(int[][] events) {
        this.events = events;
        int n = events.length;

        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        next = new int[n];
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) starts[i] = events[i][0];

        // FIX: proper lower_bound
        for (int i = 0; i < n; i++) {
            next[i] = lowerBound(starts, events[i][1] + 1);
        }

        dp = new int[n][3];
        for (int[] row : dp) Arrays.fill(row, -1);

        return solve(0, 0);
    }

    private int solve(int index, int count) {
        if (index == events.length || count == 2) return 0;
        if (dp[index][count] != -1) return dp[index][count];

        int skip = solve(index + 1, count);
        int take = events[index][2] + solve(next[index], count + 1);

        return dp[index][count] = Math.max(skip, take);
    }

    // first index with start >= target
    private int lowerBound(int[] arr, int target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    public int maxTwoEvents2(int[][] events) {
        int n = events.length;
        int maxi=-1;

        PriorityQueue<int[]> minHeap= new PriorityQueue<>((a,b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for (int[] event : events) {
            minHeap.offer(new int[]{event[0],0,event[2]});
            minHeap.offer(new int[]{event[1],1,event[2]});
        }
        int last=0;
        while (!minHeap.isEmpty()){
            int[]curr= minHeap.poll();
            int time=curr[0];
            int type=curr[1];
            int value=curr[2];

            if(type==1){
                last=Math.max(last,value);
            }
            else {
                maxi = Math.max(last + value, maxi);
            }
        }
        return maxi;
    }

    public static void main(String[] args) {

        TwoBestNonOverlappingEvents solution = new TwoBestNonOverlappingEvents();
        // Example 4
        int[][] events4 = {
                {1, 1, 5},
                {3, 4, 1},
                {2, 4, 5},
                {2, 5, 3},
                {2, 3, 4}
        };
        System.out.println(solution.maxTwoEvents2(events4));
        // Expected output: 10
        // Example 1
        int[][] events1 = {
                {1, 3, 2},
                {4, 5, 2},
                {2, 4, 3}
        };
        System.out.println(solution.maxTwoEvents2(events1));
        // Expected output: 4

        // Example 2
        int[][] events2 = {
                {1, 3, 2},
                {4, 5, 2},
                {1, 5, 5}
        };
        System.out.println(solution.maxTwoEvents2(events2));
        // Expected output: 5

        // Example 3
        int[][] events3 = {
                {1, 5, 3},
                {1, 5, 1},
                {6, 6, 5}
        };
        System.out.println(solution.maxTwoEvents2(events3));
        // Expected output: 8



    }


}
