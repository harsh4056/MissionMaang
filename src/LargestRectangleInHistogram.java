import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
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

            int area = heights[i] * width;
            if (area > maxArea) maxArea = area;
        }
        return maxArea;
    }
    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        int[] heights1 = {1, 1, 1, 1};
        System.out.println(solution.largestRectangleArea(heights1)); // Expected: 12

        int[] heights2 = {2,4};
        System.out.println(solution.largestRectangleArea(heights2)); // Expected: 4

        int[] heights3 = {6,2,5,4,5,1,6};
        System.out.println(solution.largestRectangleArea(heights3)); // Expected: 12
    }

}
