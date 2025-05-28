import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class IfPathExists {


    public boolean validPath(int n, int[][] edges, int source, int destination) {
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
        Queue<List<Integer>>  bfsQueue= new ArrayDeque<>();
        visited[source]=true;
        bfsQueue.offer(graph.get(source));
        while (!bfsQueue.isEmpty()){
            List<Integer> list=bfsQueue.poll();
            for (Integer integer : list) {

                if(!visited[integer])
                 bfsQueue.offer(graph.get(integer));
                visited[integer] = true;
            }
        }
        return visited[destination];

    }


    public static void main(String[] args) {
        IfPathExists pathChecker = new IfPathExists();

        int n = 6;
        int[][] edges = {
                {0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}
        };
        int source = 0;
        int destination = 5;

        boolean result = pathChecker.validPath(n, edges, source, destination);
        System.out.println("Path exists: " + result);

        int n1 = 3;
        int[][] edges1 = { {0, 1}, {1, 2}, {2, 0} };
        int source1 = 0;
        int destination1 = 2;
        System.out.println("Path exists (0→2): " + pathChecker.validPath(n1, edges1, source1, destination1));

        int n2 = 4;
        int[][] edges2 = { {0, 1}, {2, 3} };
        int source2 = 0;
        int destination2 = 3;
        System.out.println("Path exists (0→3): " + pathChecker.validPath(n2, edges2, source2, destination2));


    }


}
