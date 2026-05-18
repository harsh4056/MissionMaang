import java.util.Stack;

public class SmallestStableIndex {

    public int firstStableIndex(int[] nums, int k) {
        Stack<Integer> stack= new Stack<>();
        for(int i=nums.length-1;i>=0;i--){
            if(stack.isEmpty() || nums[stack.peek()]>nums[i]){
                stack.push(i);
            }

        }
        int max=nums[0];

        for(int i=0;i<nums.length;i++){
            max=Math.max(max,nums[i]);
            int min=nums[stack.peek()];
            if(max-min<=k){
                return i;
            }
            while(!stack.isEmpty() && stack.peek()<=i){
                stack.pop();
            }

        }
        return -1;
    }
    public static void main(String[] args) {
        SmallestStableIndex sol = new SmallestStableIndex();

        int[] nums1 = {6,3,2,0,4,10,5};
        int k1 = 1;
        System.out.println(sol.firstStableIndex(nums1, k1)); // Expected: 3

        int[] nums2 = {3, 2, 1};
        int k2 = 1;
        System.out.println(sol.firstStableIndex(nums2, k2)); // Expected: -1

        int[] nums3 = {0};
        int k3 = 0;
        System.out.println(sol.firstStableIndex(nums3, k3)); // Expected: 0
    }
}
