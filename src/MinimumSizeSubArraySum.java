public class MinimumSizeSubArraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int start=0;
        int min=n+1;
        int sum=0;
        for(int end=0;end<n;end++){
            sum+=nums[end];
            while(start<=end && sum>=target){
                int len=end-start+1;
                min=Math.min(min,len);
                sum-=nums[start];
                start++;
            }
        }
        if(min==n+1) return 0;
        return min;
    }


    public static void main(String[] args) {
        MinimumSizeSubArraySum solution = new MinimumSizeSubArraySum();

        int[] nums1 = {2,3,1,2,4,3};
        int target1 = 7;
        //System.out.println("Result 1: " + solution.minSubArrayLen(target1, nums1));  // Expected 3

        int[] nums2 = {1, 4, 4};
        int target2 = 4;
        //System.out.println("Result 2: " + solution.minSubArrayLen(target2, nums2));  // Expected 1

        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        int target3 = 11;
        System.out.println("Result 3: " + solution.minSubArrayLen(target3, nums3));  // Expected 0
    }

}
