import java.util.*;

public class ReorderRoutes {
    int result=0;
    public int minReorder(int n, int[][] connections) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] conn : connections) {
            int from = conn[0], to = conn[1];
            graph.get(from).add(to);     // original direction: from -> to
            graph.get(to).add(-from);    // reverse direction: to -> from (represented as negative)
        }

        dfs(0, -1,graph);
        return result;
    }

    private void dfs(int node, int parent,List<List<Integer>> graph) {
        for (int nei : graph.get(node)) {
            int absNei = Math.abs(nei);
            if (absNei == parent) continue;

            if (nei > 0) result++; // needs reversal
            dfs(absNei, node,graph);
        }
    }

    public static void main(String[] args) {
        ReorderRoutes sol = new ReorderRoutes();
        int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(sol.minReorder(6, connections)); // Output: 3
    }
}
