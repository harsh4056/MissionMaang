import java.util.*;

public class IPO {



    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {



        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // now max heap
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));  // now max heap


        // Push the first k pairs (nums1[i], nums2[0]) into the heap
        for (int i = 0; i < profits.length; i++) {
            minHeap.offer(new int[]{capital[i] , i});
        }
            while(k-->0) {
                while (!minHeap.isEmpty() && minHeap.peek()[0] <= w) {
                    int[] minCapital = minHeap.poll();
                    maxHeap.offer(profits[minCapital[1]]);
                }
                if (maxHeap.isEmpty()) break;
                w=w+maxHeap.poll();
            }

        return w;
    }

    public static void main(String[] args) {
        IPO ipo = new IPO();

        // Test Case 1
        int k1 = 2;
        int w1 = 0;
        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0,1,1};
        int result1 = ipo.findMaximizedCapital(k1, w1, profits1, capital1);
        System.out.println("Test Case 1 Output: " + result1);

        // Test Case 2
        int k2 = 3;
        int w2 = 0;
        int[] profits2 = {1, 2, 3};
        int[] capital2 = {0, 1, 2};
        int result2 = ipo.findMaximizedCapital(k2, w2, profits2, capital2);
        System.out.println("Test Case 2 Output: " + result2);

        // Test Case 3
        int k3 = 1;
        int w3 = 1;
        int[] profits3 = {2, 3, 1};
        int[] capital3 = {1, 2, 0};
        int result3 = ipo.findMaximizedCapital(k3, w3, profits3, capital3);
        System.out.println("Test Case 3 Output: " + result3);
    }

}
