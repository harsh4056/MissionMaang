public class MinimumNumberofKConsecutiveBitFlips {
    public int minKBitFlips(int[] nums, int k) {
        int n=nums.length;
        int count=0;
        for(int i=0;i<(n-k+1);i++){
            if(nums[i]==0){
                int flips=0;
                while(flips<k){
                    nums[i+flips]=1-nums[i+flips];
                    flips++;
                }
                count++;
            }
        }
        for(int i=n-k;i<n;i++) if(nums[i]==0) return -1;
        return count;
    }
    public static void main(String[] args) {
        MinimumNumberofKConsecutiveBitFlips sol = new MinimumNumberofKConsecutiveBitFlips();

        // Test case 1
        int[] nums1 = {0, 1, 0};
        System.out.println(sol.minKBitFlips(nums1, 1));
        // Expected: 2 (flip index 0 -> [1,1,0], flip index 2 -> [1,1,1])

        // Test case 2
        int[] nums2 = {0, 1, 0};
        System.out.println(sol.minKBitFlips(nums2, 2));
        // Expected: -1 (cannot make all 1s with k=2)

        // Test case 3
        int[] nums3 = {0, 0, 0, 1, 0, 1, 1, 0};
        System.out.println(sol.minKBitFlips(nums3, 3));
        // Expected: 3
    }




}
