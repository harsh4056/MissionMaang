import java.util.*;

public class MinimumAbsoluteDistanceBetweenMirrorPairs {
    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, TreeSet<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (!map.containsKey(val)) {
                map.put(val, new TreeSet<>());
            }
            map.get(val).add(i);
        }
        int min=Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int original = nums[i];
            int reverse=reverseNumber(original);
            TreeSet<Integer> reverseTreeSet=map.get(reverse);
            if(reverseTreeSet!=null){
                Integer ceil=reverseTreeSet.higher(i);
                //Integer floor=reverseTreeSet.floor(i);
                if(ceil!=null && ceil!=i){
                    min=Math.min(min,Math.abs(ceil-i));
                }
                /*if(floor!=null && floor!=i){
                    min=Math.min(min,Math.abs(floor-i));
                }*/
            }
        }

        if(min==Integer.MAX_VALUE) return -1;
        return min;
    }
    public int reverseNumber(int num) {
        int rev = 0;

        while (num != 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }

        return rev;
    }

    public static void main(String[] args) {
        MinimumAbsoluteDistanceBetweenMirrorPairs sol = new MinimumAbsoluteDistanceBetweenMirrorPairs();

        // Test Case 1
        int[] nums1 = {9,9};
        System.out.println("Result 1: " + sol.minMirrorPairDistance(nums1));
        // Expected: 1

        // Test Case 2
        int[] nums2 = {120, 21};
        System.out.println("Result 2: " + sol.minMirrorPairDistance(nums2));
        // Expected: 1

        // Test Case 3
        int[] nums3 = {21, 120};
        System.out.println("Result 3: " + sol.minMirrorPairDistance(nums3));
        // Expected: -1
    }




}
