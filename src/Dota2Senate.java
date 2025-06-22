import java.util.ArrayDeque;
import java.util.Queue;

public class Dota2Senate {

    public String predictPartyVictory(String senate) {
        char[] arr= senate.toCharArray();
        int n = senate.length();
        IntQueue queueR= new IntQueue(n);
        IntQueue queueD= new IntQueue(n);


        for (int i = 0; i < arr.length; i++) {
            char s = arr[i];
            if (s == 'D') {
                queueD.offer(i);
            }
            if (s == 'R') {
                queueR.offer(i);
            }
        }

        while(!queueR.isEmpty() && !queueD.isEmpty()){
            if(queueR.peek()<queueD.peek()){
                queueD.poll();
                queueR.offer((queueR.poll()+n));
            }
            else{
                queueR.poll();
                queueD.offer((queueD.poll()+n));
            }
        }

      return queueD.isEmpty()?"Radiant":"Dire";
    }



    public class IntQueue {

        private final int[] data;
        private int front = 0, rear = 0, size = 0;

        public IntQueue(int capacity) { data = new int[capacity]; }

        public void offer(int val) {
            if (size == data.length) throw new RuntimeException("Queue full");
            data[rear] = val;
            rear = (rear + 1) % data.length;
            size++;
        }

        public int poll() {
            if (isEmpty()) throw new RuntimeException("Queue empty");
            int val = data[front];
            front = (front + 1) % data.length;
            size--;
            return val;
        }

        public int peek() {
            if (isEmpty()) throw new RuntimeException("Queue empty");
            return data[front];
        }

        public boolean isEmpty() { return size == 0; }

        public int size() { return size; }
    }

    public static void main(String[] args) {
        Dota2Senate solution = new Dota2Senate();
        System.out.println(solution.predictPartyVictory("DRRDRDRDRDDRDRDR")); // Expected: "Radiant"

    }

}
