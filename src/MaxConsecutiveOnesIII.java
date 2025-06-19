import java.util.ArrayDeque;
import java.util.Queue;

public class MaxConsecutiveOnesIII {


    public int longestOnes(int[] nums, int k) {

        Queue<Integer> queue= new ArrayDeque<>();
            int max=0;
            int count=0;
            queue.offer(0);
        for (int i = 0; i < nums.length; i++) {
            if(k>0 &&nums[i]==0){
                queue.offer(i);
                k--;
            }
            else if(k<=0 &&nums[i]==0){
                if(queue.size()>=2) {
                    int prevIndex = queue.poll();
                    int index = queue.peek();
                    count = count - (index - prevIndex);
                }
                queue.offer(i);
            }
            count++;
            max=Math.max(max,count);
        }

        return max;
    }


    public int longestOnes2(int[] nums, int k) {
        int left = 0, max = 0, zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) zeroCount++;

            while (zeroCount > k) {
                if (nums[left] == 0) zeroCount--;
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnesIII solution = new MaxConsecutiveOnesIII();

        int[] nums1 = {1,1,1,0,0,0,1,1,1,1,0};
        int k1 = 2;
        System.out.println(solution.longestOnes(nums1, k1)); // Expected: 6

        int[] nums2 = {0,0,1,1,1,0,0};
        int k2 = 0;
        System.out.println(solution.longestOnes(nums2, k2)); // Expected: 3

        int[] nums3 = {1,1,0,0,1,1,1,0,1};
        int k3 = 2;
        System.out.println(solution.longestOnes(nums3, k3)); // Expected: 8
    }

}
