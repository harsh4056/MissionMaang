
import java.util.*;

public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        if (n == 0) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int total = 0;
        for (int i = 0; i < n; i++) {
            total += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return total;

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
