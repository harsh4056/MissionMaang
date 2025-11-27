public class MaximumSubarraySumWithLengthDivisibleByK {

    public long maxSubarraySum(int[] nums, int k) {
        int n= nums.length;
        long ans=Long.MIN_VALUE;
        long[] window= new long[k];
        long []prefixSum=new long[n];
        prefixSum[0]=nums[0];
        for (int i = 1; i < n; i++) {
             prefixSum[i]=prefixSum[i-1]+nums[i];
        }
        window[0]=0;
        for (int i = 0; i <k-1 ; i++) {
            window[i+1]=prefixSum[i];
        }
        for (int i = k-1; i < n; i++) {
            long curr= prefixSum[i];
            curr=curr-window[(i+1)%k];
            ans=Math.max(ans,curr);
            window[(i+1)%k]=Math.min(window[(i+1)%k],prefixSum[i]);
        }
        return ans;

    }

    public static void main(String[] args) {
        MaximumSubarraySumWithLengthDivisibleByK soln= new MaximumSubarraySumWithLengthDivisibleByK();
        System.out.println(soln.maxSubarraySum(new int[]{-41,-40,1,-28,-14},3));
        System.out.println(soln.maxSubarraySum(new int[]{-1,-2,-3,-4,-5},4));
        System.out.println(soln.maxSubarraySum(new int[]{1,2},1));
        System.out.println(soln.maxSubarraySum(new int[]{-5,1,2,-3,4},2));
    }
}
