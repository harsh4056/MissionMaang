public class LongestSubarrayWithMaxBitwiseAND {

    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for (int j : nums) {
            if (max < j) {
                max = j;
            }
        }
        int countMax=0;
        int count=0;
       for(int num:nums){
           if(max==num){
               count++;
               countMax=Math.max(count,countMax);
           }
           else{
               count=0;
           }
       }
       return countMax;
    }
}
