public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        IntStack stack = new IntStack(asteroids.length);

        for (int asteroid : asteroids) {
            if (stack.isEmpty() || asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0) {
                    int top = stack.peek();
                    if (top < -asteroid) {
                        stack.pop(); // right asteroid smaller, explode it
                    } else if (top == -asteroid) {
                        stack.pop(); // both explode
                        asteroid = 0;
                        break;
                    } else {
                        asteroid = 0; // left asteroid destroyed
                        break;
                    }
                }
                if (asteroid != 0) {
                    stack.push(asteroid);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;
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


        int[] result0 = obj.asteroidCollision(new int[]{ -2,2,1,-2});
        System.out.println(java.util.Arrays.toString(result0)); //  [-2,2,1,-2]
        int[] result1 = obj.asteroidCollision(new int[]{5, 10, -5});
        System.out.println(java.util.Arrays.toString(result1)); // Expected: [5, 10]

        int[] result2 = obj.asteroidCollision(new int[]{8, -8});
        System.out.println(java.util.Arrays.toString(result2)); // Expected: []

        int[] result3 = obj.asteroidCollision(new int[]{10, 2, -5});
        System.out.println(java.util.Arrays.toString(result3)); // Expected: [10]
    }

}
