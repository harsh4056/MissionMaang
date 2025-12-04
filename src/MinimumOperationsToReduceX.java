public class MinimumOperationsToReduceX {

    public int minOperations(int[] nums, int x) {
        long sum = 0;
        int n = nums.length;
        for (int num : nums)
            sum += num;
        if(sum==x) return 0;
        long k = sum - x;
        int l = 0;

        long window = 0;
        int ans = 0;
        for (int r = 0; r < n; r++) {
            window += nums[r];
            while (l < r && window > k) {
                window -= nums[l++];
            }
            if (window == k) {
                ans = Math.max(ans, r - l + 1);
            }
        }
        if(ans==0) return -1;
        return n - ans;
    }

    public static void main(String[] args) {
        MinimumOperationsToReduceX soln= new MinimumOperationsToReduceX();
        System.out.println(soln.minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309},134365));
    }
}
