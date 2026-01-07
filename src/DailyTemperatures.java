import java.util.*;

public class DailyTemperatures {


    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] arr= new int[n];
        Stack<Integer> stack= new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() &&
                    temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            arr[i]=stack.isEmpty()?0:stack.peek()-i;
            stack.push(i);

        }
        return arr;
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
    public static void main(String[] args) {
        DailyTemperatures solution = new DailyTemperatures();

        int[] temps1 = {89,62,70,58,47,47,46,76,100,70};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temps1))); // Expected: [8,1,5,4,3,2,1,1,0,0]

        int[] temps2 = {30, 40, 50, 60};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temps2))); // Expected: [1,1,1,0]

        int[] temps3 = {90, 80, 70, 60};
        System.out.println(Arrays.toString(solution.dailyTemperatures(temps3))); // Expected: [0,0,0,0]
    }

}
