import java.util.*;

public class NumberOfConnectedComponentsInAnUndirectedGraph {

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> graph= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        int count=0;

        boolean[]visited= new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(visited,graph,i,-1);
            }
        }
        return count;

    }


    public void dfs(boolean[] visited, List<List<Integer>> graph, int node, int parent) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            // Ignore the edge back to parent
            if (neighbor == parent || visited[neighbor]) continue;


            // DFS deeper
            dfs(visited, graph, neighbor, node);
        }

    }
    public static void main(String[] args) {
        NumberOfConnectedComponentsInAnUndirectedGraph obj =
                new NumberOfConnectedComponentsInAnUndirectedGraph();

        int n1 = 5;
        int[][] edges1 = {
                {0, 1}, {1, 2}, {3, 4}
        };
        System.out.println(obj.countComponents(n1, edges1)); // expected: 2

        int n2 = 5;
        int[][] edges2 = {
                {0, 1}, {1, 2}, {2, 3}, {3, 4}
        };
        System.out.println(obj.countComponents(n2, edges2)); // expected: 1

        int n3 = 4;
        int[][] edges3 = {
        };
        System.out.println(obj.countComponents(n3, edges3)); // expected: 4
    }

}
