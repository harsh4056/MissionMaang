import java.util.*;
import java.util.Deque;
import java.util.HashSet;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack= new Stack<>();
        int n=heights.length;
        int[]nse= new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            nse[i]=stack.isEmpty()?n:stack.peek();
            stack.push(i);
        }
        stack.clear();
        int[]pse= new int[n];
        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                stack.pop();
            }
            pse[i]=stack.isEmpty()?-1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        int ans=0;
        for(int i=0;i<n;i++){
            int l=pse[i];
            int r=nse[i];
            ans=Math.max(ans,(r-l-1)*heights[i]);
        }
        return ans;


    }


    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        int[] heights1 = {7,1,7,2,2,4};
        System.out.println(solution.largestRectangleArea(heights1)); // Expected: 8

        int[] heights2 = {2,4};
        System.out.println(solution.largestRectangleArea(heights2)); // Expected: 4

        int[] heights3 = {6,2,5,4,5,1,6};
        System.out.println(solution.largestRectangleArea(heights3)); // Expected: 12
    }

}
