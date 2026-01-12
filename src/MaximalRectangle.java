import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class MaximalRectangle {





    public int maximalRectangle(char[][] matrix) {
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxi = -1;
        for (int i = 0; i < matrix.length; i++) {
            if (i == 0) {
                for (int j = 0; j < n; j++) {
                    heights[j] = matrix[i][j] - '0';
                }
            } else {
                for (int j = 0; j < n; j++) {
                    int curr = matrix[i][j] - '0';
                    if (heights[j] >= 1 && curr == 1) {
                        heights[j]++;
                    } else {
                        heights[j] = curr;
                    }

                }

            }
            int h = largestRectangleArea(heights);
            maxi = Math.max(maxi, h);
        }
        return maxi;

    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int n = heights.length;
        int maxi = -1;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()] > height) {
                int curr = stack.pop();
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int nse = i;
                int area = heights[curr] * (nse - pse - 1);
                maxi = Math.max(maxi, area);
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int curr = stack.pop();
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int nse = n;
            int area = heights[curr] * (nse - pse - 1);
            maxi = Math.max(maxi, area);
        }
        return maxi;
    }


    public static void main(String[] args) {
        MaximalRectangle mr = new MaximalRectangle();


        char[][] matrix3 = {
                {'1'}
        };
        System.out.println(mr.maximalRectangle(matrix3));
        // Expected: 1

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

    }

}
