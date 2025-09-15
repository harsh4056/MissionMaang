public class CountSubArraysWhereMaxElementAppearsKTimes {
    public long countSubarrays(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int max = 0;
        for (int num : nums)
            max = Math.max(num, max);
        int n = nums.length;
        int totalSets = 0;
        int count = 0;
        while (start < n && end < n) {
            while (end < n &&nums[end] == max &&count <k) {
                count++;
                end++;
            }
            if (count == k) {

                while (count == k && start <= end) {

                    totalSets++;
                    if (nums[start] == max) {
                        count--;
                    }
                    start++;
                }
            }
            else{
                end++;
            }

        }
        return totalSets;
    }

    public static void main(String[] args) {
        CountSubArraysWhereMaxElementAppearsKTimes sol = new CountSubArraysWhereMaxElementAppearsKTimes();

        int[] nums1 = {1, 3, 2, 3, 3};
        int k1 = 2;
        System.out.println(sol.countSubarrays(nums1, k1)); // Expected: 6

        int[] nums2 = {1, 2, 2, 2};
        int k2 = 2;
        System.out.println(sol.countSubarrays(nums2, k2)); // Expected: 3

        int[] nums3 = {5, 5, 5, 5};
        int k3 = 3;
        System.out.println(sol.countSubarrays(nums3, k3)); // Expected: 2
    }

}
