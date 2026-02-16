import tools.SegmentTree;

import java.util.Arrays;

public class CountNonInversions {




    public long[] countStableSubarrays(int[] nums, int[][] queries) {
        int n=nums.length;
        int[]nextInv= new int[n];
        int inv=n;
        for (int i = n-1; i>=1; i--) {

            if(nums[i]<nums[i-1]){
                inv=i;
            }
            nextInv[i]= inv;

        }
        nextInv[0]=inv;
        long[]prefix= new long[n];
        int count=1;
        prefix[0]=1;
        for (int i = 1; i < n; i++) {
            if(nums[i]>=nums[i-1]){
                count++;
            }
            else{
                count=1;
            }
            prefix[i]=prefix[i-1]+count;
        }
        long[]ans= new long[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            int L = query[0];
            int R = query[1];

            int B = nextInv[L];

            if(B>R){
                long size=R-L+1;
                ans[i]=size*(size+1)/2;
            }
            else {
                long right = prefix[R] - prefix[B - 1];
                long diff = B - L;
                long left = (diff * (diff + 1)) / 2;
                ans[i] = left + right;
            }

        }

        return ans;

    }
    public static void main(String[] args) {
        CountNonInversions sol = new CountNonInversions();


        int[] nums3 = {5,8,18,21};
        int[][] q3 = {{2, 2}};
        long[] res3 = sol.countStableSubarrays(nums3, q3);
        System.out.println(Arrays.toString(res3)); // expected: [1]

        int[] nums1 = {21,3,4,17};
        int[][] q1 = {{1, 3}};
        long[] res1 = sol.countStableSubarrays(nums1, q1);
        System.out.println(Arrays.toString(res1)); // expected: [6]

        int[] nums2 = {3, 1, 2};
        int[][] q2 = {{0, 1}, {1, 2},{0,2}};
        long[] res2 = sol.countStableSubarrays(nums2, q2);
        System.out.println(Arrays.toString(res2)); // expected: [2,3,4]


    }


}
