import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertIntervals {
/*
* [2,4],[5,8]  [3,4]
* */
public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> result = new ArrayList<>();
    int i = 0;
    int n = intervals.length;

        // Step 1: Add intervals that come before newInterval
    while (i < n && intervals[i][1] < newInterval[0]) {
        result.add(intervals[i]);
        i++;
    }

        // Step 2: Merge overlapping intervals
    int mergeStart = newInterval[0];
    int mergeEnd = newInterval[1];
    while (i < n && intervals[i][0] <= mergeEnd) {
        mergeStart = Math.min(mergeStart, intervals[i][0]);
        mergeEnd = Math.max(mergeEnd, intervals[i][1]);
        i++;
    }
    result.add(new int[]{mergeStart, mergeEnd});

        // Step 3: Add remaining intervals
    while (i < n) {
        result.add(intervals[i]);
        i++;
    }
    return result.toArray(new int[result.size()][]);

}
    public static void main(String[] args) {
        InsertIntervals insertIntervals = new InsertIntervals();

        // Test Case 1: Simple overlap
        insertIntervals.insert(new int[][]{{1, 3}, {6, 9},{14,15}}, new int[]{2, 5});

        // Test Case 2: Overlapping multiple intervals
        insertIntervals.insert(new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}}, new int[]{4, 8});

        // Test Case 3: No overlap, insert at beginning
        insertIntervals.insert(new int[][]{{5, 7}, {8, 10}}, new int[]{1, 3});

        // Test Case 4: No overlap, insert at end
        insertIntervals.insert(new int[][]{{1, 2}, {3, 5}}, new int[]{6, 8});

        // Test Case 5: Full overlap with all intervals
        insertIntervals.insert(new int[][]{{2, 3}, {4, 5}, {6, 7}}, new int[]{1, 8});

        // Test Case 6: Insert into empty intervals
        insertIntervals.insert(new int[][]{}, new int[]{4, 8});

        // Test Case 7: Insert in between with no overlap
        insertIntervals.insert(new int[][]{{1, 2}, {5, 6}}, new int[]{3, 4});
    }

}
