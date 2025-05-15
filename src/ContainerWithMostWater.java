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
        ContainerWithMostWater containerWithMostWater= new ContainerWithMostWater();
        containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        containerWithMostWater.maxArea(new int[]{1,1});
        containerWithMostWater.maxArea(new int[]{50, 1, 1, 1, 1, 1, 1, 1, 1, 50});
        containerWithMostWater.maxArea(new int[]{1,2,1});
    }
}
