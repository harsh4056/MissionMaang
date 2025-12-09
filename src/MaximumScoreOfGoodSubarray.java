import java.util.*;

public class MaximumScoreOfGoodSubarray {

    public int maximumScore(int[] nums, int k) {
        int n=nums.length;
        int[]nse= new int[n];
        int[]pse= new int[n];
        IntStack stack= new IntStack(n);
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && nums[stack.peek()]>nums[i]){
                stack.pop();
            }
            pse[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && nums[stack.peek()]>=nums[i]){
                stack.pop();
            }
            nse[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        stack.clear();
        int max=0;
        for (int i = 0; i < n; i++) {
            int val=nums[i];
            int l=pse[i];
            int r=nse[i];
            if(l<k && k<r){
                max=Math.max(max,val*(r-l-1));
            }
        }
        return max;
    }


    public static void main(String[] args) {
        MaximumScoreOfGoodSubarray soln= new MaximumScoreOfGoodSubarray();
        System.out.println(soln.maximumScore(new int[]{1,4,3,7,4,5},3));
        System.out.println(soln.maximumScore(new int[]{5,5,4,5,4,1,1,1},0));
    }
    public class IntStack {


        private  int[] data;
        private final int capacity;
        private int top = -1;
        public IntStack(int capacity) {
            this.capacity=capacity;
            data = new int[capacity];
        }
        public void clear(){data = new int[capacity];}
        public void push(int c) { data[++top] = c; }
        public int pop()    { return data[top--]; }
        public int peek()    { return data[top]; }
        public boolean isEmpty() { return top == -1; }
        public int size() {return top + 1; }
    }
}
