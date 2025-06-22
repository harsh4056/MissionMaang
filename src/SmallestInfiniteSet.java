import java.util.HashSet;
import java.util.PriorityQueue;

class SmallestInfiniteSet {
    PriorityQueue<Integer> minHeap;
    HashSet<Integer> set;
    int counter=1;
    public SmallestInfiniteSet() {
        minHeap= new PriorityQueue<>();
        set= new HashSet<>();
    }

    public int popSmallest() {
        if(!minHeap.isEmpty()){
            int val = minHeap.poll();
            set.remove(val);
            return val;
        }
        else{
            return counter++;
        }

    }

    public void addBack(int num) {
        if(counter>num && !minHeap.contains(num)){
            minHeap.add(num);
            set.add(num);
        }

    }
    public static void main(String[] args) {
        SmallestInfiniteSet solution = new SmallestInfiniteSet();

        solution.addBack(2);                        // null
        System.out.println(solution.popSmallest()); // 1
        System.out.println(solution.popSmallest()); // 2
        System.out.println(solution.popSmallest()); // 3
        solution.addBack(1);                        // null
        System.out.println(solution.popSmallest()); // 1
        System.out.println(solution.popSmallest()); // 4
        System.out.println(solution.popSmallest()); // 5
    }


}