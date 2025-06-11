import java.util.HashSet;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        int globalMax=Integer.MIN_VALUE;

        HashSet<Integer> set= new HashSet<>();
        set.add(0);
        for (int height : heights) {
           set.add(height);
        }

        for (Integer integer : set) {
            int width=0;
            int minHeight=Integer.MAX_VALUE;
            for (int height : heights) {

                int value=height-integer;
                if(value>0){
                    width++;
                    minHeight=Math.min(minHeight,value);
                }
                if(value<=0){
                    int temp=(width*integer)+(width*minHeight);
                    globalMax=Math.max(globalMax,temp);
                    width=0;
                    minHeight=Integer.MAX_VALUE;
                }

            }
            int temp=(width*integer)+(width*minHeight);
            globalMax=Math.max(globalMax,temp);

        }
        return globalMax;
    }
    public static void main(String[] args) {
        LargestRectangleInHistogram solution = new LargestRectangleInHistogram();

        int[] heights1 = {1,1,1,1,1,1,1,1,1,1,1,1};
        System.out.println(solution.largestRectangleArea(heights1)); // Expected:

        int[] heights2 = {2,4};
        System.out.println(solution.largestRectangleArea(heights2)); // Expected: 4

        int[] heights3 = {6,2,5,4,5,1,6};
        System.out.println(solution.largestRectangleArea(heights3)); // Expected: 12
    }

}
