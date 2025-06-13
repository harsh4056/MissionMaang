package drils.montonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class StackDrills {


    int[] nextSmaller(int[] heights) {
        Deque<Integer> stack= new ArrayDeque<>();
        int n=heights.length;
        int[]nextSmaller= new int[n];
        for (int i = n-1; i >=0 ; i--) {
            while (!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            nextSmaller[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return nextSmaller;
    }
    int[] previousGreater(int[] heights) {
        Deque<Integer> stack= new ArrayDeque<>();
        int n=heights.length;
        int[]previousGreater= new int[n];
        for (int i = 0; i <n ; i++) {
            while (!stack.isEmpty() && heights[stack.peek()]<=heights[i]){
                stack.pop();
            }
            previousGreater[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        return previousGreater;
    }


    public static void main(String[] args) {
        StackDrills sd = new StackDrills();


        System.out.println(java.util.Arrays.toString(
                sd.previousGreater(new int[]{2, 4, 1, 5, 3})
        ));
        // Expected: [5, 5, 1, 5, 3]

        System.out.println(java.util.Arrays.toString(
                sd.previousGreater(new int[]{1, 1, 1, 1})
        ));
        // Expected: [4, 4, 4, 4]

        System.out.println(java.util.Arrays.toString(
                sd.previousGreater(new int[]{5, 4, 3, 2, 1})
        ));
        // Expected: [5, 0, 1, 2, 3]








        System.out.println(java.util.Arrays.toString(sd.nextSmaller(new int[]{2, 1, 5, 6, 2, 3})));
        // Expected: [1, 6, 4, 4, 6, 6]

        System.out.println(java.util.Arrays.toString(sd.nextSmaller(new int[]{1, 1, 1, 1})));
        // Expected: [4, 4, 4, 4]

        System.out.println(java.util.Arrays.toString(sd.nextSmaller(new int[]{5, 4, 3, 2, 1})));
        // Expected: [1, 2, 3, 4, 5]

        System.out.println(java.util.Arrays.toString(sd.previousGreater(new int[]{5, 4, 3, 2, 1})));
        // Expected: [1, 2, 3, 4, 5]
    }

}
