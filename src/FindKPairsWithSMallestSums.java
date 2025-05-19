import java.util.*;

public class FindKPairsWithSMallestSums {

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return result;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        // Push the first k pairs (nums1[i], nums2[0]) into the heap
        for (int i = 0; i < Math.min(nums1.length, k); i++) {
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int i = top[1], j = top[2];

            result.add(Arrays.asList(nums1[i], nums2[j]));

            // If there's a next element in nums2 for the current i, push it
            if (j + 1 < nums2.length) {
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return result;

    }
    public static void main(String[] args) {
        FindKPairsWithSMallestSums sol = new FindKPairsWithSMallestSums();
        int[] nums1 = {1,1,2};
        int[] nums2 = { 1,2,3};
        int k = 3;

        List<List<Integer>> result = sol.kSmallestPairs(nums1, nums2, k);
        for (List<Integer> pair : result) {
            System.out.println(pair);
        }
    }
}
