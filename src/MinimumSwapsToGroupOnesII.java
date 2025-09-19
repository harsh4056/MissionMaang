public class MinimumSwapsToGroupOnesII {




    public int minSwaps(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        int tOnes = 0;
        for (int num : nums) {
            if (num == 1) tOnes++;
        }
        int ones = 0;
        boolean first = true;
        int l = 0;
        int r = 0;
        int minSwap = Integer.MAX_VALUE;
        int swap = 0;
        for( r=0;r<tOnes ;r++){
            if (nums[r] == 0) swap++;
            ones++;
        }

        while (r != tOnes || first) {
            first = false;
            if (nums[r] == 0) swap++;
            ones++;
            while (ones > tOnes) {
                if (nums[l] == 0) swap--;
                ones--;
                l = (l + 1) % n;
            }
            if (ones == tOnes) minSwap = Math.min(minSwap, swap);

            r = (r + 1) % n;
        }
        return minSwap;
    }

    public static void main(String[] args) {
        MinimumSwapsToGroupOnesII soln= new MinimumSwapsToGroupOnesII();
        System.out.println(soln.minSwaps(new int[]{1}));
        System.out.println(soln.minSwaps(new int[]{0,1,1,1,0,0,1,1,0}));
        System.out.println(soln.minSwaps(new int[]{1,1,0,0,1}));
    }
}
