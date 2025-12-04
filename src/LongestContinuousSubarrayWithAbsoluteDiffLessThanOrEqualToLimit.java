import java.util.TreeMap;
import java.util.TreeSet;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer,Integer> treeMap= new TreeMap<>();
        int left=0;
        int ans=0;
        for (int right = 0; right < nums.length; right++) {
            treeMap.put(nums[right],treeMap.getOrDefault(nums[right],0)+1);
            while(treeMap.size()>=2 && (treeMap.lastKey()-treeMap.firstKey())>limit){
                if(treeMap.get(nums[left])==1){
                    treeMap.remove(nums[left]);
                }
                else{
                    treeMap.put(nums[left],treeMap.getOrDefault(nums[left],0)-1);
                }
                left++;
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
    public static void main(String[] args) {
        LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit sol = new LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit();

        // Test case 1
        /*int[] nums1 = {8, 2, 4, 7};
        int limit1 = 4;
        System.out.println(sol.longestSubarray(nums1, limit1)); // Expected: 2*/

        // Test case 2
        int[] nums2 = {10, 1, 2, 4, 7, 2};
        int limit2 = 5;
        System.out.println(sol.longestSubarray(nums2, limit2)); // Expected: 4

        // Test case 3
        int[] nums3 = {4, 2, 2, 2, 4, 4, 2, 2};
        int limit3 = 0;
        System.out.println(sol.longestSubarray(nums3, limit3)); // Expected: 3
    }

}
