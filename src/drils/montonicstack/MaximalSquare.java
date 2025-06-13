package drils.montonicstack;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalSquare {





    public int maximalSquare(int[] heights) {
        int n = heights.length;
        int[] prevSmaller = new int[n], nextSmaller = new int[n];
        Deque<Integer> st = new ArrayDeque<>();

        // compute prevSmaller: index of first strictly smaller bar to the left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            prevSmaller[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // compute nextSmaller: index of first strictly smaller bar to the right
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            nextSmaller[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // compute max area
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nextSmaller[i] - prevSmaller[i] - 1;

            int side = Math.min(heights[i],width);
            int area=side*side;
            if (area > maxArea) maxArea = area;
        }
        return maxArea;
    }
    public static void main(String[] args) {
        MaximalSquare sd = new MaximalSquare();

        System.out.println(sd.maximalSquare(new int[]{2, 1, 5, 6, 2, 3}));
        // Expected: 4

        System.out.println(sd.maximalSquare(new int[]{1, 1, 1, 1}));
        // Expected: 1

        System.out.println(sd.maximalSquare(new int[]{5, 4, 3, 2, 1}));
        // Expected: 9
    }

}
