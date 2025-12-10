public class BeautifulTowersI {


        public long maximumSumOfHeights(int[] heights) {
            long sum=0;
            int peakI= -1;
            int peak=0;
            int n=heights.length;
            int peakL=-1;
            int peakR=-1;
            for(int i=0;i<n;i++){
                if(heights[i]>peak){
                    peak=heights[i];
                    peakL=i;
                    peakR=i;
                }
            }
            int[]stack=new int[n];
            int top=-1;
            stack[++top]=peak;
            for(int i=peakI-1;i>=0;i--){
                if(stack[top]>heights[i]){
                    sum+=heights[i];
                    stack[++top]=heights[i];
                }
                else{
                    sum+=stack[top];
                }
            }
            top=-1;
            stack[++top]=peak;
            for(int i=peakI+1;i<n;i++){
                if(stack[top]>heights[i]){
                    sum+=heights[i];
                    stack[++top]=heights[i];
                }
                else{
                    sum+=stack[top];
                }
            }
            return sum+peak;

        }

    public static void main(String[] args) {
        BeautifulTowersI soln= new BeautifulTowersI();
        System.out.println(soln.maximumSumOfHeights(new int[]{2,4,5,2,5,5,2,1,1,3}));
    }

}
