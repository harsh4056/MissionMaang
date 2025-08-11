import java.util.*;

public class CheapestFlightWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[]dist= new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new Pair(flight[1], flight[2]));
        }
        Queue<int[]> queue= new ArrayDeque<>();
        int[] source= new int[]{0,src,0};
        queue.offer(source);
        while(!queue.isEmpty()){
            int[] current= queue.poll();

            List<Pair> neighbors= graph.get(current[1]);
            for(Pair pair:neighbors){
                if (current[0] > k) continue;
                if( dist[pair.node]>pair.weight+dist[current[1]] ) {
                    queue.offer(new int[]{current[0]+1,pair.node,pair.weight+dist[current[1]]});
                    dist[pair.node] = pair.weight + dist[current[1]];
                }
            }
        }

        if(dist[dst]==Integer.MAX_VALUE)
            return -1;
        return dist[dst];
    }
    static class Pair {
        int node;
        int weight;
        Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }

    public static void main(String[] args) {
        CheapestFlightWithinKStops solution = new CheapestFlightWithinKStops();

        int[][] flights1 = {
                {0,1,5},
                {1,2,5},
                {0,3,2},
                {3,1,2},
                {1,4,1},
                {4,2,1}
        };
        System.out.println(solution.findCheapestPrice(5, flights1, 0, 2, 2)); // Expected: 7  (0 -> 1 -> 4 -> 2)

        int[][] flights2 = {
                {0,3,3},
                {3,4,3},
                {4,1,3},
                {0,5,1},
                {5,1,100},
                {0,6,2},
                {6,1,100},
                {0,7,1},
                {7,8,1},
                {8,9,1},
                {9,1,1},
                {1,10,1},
                {10,2,1},
                {1,2,100}
        };
        System.out.println(solution.findCheapestPrice(11, flights2, 0, 2, 4)); // Expected: 11 (0->3->4->1->10->2)

        int[][] flights3 = {
                {0,1,1},
                {0,2,5},
                {1,2,1},
                {2,3,1}
        };
        System.out.println(solution.findCheapestPrice(4, flights3, 0, 3, 1)); // Expected: 6  (0 -> 2 -> 3)
    }



}
