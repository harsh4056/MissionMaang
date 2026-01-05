
import java.util.*;

public class TrappingRainWater {

    public int trap(int[] height) {
        int n=height.length;


        Stack<Integer> stack= new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()|| height[stack.peek()]<height[i])
                stack.push(i);
        }
        int ans=0;
        int maxHeight=-1;
        for(int i=0;i<n;i++){
            if(height[i]<maxHeight){
                while(!stack.empty() && stack.peek()<=i){
                    stack.pop();
                }
                int left=maxHeight;
                int right=stack.isEmpty()?-1:height[stack.peek()];
                if(height[i]<left && height[i]<right){
                    ans+=Math.min(left,right)-height[i];
                }
            }
            maxHeight=Math.max(maxHeight,height[i]);
        }
        return ans;
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
