import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char t : tasks) freq[t - 'A']++;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) if (f > 0) maxHeap.offer(f);

        int intervals = 0;
        while (!maxHeap.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            // Try to fill up to n+1 slots this round
            for (int i = 0; i <= n; i++) {
                if (!maxHeap.isEmpty()) {
                    int cnt = maxHeap.poll();
                    if (--cnt > 0) temp.add(cnt);
                    intervals++;
                } else if (temp.isEmpty()) {
                    // No tasks left to schedule and no waiting tasks → we're done
                    break;
                } else {
                    // Idle slot
                    intervals++;
                }
            }
            // Push remaining counts back into heap
            for (int cnt : temp) maxHeap.offer(cnt);
        }
        return intervals;
    }


    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();

        // Example 1:
        char[] tasks1 = {'A','A','A','B','B','B'};
        int n1 = 2;
        System.out.println("Output 1: " + scheduler.leastInterval(tasks1, n1));  // Expected Output: 8

        // Example 2:
        char[] tasks2 = {'A','C','A','B','D','B'};
        int n2 = 1;
        System.out.println("Output 2: " + scheduler.leastInterval(tasks2, n2));  // Expected Output: 6

        // Example 3:
        char[] tasks3 = {'A','A','A','B','B','B'};
        int n3 = 3;
        System.out.println("Output 3: " + scheduler.leastInterval(tasks3, n3));  // Expected Output: 10
    }

}
