import java.util.*;

public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[]visited= new boolean[n];
        boolean ans=dfs(visited,graph,0,-1);
        if(!ans){
            for (boolean b : visited) {
                if (!b) return false;

            }
        }
        else{
            return false;
        }
        return true;

    }
    public boolean dfs(boolean[] visited, List<List<Integer>> graph, int node, int parent) {
        visited[node] = true;

        for (int neighbor : graph.get(node)) {
            // Ignore the edge back to parent
            if (neighbor == parent) continue;

            // If already visited and not parent → cycle found
            if (visited[neighbor]) return true;

            // DFS deeper
            if (dfs(visited, graph, neighbor, node)) return true;
        }
        return false;
    }


    public static void main(String[] args) {
        GraphValidTree obj = new GraphValidTree();

        int n1 = 5;
        int[][] edges1 = {
                {0, 1}, {0, 2}, {0, 3}, {1, 4}
        };
        System.out.println(obj.validTree(n1, edges1)); // expected: true

        int n2 = 5;
        int[][] edges2 = {
                {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}
        };
        System.out.println(obj.validTree(n2, edges2)); // expected: false

        int n3 = 4;
        int[][] edges3 = {
                {0, 1}, {2, 3}
        };
        System.out.println(obj.validTree(n3, edges3)); // expected: false (disconnected)
    }


}
