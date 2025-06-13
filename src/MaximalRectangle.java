import java.util.ArrayDeque;
import java.util.Deque;

public class MaximalRectangle {



    public int maximalRectangle(char[][] matrix) {
        int[] heights= new int[matrix[0].length];
        int maxArea = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') heights[j]++;
                else  heights[j] = 0;

            }

            int n = heights.length;
            int[] prevSmaller = new int[n], nextSmaller = new int[n];
            Deque<Integer> st = new ArrayDeque<>();

            // compute prevSmaller: index of first strictly smaller bar to the left
            for (int k = 0; k < n; k++) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[k]) {
                    st.pop();
                }
                prevSmaller[k] = st.isEmpty() ? -1 : st.peek();
                st.push(k);
            }

            // compute nextSmaller: index of first strictly smaller bar to the right
            st.clear();
            for (int k = n - 1; k >= 0; k--) {
                while (!st.isEmpty() && heights[st.peek()] >= heights[k]) {
                    st.pop();
                }
                nextSmaller[k] = st.isEmpty() ? n : st.peek();
                st.push(k);
            }

            // compute max area

            for (int k = 0; k < n; k++) {
                int width = nextSmaller[k] - prevSmaller[k] - 1;

                int area = heights[k] * width;
                if (area > maxArea) maxArea = area;
            }
        }

        return maxArea;
    }


    public static void main(String[] args) {
        MaximalRectangle mr = new MaximalRectangle();
        char[][] matrix1 = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(mr.maximalRectangle(matrix1));
        // Expected: 6
        char[][] matrix2 = {
                {'0','0','0'},
                {'0','0','0'}
        };
        System.out.println(mr.maximalRectangle(matrix2));
        // Expected: 0

        char[][] matrix3 = {
                {'1'}
        };
        System.out.println(mr.maximalRectangle(matrix3));
        // Expected: 1
    }

}
