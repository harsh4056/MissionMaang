import java.util.Stack;

public class MinimumOperationsToConvertAllElementsToZero {
    public int minOperations(int[] nums) {
        IntStack stack = new IntStack(10000);
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                while (!stack.isEmpty()) {
                    stack.pop();
                    count++;
                }
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
                count++;
            }
            while (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();

            }
            stack.push(num);
        }
        return count + stack.size();
    }
    public class IntStack {


        private final int[] data;
        private int top = -1;
        public IntStack(int capacity) { data = new int[capacity]; }
        public void push(int c) { data[++top] = c; }
        public int pop()    { return data[top--]; }
        public int peek()    { return data[top]; }
        public boolean isEmpty() { return top == -1; }
        public int size() {return top + 1; }
    }

    public static void main(String[] args) {
        MinimumOperationsToConvertAllElementsToZero soln= new MinimumOperationsToConvertAllElementsToZero();
        System.out.println(soln.minOperations(new int[]{0,4,5,6,7,4,5,6,7,1}));
        System.out.println(soln.minOperations(new int[]{1,2,1,2,1,2}));
        System.out.println(soln.minOperations(new int[]{3,1,2,1}));
    }
}
