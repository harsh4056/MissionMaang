import java.util.PriorityQueue;

public class TotalCostToHireKWorkers {

    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1])
        );
        int n=costs.length;
        int left=0;
        int right=n-1;
        int addCandidates=candidates;
        while (left<=right && addCandidates>0){
            minHeap.offer(new int[]{costs[left],left});

            if(left!=right) {
                minHeap.offer(new int[]{costs[right], right});
                right--;
            }
            left++;
            addCandidates--;
        }
        long totalCost=0;
        while (k>0){


            int[] cost=minHeap.poll();

            if(left<=right) {
                if(cost[1]>right){
                    minHeap.offer(new int[]{costs[right],right});
                    right--;
            }
                else if(cost[1]<left){
                    minHeap.offer(new int[]{costs[left],left});
                    left++;
                }
            }
            totalCost+=cost[0];
            k--;

        }

        return totalCost;

    }
    public long totalCost2(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> headpq = new PriorityQueue<>();
        PriorityQueue<Integer> tailpq = new PriorityQueue<>();
        int nextHead = candidates;
        int nextTail = costs.length - 1 - candidates;
        long cost = 0;

        for (int i = 0; i < candidates && i < costs.length; i++) {
            headpq.offer(costs[i]);
        }

        for (int j = costs.length - 1; j >= Math.max(nextHead, costs.length - candidates) && j >= 0; j--) {
            tailpq.offer(costs[j]);
        }

        for (int i = 0; i < k; i++) {
            if (tailpq.isEmpty() || (!headpq.isEmpty() && headpq.peek() <= tailpq.peek())) {
                cost += headpq.poll();
                if (nextHead <= nextTail) {
                    headpq.offer(costs[nextHead]);
                    nextHead++;
                }
            } else {
                cost += tailpq.poll();
                if (nextHead <= nextTail) {
                    tailpq.offer(costs[nextTail]);
                    nextTail--;
                }
            }
        }

        return cost;
    }


    public static void main(String[] args) {
        TotalCostToHireKWorkers solution = new TotalCostToHireKWorkers();

        // Test case 1
        int[] costs1 = {17, 12, 10, 2, 7, 2, 11, 20, 8};
        int k1 = 5, candidates1 = 3;
        System.out.println(solution.totalCost(costs1, k1, candidates1)); // Expected: 29

        // Test case 2
        int[] costs2 = {100, 200, 300, 400, 500, 600, 700, 800, 900};
        int k2 = 4, candidates2 = 4;
        System.out.println(solution.totalCost(costs2, k2, candidates2)); // Expected: 100 + 200 + 300 + 400 = 1000

        // Test case 3
        int[] costs3 = {9, 1, 8, 2, 7, 3, 6, 4, 5};
        int k3 = 6, candidates3 = 2;
        System.out.println(solution.totalCost(costs3, k3, candidates3)); // Expected: 1 + 2 + 3 + 4 + 5 + 6 = 21

        // Test case 4
        int[] costs4 = {10, 20, 30, 40, 50, 5, 5, 5, 5, 5};
        int k4 = 5, candidates4 = 3;
        System.out.println(solution.totalCost(costs4, k4, candidates4)); // Expected: 5 + 5 + 5 + 5 + 5 = 25

        // Test case 5
        int[] costs5 = new int[100];
        for (int i = 0; i < 100; i++) costs5[i] = 100 - i; // descending from 100 to 1
        int k5 = 10, candidates5 = 10;
        System.out.println(solution.totalCost(costs5, k5, candidates5)); // Expected: 1+2+3+4+5+6+7+8+9+10 = 55
    }



}
