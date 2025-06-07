import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> maxHeap= new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();
        for (int i = 0; i < nums.length-k; i++) {
            int num = nums[i];
            maxHeap.offer(num);
        }
        for (int i = nums.length-k; i < nums.length; i++) {
            maxHeap.offer(nums[i]);
            int max=maxHeap.poll();
            minHeap.offer(max);
        }

        return minHeap.peek();

    }


    public static void runTest(int[] nums, int k) {
        KthLargestElementInArray obj = new KthLargestElementInArray();
        int result = obj.findKthLargest(nums, k);
        System.out.println("Input: " + Arrays.toString(nums) + ", k = " + k);
        System.out.println("Kth Largest: " + result);
        System.out.println();
    }

    public static void main(String[] args) {
        // Test Case 1
        runTest(new int[]{2,1,3}, 3);

        // Test Case 2
        runTest(new int[]{3,2,3,1,2,4,5,5,6}, 4);

        // Test Case 3
        runTest(new int[]{1}, 1);
    }
}
