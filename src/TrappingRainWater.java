import java.util.ArrayDeque;
import java.util.Deque;

public class TrappingRainWater {

    public int trap(int[] height) {
        int n= height.length;
        int[]leftMax=new int[n];
        int[]rightMax=new int[n];
        Deque<Integer> stack= new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek()<=height[i]){
                stack.pop();
            }
            leftMax[i]=stack.isEmpty()?-1:stack.peek();
            if(!stack.isEmpty() &&height[i]>=stack.peek()) {
                stack.push(height[i]);
            }

            else if(stack.isEmpty()){
                stack.push(height[i]);
            }
        }
            stack.clear();

        for (int i = n-1; i >=0; i--) {
            while (!stack.isEmpty() && stack.peek()<=height[i]){
                stack.pop();
            }
            rightMax[i]=stack.isEmpty()?-1:stack.peek();
            if(!stack.isEmpty() &&height[i]>=stack.peek()) {
                stack.push(height[i]);
            }

            else if(stack.isEmpty()){
                stack.push(height[i]);
            }
        }
        int sum=0;
        for (int i = 0; i < n; i++) {
            int left  =leftMax[i];
            int right =rightMax[i];
            if (left != -1 && right != -1) {
                sum+=(Math.min(left,right))-height[i];
            }
        }
        return sum;

    }
    public static void main(String[] args) {
        TrappingRainWater tr = new TrappingRainWater();

        System.out.println(tr.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        // Expected: 6

        System.out.println(tr.trap(new int[]{4,2,0,3,2,5}));
        // Expected: 9

        System.out.println(tr.trap(new int[]{1,0,2}));
        // Expected: 1
    }

    public int trap2(int[] height) {
        int[]leftMax=new int[height.length];
        int[]rightMax=new int[height.length];
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        int water=0;
        for (int i = 0; i < height.length; i++) {
            water += Math.min(leftMax[i], rightMax[i]) - height[i];

        }
        return water;

    }

}
