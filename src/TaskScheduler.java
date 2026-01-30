import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[]freq= new int[26];
        for (char task : tasks) {
            freq[task-'A']++;
        }
        PriorityQueue<Integer> minHeap= new PriorityQueue<>((a,b)->{
            return b-a;
        });
        for (int ints : freq) {
            if(ints>0) {
                minHeap.offer(ints);
            }
        }
        int t=0;
        Queue<int[]> queue= new LinkedList<>();
        while (!queue.isEmpty()||!minHeap.isEmpty()){
            if(!minHeap.isEmpty()){
                int curr=minHeap.poll();
                curr--;
                if(curr>0)
                 queue.offer(new int[]{curr,t+n});
            }
            if (!queue.isEmpty() && queue.peek()[1]==t){
                minHeap.offer(queue.poll()[0]);

            }
            t++;
        }
        return t;
    }



    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();


        // Example 3:
        char[] tasks3 = {'A','A','A','B','B','B'};
        int n3 = 3;
        System.out.println("Output 3: " + scheduler.leastInterval(tasks3, n3));  // Expected Output: 10

        // Example 1:
        char[] tasks1 = {'A','A','A','B','B','B'};
        int n1 = 2;
        System.out.println("Output 1: " + scheduler.leastInterval(tasks1, n1));  // Expected Output: 8

        // Example 2:
        char[] tasks2 = {'A','C','A','B','D','B'};
        int n2 = 1;
        System.out.println("Output 2: " + scheduler.leastInterval(tasks2, n2));  // Expected Output: 6

    }

}
