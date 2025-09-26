import java.util.*;

public class MinimumTimeToFillCups {
    public int fillCups(int[] amount) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        if(amount[0]>0)
            maxHeap.offer(amount[0]);
        if(amount[1]>0)
            maxHeap.offer(amount[1]);
        if(amount[2]>0)
            maxHeap.offer(amount[2]);
        int count = 0;
        while (!maxHeap.isEmpty()) {
            int a = maxHeap.poll();
            int b=0;

            if (!maxHeap.isEmpty()) {
                b = maxHeap.poll();

            }
            a--;
            count++;
            if (a > 0){
                maxHeap.offer(a);
            }
            b--;
            if (b > 0)
                maxHeap.offer(b);
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumTimeToFillCups soln= new MinimumTimeToFillCups();
        System.out.println(soln.fillCups(new int[]{5,4,4}));
    }
}
