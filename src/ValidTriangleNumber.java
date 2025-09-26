import java.util.*;

public class ValidTriangleNumber {

    public int countLess(int[] arr, int left, int right, int num) {
        int l = left, r = right;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < num) {
                ans = mid;       // valid, try to go right to find last < num
                l = mid + 1;
            } else {
                r = mid - 1;     // mid >= num
            }
        }

        if (ans == -1) return 0;
        return ans - left + 1;     // number of elements < num
    }

    public int triangleNumber(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        for(int i=0;i<n-2;i++){
            int a=nums[i];
           for(int j=i+1;j<n;j++){
               int b=nums[j];
               if(j+1<n) {
                   int total = countLess(nums, j +1, n - 1, a + b);
                   count+=total;
               }
           }
        }
        return count;
    }

    public static void main(String[] args) {



        ValidTriangleNumber sol = new ValidTriangleNumber();

        int[] nums1 = {2, 2, 3, 4};
        System.out.println(sol.triangleNumber(nums1)); // Expected: 3

        int[] nums2 = {4, 2, 3, 4};
        System.out.println(sol.triangleNumber(nums2)); // Expected: 4

        int[] nums3 = {1, 1, 1, 1};
        System.out.println(sol.triangleNumber(nums3)); // Expected: 4
    }

}
