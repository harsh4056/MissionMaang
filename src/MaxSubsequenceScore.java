import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MaxSubsequenceScore {

    public long maxScore(int[] nums1, int[] nums2, int k) {
        Integer[] idx = new Integer[nums2.length];
        for (int i = 0; i < nums2.length; i++) idx[i] = i;

        Arrays.sort(idx, (i, j) -> Integer.compare(nums2[j], nums2[i]));


        int[] sortedNums1 = new int[nums1.length];
        int[] sortedNums2 = new int[nums2.length];

        for (int i = 0; i < idx.length; i++) {
            sortedNums1[i] = nums1[idx[i]];
            sortedNums2[i] = nums2[idx[i]];
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long max=0;
        long runningSum=0;
        for (int i = 0; i < sortedNums2.length; i++) {

            runningSum+=sortedNums1[i];
            if(minHeap.size()==k-1) {

                long score=(runningSum * sortedNums2[i]);
                max = Math.max(max,score );
            }
            minHeap.offer(sortedNums1[i]);
            while (minHeap.size()>k-1){
                runningSum-=minHeap.poll();
            }


        }
        return max;

    }

    public static void main(String[] args) {
        MaxSubsequenceScore solution = new MaxSubsequenceScore();

        int[] nums1_1 = {1, 3, 3, 2};
        int[] nums2_1 = {2, 1, 3, 4};
        int k1 = 3;
        System.out.println(solution.maxScore(nums1_1, nums2_1, k1)); // Expected: 12

        int[] nums1_2 = {4, 2, 3, 1, 1};
        int[] nums2_2 = {7, 5, 10, 9, 6};
        int k2 = 1;
        System.out.println(solution.maxScore(nums1_2, nums2_2, k2)); // Expected: 30

        int[] nums1_3 = {2, 1, 14, 12};
        int[] nums2_3 = {11, 7, 13, 6};
        int k3 = 3;
        System.out.println(solution.maxScore(nums1_3, nums2_3, k3)); // Expected: 91
    }

}
