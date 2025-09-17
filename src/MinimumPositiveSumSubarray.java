import java.util.*;

public class MinimumPositiveSumSubarray {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min = Integer.MAX_VALUE;
        int n = nums.size();
        for(int i=0;i<n;i++){
            int sum=0;
            int limit=Math.min(n,i+r);
            for (int j = i; j < limit; j++) {
                sum+=nums.get(j);
                int size=j-i+1;
                if(size>=l && size<=r && sum>0){
                    min=Math.min(min,sum);
                }
            }
        }
        if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
    public static void main(String[] args) {
        MinimumPositiveSumSubarray obj = new MinimumPositiveSumSubarray();

        // Test case 1
        List<Integer> nums1 = Arrays.asList(7,3);
        int result1 = obj.minimumSumSubarray(nums1, 2, 2);
        System.out.println(result1); // Expected output: 2

        // Test case 2
        List<Integer> nums2 = Arrays.asList(1, 2, 3, 4);
        int result2 = obj.minimumSumSubarray(nums2, 2, 4);
        System.out.println(result2); // Expected output: 1

        // Test case 3
        List<Integer> nums3 = Arrays.asList(-1, -2, 3, 4, -5, 6);
        int result3 = obj.minimumSumSubarray(nums3, 2, 4);
        System.out.println(result3); // Expected output: 1
    }

}
