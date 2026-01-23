import java.util.Arrays;

public class JumpGameII {

    public int jump(int[] nums) {
        int last = 0;
        int n = nums.length;
        int count = 0;
        int i = 0;
        while (true) {
            int end = last;
            for (int j = i; j <= end; j++) {
                last = Math.max(last, Math.min(n - 1, nums[j] + j));
            }
            count++;
            i = end + 1;
            if(last>=n-1)break;
        }
        return count;
    }


    public static void main(String[] args) {
        JumpGameII solution = new JumpGameII();
        System.out.println(solution.jump(new int[]{2,1,1,1,1})); // 3
        System.out.println(solution.jump(new int[]{2,3,0,1,4})); // 2
        System.out.println(solution.jump(new int[]{7,0,9,6,9,6,1,7,9,0,1,2,9,0,3})); // 2
        System.out.println(solution.jump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0})); // 3

        System.out.println(solution.jump(new int[]{2,3,1,1,4})); // 2

        System.out.println(solution.jump(new int[]{1,1,1,1}));   // 3
    }

}
