import java.util.*;

public class PathWithMaximumProbability {

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int start = edge[0];
            int end = edge[1];
            graph.get(start).add(end); // prereq → course
            graph.get(end).add(start); // prereq → course
        }
        boolean []visited=new boolean[n];
        int []standingProbability= new int[n];
        Arrays.fill(standingProbability,1);
        Queue<List<Integer>> bfsQueue= new ArrayDeque<>();
        visited[start_node]=true;
        bfsQueue.offer(graph.get(start_node));
        while (!bfsQueue.isEmpty()){
            List<Integer> list=bfsQueue.poll();
            for (Integer integer : list) {

                if(!visited[integer])
                    bfsQueue.offer(graph.get(integer));
                visited[integer] = true;
            }
        }
        return 0;
    }
}
