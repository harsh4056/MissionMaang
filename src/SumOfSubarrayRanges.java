import java.util.Stack;

public class SumOfSubarrayRanges {
    public long subArrayRanges(int[] nums) {
        IntStack stack= new IntStack(1000);
        int n= nums.length;
        int []nse= new int[n];
        int []pse= new int[n];
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]>num){
                stack.pop();
            }
            pse[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n-1; i >=0; i--) {
            int num = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]>=num){
                stack.pop();
            }
            nse[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        long min=0;
        int[] nge= new int[n];
        int[] pge= new int[n];
        stack.clear();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]<=num){
                stack.pop();
            }
            pge[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for (int i = n-1; i >=0; i--) {
            int num = nums[i];
            while(!stack.isEmpty() && nums[stack.peek()]<num){
                stack.pop();
            }
            nge[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        long max=0;
        for (int i = 0; i < pse.length; i++) {
            int left=i-pge[i];
            int right=nge[i]-i;
            max+=((long) nums[i] *left*right);
             left=i-pse[i];
             right=nse[i]-i;
            min+=((long) nums[i] *left*right);

        }

        return max-min;
    }

    public class IntStack {


        private  int[] data;
        private final int capacity;
        private int top = -1;
        public IntStack(int capacity) {
            this.capacity=capacity;
            data = new int[capacity];
        }
        public void clear() {top = -1;}

        public void push(int c) { data[++top] = c; }
        public int pop()    { return data[top--]; }
        public int peek()    { return data[top]; }
        public boolean isEmpty() { return top == -1; }
        public int size() {return top + 1; }
    }

    public static void main(String[] args) {
        SumOfSubarrayRanges soln= new SumOfSubarrayRanges();
        System.out.println(soln.subArrayRanges(new int[]{4,-2,-3,4,1}));
    }
}
