import java.util.Stack;

public class ContainerWithMostWater {


    public int maxArea(int[] height) {

        int maxArea=0;
        int left=0;
        int right=height.length-1;

        while (left<right) {
            int area = Math.min(height[left],height[right]) * (Math.abs(left - right));
            maxArea=Math.max(area,maxArea);
            if(height[left]>height[right]){
                right--;
            }
            else{
                left++;
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();

        int[] test1 = {1,8,6,2,5,4,8,3,7};
        System.out.println(containerWithMostWater.maxArea(test1)); // Expected: 49

        int[] test2 = {1,1};
        System.out.println(containerWithMostWater.maxArea(test2)); // Expected: 1

        int[] test3 = {50, 1, 1, 1, 1, 1, 1, 1, 1, 50};
        System.out.println(containerWithMostWater.maxArea(test3)); // Expected: 450

        int[] test4 = {1,2,1};
        System.out.println(containerWithMostWater.maxArea(test4)); // Expected: 2
    }

}
