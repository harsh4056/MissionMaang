import java.util.*;

public class RotateNonNegativeElements {
    public int[] rotateElements(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (num >= 0)
                list.add(num);
        }
        k=(k%list.size());
        rotate(list, 0, k - 1);
        rotate(list, k, list.size() - 1);
        rotate(list, 0, list.size() - 1);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                nums[i] = list.get(count++);
            }
        }
        return nums;

    }

    public void rotate(List<Integer> nums, int l, int r) {
        while (l <= r) {
            int temp = nums.get(l);
            nums.set(l, nums.get(r));
            nums.set(r, temp);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        RotateNonNegativeElements soln= new RotateNonNegativeElements();
        System.out.println(Arrays.toString(soln.rotateElements(new int[]{1, -2, 3, -4}, 3)));
    }
}
