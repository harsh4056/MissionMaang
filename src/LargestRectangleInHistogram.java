import java.util.*;
import java.util.Deque;
import java.util.HashSet;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack= new Stack<>();
        int n= heights.length;
        int maxi=-1;
        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];
            while (!stack.isEmpty() && heights[stack.peek()]>height){
                int curr=stack.pop();
                int pse=stack.isEmpty()?-1:stack.peek();
                int nse=i;
                int area= heights[curr]*(nse-pse-1);
                maxi=Math.max(maxi,area);
            }
            stack.push(i);
        }

        while (!stack.isEmpty() ){
            int curr=stack.pop();
            int pse=stack.isEmpty()?-1:stack.peek();
            int nse=n;
            int area= heights[curr]*(nse-pse-1);
            maxi=Math.max(maxi,area);
        }
        return maxi;


    }
    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        int[] heights1 = {7,1,7,2,2,4};
        System.out.println(solution.largestRectangleArea(heights1)); // Expected: 12

        int[] heights2 = {2,4};
        System.out.println(solution.largestRectangleArea(heights2)); // Expected: 4

        int[] heights3 = {6,2,5,4,5,1,6};
        System.out.println(solution.largestRectangleArea(heights3)); // Expected: 12
    }

}
