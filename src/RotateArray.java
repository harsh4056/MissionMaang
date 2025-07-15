import java.util.Arrays;

public class RotateArray {
    public void rotate(int[] nums, int k) {
        int n=nums.length;

        int[]arr= new int[n];
        for (int i=0;i<n;i++){
            arr[i]=nums[(i+k)%n];
        }
        for (int i=0;i<n;i++){
            nums[i]=arr[i];
        }

    }
    public static void main(String[] args) {
        RotateArray solution = new RotateArray();

        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums1, 3);
        System.out.println(Arrays.toString(nums1)); // Expected: [5, 6, 7, 1, 2, 3, 4]

        int[] nums2 = {-1, -100, 3, 99};
        solution.rotate(nums2, 2);
        System.out.println(Arrays.toString(nums2)); // Expected: [3, 99, -1, -100]

        int[] nums3 = {1, 2};
        solution.rotate(nums3, 3);
        System.out.println(Arrays.toString(nums3)); // Expected: [2, 1]
    }

}
