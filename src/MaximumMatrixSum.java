public class MaximumMatrixSum {

    public long maxMatrixSum(int[][] matrix) {
        int min=Integer.MAX_VALUE;
        long sum=0;
        int count=0;
        for (int[] row : matrix) {
            for (int val : row) {
                sum+=Math.abs(val);
                if(val<0)count++;
                min=Math.min(min,Math.abs(val));
            }
        }
        if(count%2==1){
            sum=sum-(min* 2L);
        }
        return sum;
    }
}
