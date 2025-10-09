public class SplitArrayWithMinDifference {

    public long splitArray(int[] nums) {
        long[]prefixSum=new long[nums.length];
        prefixSum[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        int till=0;
        boolean[]flip=new boolean[nums.length];
        flip[0]=true;
        boolean firstFalse=false;
        int falseCount=0;
        for(int i=1;i<nums.length;i++){
            if( nums[i-1]<nums[i]){
                if(!firstFalse)
                 flip[i]=true;
                else return -1L;
            }
            else{
                falseCount++;
                firstFalse=true;
                flip[i]=false;
            }
        }
        
        if(falseCount==0 || falseCount== nums.length) return -1;




        return 0L;
    }


    public static void main(String[] args) {
        SplitArrayWithMinDifference sol = new SplitArrayWithMinDifference();

       /* int[] nums1 = {1,3,4,2};
        System.out.println(sol.splitArray(nums1)); // Expected output: 7*/

        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println(sol.splitArray(nums2)); // Expected output: 15

        int[] nums3 = {2, 2, 2, 2, 2};
        System.out.println(sol.splitArray(nums3)); // Expected output: 6
    }


}
