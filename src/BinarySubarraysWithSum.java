public class BinarySubarraysWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int total = 0;

        int sum = 0;
        int n = nums.length;
        int start=0;
        for (int end = 0; end < n; end++) {
            sum += nums[end];
            if (sum == goal)
                total++;
            if(sum>goal) {
                while (start <= end && sum >= goal) {
                    sum -= nums[start];
                    if (sum == goal)
                        total++;
                    start++;
                }
            }
        }
        return total;
    }

    public int numSubarraysWithSum2(int[] nums, int goal) {
        int total = 0;


        int n = nums.length;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                if(sum==goal) total++;
            }
        }

        return total;
    }

    public static void main(String[] args) {
        BinarySubarraysWithSum sol = new BinarySubarraysWithSum();

        // Test case 1
        int[] nums1 = {1, 0, 1, 0, 1};
        //System.out.println(sol.numSubarraysWithSum(nums1, 2));
        // Expected: 4  (subarrays: [1,0,1], [0,1,0,1], [1,0,1], [1,0,1])

        // Test case 2
        int[] nums2 = {0, 0, 0, 0, 0};
        System.out.println(sol.numSubarraysWithSum2(nums2, 0));
        // Expected: 15 (all subarrays have sum = 0)

        // Test case 3
        int[] nums3 = {1, 1, 1};
        System.out.println(sol.numSubarraysWithSum2(nums3, 2));
        // Expected: 2 ([1,1] from index 0–1 and [1,1] from index 1–2)
    }

}
