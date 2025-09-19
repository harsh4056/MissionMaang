public class LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int n=nums.length;
        int[] ands=new int[n-1];
        for(int i=0;i<n-1;i++){
            if((nums[i]&nums[i+1])==0)
             ands[i]=0;
            else ands[i]=1;
        }
        int count=0;
        int max=0;
        for(int i=0;i<n-1;i++){
            if(ands[i]==0) count++;
            else count=0;
            max=Math.max(max,count);
        }
        return max+1;
    }

    public static void main(String[] args) {
        LongestNiceSubarray sol = new LongestNiceSubarray();

        // Test case 1
        int[] nums1 = {1, 3, 8, 48, 10};
        System.out.println(sol.longestNiceSubarray(nums1));
        // Expected: 3 ([3,8,48])

        // Test case 2
        int[] nums2 = {3, 1, 5, 11, 13};
        System.out.println(sol.longestNiceSubarray(nums2));
        // Expected: 1 (no two consecutive elements have bitwise AND = 0)

        // Test case 3
        int[] nums3 = {1, 2, 4, 8};
        System.out.println(sol.longestNiceSubarray(nums3));
        // Expected: 4 (all are powers of two, AND of adjacent = 0)
    }

}
