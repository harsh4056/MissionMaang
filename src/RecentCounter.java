import java.util.ArrayDeque;
import java.util.Queue;

class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
    queue= new ArrayDeque<>();
    }

    public int ping(int t) {
        queue.offer(t);
        while(!queue.isEmpty() &&queue.peek()<t-3000){
            queue.poll();
        }
        if(!queue.isEmpty())
            return queue.peek();
        return 0;
    }
}