import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {


    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n=nums.length;
        int[]result= new int[n];
        for(int i=0;i<k;i++){

            while(!deque.isEmpty() &&nums[deque.peekLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        result[0]=nums[deque.peekFirst()];
        for(int i=k;i<n;i++){
            int till=i-k;
            while(!deque.isEmpty() &&deque.peekFirst()<=till){
                deque.removeFirst();
            }

            result[till+1]=(!deque.isEmpty())?nums[deque.peekLast()]:nums[i];
            while(!deque.isEmpty() &&nums[deque.peekFirst()]<nums[i]){
                deque.removeLast();
            }
            deque.add(i);

        }
        return result;
    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        int[] nums1 = {1,3,-1,-3,5,3,6,7};
        solution.maxSlidingWindow(nums1, 3); // Expected: [3,3,5,5,6,7]

        int[] nums2 = {9,10,9,-7,-4,-8,2,-6};
        solution.maxSlidingWindow(nums2, 5); // Expected: [10,10,9,2]

        int[] nums3 = {1,3,1,2,0,5};
        solution.maxSlidingWindow(nums3, 3); // Expected: [3,3,2,5]
    }



}
