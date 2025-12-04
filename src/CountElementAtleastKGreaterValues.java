import java.util.*;

public class CountElementAtleastKGreaterValues {
    public int countElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n=nums.length;
        int count=0;
        for(int i=0;i<n;i++){
            int num=nums[i];
            int idx=strictlyGreaterIndex(nums,num);
            if(idx!=-1 && n-idx>=k){
                count++;
            }
        }
        return count;
    }
    public int strictlyGreaterIndex(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] > target) {
                ans = mid;     // possible answer
                r = mid - 1;   // try to find smaller index
            } else {
                l = mid + 1;
            }
        }

        return ans; // -1 if no element is strictly greater
    }

    public static void main(String[] args) {
        CountElementAtleastKGreaterValues sol = new CountElementAtleastKGreaterValues();

        // Test Case 1
        int[] nums1 = {292720962,243599125};
        int k1 = 0;
        System.out.println("Result 1: " + sol.countElements(nums1, k1));
        // Expected: 3  (elements 1,2,3 have at least 2 greater values)

        // Test Case 2
        int[] nums2 = {5, 5, 5, 6};
        int k2 = 1;
        System.out.println("Result 2: " + sol.countElements(nums2, k2));
        // Expected: 3  (three 5's each have 1 greater value)

        // Test Case 3
        int[] nums3 = {10, 9, 8, 7};
        int k3 = 1;
        System.out.println("Result 3: " + sol.countElements(nums3, k3));
        // Expected: 3 (7<8<10, etc. three elements have at least 1 greater value)
    }


}
