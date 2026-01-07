import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {


    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deque= new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
        }
        int []ans= new int[nums.length-k+1];
        ans[0]=nums[deque.getFirst()];
        for(int i=k;i< nums.length;i++){
            int initial=i-k;
            while (!deque.isEmpty() && deque.getFirst()<=initial) {
                deque.removeFirst();
            }
            while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(i);
            ans[initial+1]=nums[deque.getFirst()];
        }
        return ans;

    }

    public static void main(String[] args) {
        SlidingWindowMaximum solution = new SlidingWindowMaximum();

        int[] nums0 = {1, -1};
        int[] result0 = solution.maxSlidingWindow(nums0, 1);
        System.out.println(java.util.Arrays.toString(result0));

        int[] nums1 = {1, 3, -1, -3, 5, 3, 6, 7};
        int[] result1 = solution.maxSlidingWindow(nums1, 3);
        System.out.println(java.util.Arrays.toString(result1));
        // Expected: [3, 3, 5, 5, 6, 7]

        int[] nums2 = {9, 10, 9, -7, -4, -8, 2, -6};
        int[] result2 = solution.maxSlidingWindow(nums2, 5);
        System.out.println(java.util.Arrays.toString(result2));
        // Expected: [10, 10, 9, 2]

        int[] nums3 = {1, 3, 1, 2, 0, 5};
        int[] result3 = solution.maxSlidingWindow(nums3, 3);
        System.out.println(java.util.Arrays.toString(result3));
        // Expected: [3, 3, 2, 5]
    }



}
