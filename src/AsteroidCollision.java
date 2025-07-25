import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int index=0;
        while (index<asteroids.length){

            if(stack.isEmpty() ){
                stack.push(asteroids[index++]);
            }
            else{
                if(stack.peek()>0 && asteroids[index]<0) {
                    if (stack.peek() == Math.abs(asteroids[index])) {
                        stack.pop();
                        index++;
                    } else if (stack.peek() < Math.abs(asteroids[index])) {
                        stack.pop();
                    } else if (stack.peek() > Math.abs(asteroids[index])) {
                        index++;
                    }
                }
                else{
                    stack.push(asteroids[index++]);
                }
            }



        }
        int[] arr = stack.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return arr;

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
        AsteroidCollision obj = new AsteroidCollision();


        int[] result0 = obj.asteroidCollision(new int[]{ 1,-1,1,-2});
        System.out.println(java.util.Arrays.toString(result0)); //  [-2]
        int[] result1 = obj.asteroidCollision(new int[]{5, 10, -5});
        System.out.println(java.util.Arrays.toString(result1)); // Expected: [5, 10]

        int[] result2 = obj.asteroidCollision(new int[]{8, -8});
        System.out.println(java.util.Arrays.toString(result2)); // Expected: []

        int[] result3 = obj.asteroidCollision(new int[]{10, 2, -5});
        System.out.println(java.util.Arrays.toString(result3)); // Expected: [10]
    }

}
