import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInStream {

    static class KthLargest {
        PriorityQueue<Integer> minHeap;
        PriorityQueue<Integer> maxHeap;
        int K;
        public KthLargest(int k, int[] nums) {
            minHeap= new PriorityQueue<>();
            maxHeap= new PriorityQueue<>(Collections.reverseOrder());
            K=k;
            for (int num : nums) {
                maxHeap.offer(num);

            }

                for (int i = 0; i < k; i++) {
                    if(!maxHeap.isEmpty()) {
                        int maxVal = maxHeap.poll();
                        minHeap.offer(maxVal);
                    }
                }

        }

        public int add(int val) {

            maxHeap.offer(val);
            int maxHeapVal=maxHeap.poll();
            minHeap.offer(maxHeapVal);
            while (minHeap.size()>K){

               int minHEapVal= minHeap.poll();
               maxHeap.offer(minHEapVal);

            }
            return minHeap.peek();
        }

    }
    public static void main(String[] args) {
        int k = 4;
        int[] nums = {7, 7, 7, 7, 8, 3};

        KthLargest kthLargest = new KthLargest(k, nums);
        System.out.println(kthLargest.add(2));   // expect 4
        System.out.println(kthLargest.add(10));   // expect 5
        System.out.println(kthLargest.add(9));  // expect 5
        System.out.println(kthLargest.add(9));   // expect 8

    }
}
