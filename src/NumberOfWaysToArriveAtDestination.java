import java.util.*;

public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        int MOD = 1_000_000_007; // in case large numbers
        int[] ways = new int[n];
        ways[0] = 1;
        long[] cost = new long[n];
        Arrays.fill(cost, Long.MAX_VALUE);
        cost[0] = 0;

        // Build undirected graph
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            graph.get(road[0]).add(new Pair(road[1], road[2]));
            graph.get(road[1]).add(new Pair(road[0], road[2]));
        }

        // Dijkstra with priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.weight));
        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int node = current.node;
            long dist = current.weight;

            if (dist > cost[node]) continue; // stale entry

            for (Pair neighbor : graph.get(node)) {
                long newDist = dist + neighbor.weight;

                if (newDist < cost[neighbor.node]) {
                    cost[neighbor.node] = newDist;
                    ways[neighbor.node] = ways[node];
                    pq.offer(new Pair(neighbor.node, newDist));
                } else if (newDist == cost[neighbor.node]) {
                    ways[neighbor.node] = (int) ((ways[neighbor.node] + ways[node]) % MOD);
                }
            }
        }

        return ways[n - 1] % MOD;
    }

    static class Pair {
        int node;
        long weight;
        Pair(int n, long w) {
            node = n;
            weight = w;
        }
    }

    public static void main(String[] args) {
        NumberOfWaysToArriveAtDestination sol = new NumberOfWaysToArriveAtDestination();

        int[][] roads1 = {
                {0,6,7},{0,1,2},{1,2,3},{1,3,3},{6,3,3},
                {3,5,1},{6,5,1},{2,5,1},{0,4,5},{4,6,2}
        };
        System.out.println(sol.countPaths(7, roads1)); // Expected: 4

        int[][] roads2 = {
                {1,0,10}
        };
        System.out.println(sol.countPaths(2, roads2)); // Expected: 1
    }
}
