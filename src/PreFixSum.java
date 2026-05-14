public class PreFixSum {

    public static void main(String[] args) {
        int[] nums= new int[]{1,2,1,2,1,1,2};
        int[][] queries= new int[][]{{0,3},{3,4},{2,4}};
        prefixSum(queries,nums);
    }
    public  static void prefixSum(int[][]queries,int[]nums){

        int[]prefixSum= new int[nums.length];
        prefixSum[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }

        for (int[]query:queries){
            int l=query[0];
            int r=query[1];
            if(l==0){
                System.out.println(prefixSum[r]);
            }
            else {
                System.out.println(prefixSum[r]-prefixSum[l-1]);
            }
        }
    }
}
