import java.util.*;

public class CheapestFlightWithinKStops {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph= new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]flight:flights){
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        Queue<int[]> queue= new LinkedList<>();
        queue.offer(new int[]{src,0,-1});
        int ans=Integer.MAX_VALUE;
        while(!queue.isEmpty()){
            int[] curr= queue.poll();

            if(curr[0]==dst && curr[2]<=k){
                ans=Math.min(curr[1],ans);
            }
            if(curr[2]>k) continue;
            List<int[]> neighbors= graph.get(curr[0]);
            for(int[] neighbor:neighbors){
                queue.offer(new int[]{neighbor[0],curr[1]+neighbor[1],curr[2]+1});
            }


        }
        return ans;
        
        
    }


    public static void main(String[] args) {
        CheapestFlightWithinKStops solution = new CheapestFlightWithinKStops();

        // Testcase 1
        int[][] flights1 = {
                {0,1,200},
                {1,2,100},
                {1,3,300},
                {2,3,100}
        };
        System.out.println(solution.findCheapestPrice(4, flights1, 0, 3, 1));
        // Expected: 500

        // Testcase 2
        int[][] flights2 = {
                {1,0,100},
                {1,2,200},
                {0,2,100}
        };
        System.out.println(solution.findCheapestPrice(3, flights2, 1, 2, 1));
        // Expected: 200

        // Testcase 3
        int[][] flights3 = {
                {0,1,100},
                {1,2,100},
                {0,2,500}
        };
        System.out.println(solution.findCheapestPrice(3, flights3, 0, 2, 0));
        // Expected: 500
    }





}
