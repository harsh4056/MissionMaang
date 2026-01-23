import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

    static class KthLargest {
        PriorityQueue<Integer> minHeap;
        int k;
        public KthLargest(int k, int[] nums) {
            minHeap= new PriorityQueue<>();
            for(int num:nums){
                minHeap.offer(num);
            }
            while(minHeap.size()>k){
                minHeap.poll();
            }
            if(minHeap.isEmpty()){
                minHeap.offer(-1001);
            }
            this.k=k;
        }

        public int add(int val) {
            if(minHeap.size()<k){
                minHeap.offer(val);
                return minHeap.peek();
            }
            else if(minHeap.peek()<=val){
                minHeap.offer(val);
                minHeap.poll();
            }
            return minHeap.peek();
        }
    }
    public static void main(String[] args) {
        int k = 3;
        int[] nums = {1000, -1000};

        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println("null");                 // expected: null
        System.out.println(kthLargest.add(0));      // expected: -1000
        System.out.println(kthLargest.add(2));      // expected: 0
        System.out.println(kthLargest.add(-3));     // expected: 0
        System.out.println(kthLargest.add(1000));   // expected: 2
    }

}
