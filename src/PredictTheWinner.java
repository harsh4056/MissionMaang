public class PredictTheWinner {
    public boolean predictTheWinner(int[] nums) {
        boolean result=find(0,nums.length-1,nums,true,0,0);
        return result;
    }

    public boolean find(int start, int end, int[] nums, boolean p1Chance, int scoreP1, int scoreP2) {
        if (start <= end) {
            if (p1Chance) {
                return find(start + 1, end, nums, false, scoreP1 + nums[start], scoreP2) ||
                        find(start, end - 1, nums, false, scoreP1 + nums[end], scoreP2);
            }

            else {
                return find(start + 1, end, nums, true, scoreP1, scoreP2 + nums[start]) ||
                        find(start, end - 1, nums, true, scoreP1, scoreP2 + nums[end]);
            }
        }

        else {
            return scoreP1 > scoreP2;
        }
    }
    public static void main(String[] args) {
        PredictTheWinner sol = new PredictTheWinner();

        int[] nums1 = {1, 5, 2};
        System.out.println(sol.predictTheWinner(nums1)); // false

        int[] nums2 = {1, 5, 233, 7};
        System.out.println(sol.predictTheWinner(nums2)); // true

        int[] nums3 = {1, 1, 1};
        System.out.println(sol.predictTheWinner(nums3)); // true
    }

}
