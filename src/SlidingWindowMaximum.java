import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SlidingWindowMaximum {


    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<int[]> deque= new ArrayDeque<>();

        int[]ans= new int[nums.length-k+1];
        int count=0;
        for (int i = 0; i < k; i++) {
            if(deque.isEmpty()){
                deque.addLast(new int[]{nums[i],i});
            }
            while(!deque.isEmpty() && deque.getLast()[0]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(new int[]{nums[i],i});
        }
        ans[count++]=(deque.getFirst()[0]);

        for (int i = k; i <nums.length ; i++) {
            while(!deque.isEmpty() && deque.getLast()[0]<nums[i]){
                deque.removeLast();
            }
            deque.addLast(new int[]{nums[i],i});
            while(!deque.isEmpty() && deque.getFirst()[1]<=i-k){
                deque.removeFirst();
            }

            ans[count++]=(deque.getFirst()[0]);
        }

        return ans;


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
