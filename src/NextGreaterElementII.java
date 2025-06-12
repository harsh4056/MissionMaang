import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {


    public int[] nextGreaterElements(int[] nums) {

        int k=nums.length;
        IntStack stack= new IntStack(k);
        int maxIndex= 0;
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            if(nums[i]>nums[maxIndex]){
                maxIndex=i;
            }
        }
        int []answer= new int[k];
        int index=maxIndex;

        while(answer[index]!=-1){

            while (!stack.isEmpty() && stack.peek()<=nums[index]){
                stack.pop();
            }
            if(stack.isEmpty()){
                answer[index]=-1;
            }
            else{
                answer[index]= stack.peek();
            }

            stack.push(nums[index]);


            index= (((index-1)%k)+k)%k;
        }
        return answer;

    }

    public class IntStack {


        private final int[] data;
        private int top = -1;
        public IntStack(int capacity) { data = new int[capacity]; }
        public void push(int c) { data[++top] = c; }
        public int pop()    { return data[top--]; }
        public int peek()    {
            if(top == -1){
                return -1;
            }
            return data[top]; }
        public boolean isEmpty() { return top == -1; }
    }

    public int[] nextGreaterElements2(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1); // Default to -1
        Stack<Integer> stack = new Stack<>(); // stores indices

        // We go through the array twice (circular behavior)
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                res[stack.pop()] = num;
            }
            if (i < n) {
                stack.push(i); // Only push indices from first pass
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NextGreaterElementII solution = new NextGreaterElementII();

        int[] result1 = solution.nextGreaterElements(new int[]{1, 2, 1});
        System.out.println(Arrays.toString(result1)); // Expected: [2, -1, 2]

        int[] result2 = solution.nextGreaterElements(new int[]{1, 2, 3, 4, 3});
        System.out.println(Arrays.toString(result2)); // Expected: [2, 3, 4, -1, 4]

        int[] result3 = solution.nextGreaterElements(new int[]{5, 4, 3, 2, 1});
        System.out.println(Arrays.toString(result3)); // Expected: [-1, 5, 5, 5, 5]

        int[] result4 = solution.nextGreaterElements2(new int[]{1, 1, 1, 1, 1, 4, 1, 1, 1});
        System.out.println(Arrays.toString(result4)); // Expected: [4, 4, 4, 4, 4, -1, 4, 4, 4]
    }

}
