import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );
        int n=costs.length;
        int left=0;
        int right=0;
        for (int i = 0; i < candidates; i++) {
            minHeap.offer(new int[]{costs[i],i});
            minHeap.offer(new int[]{costs[n-i-1],n-i-1});
        }

        return 0L;

    }
}
