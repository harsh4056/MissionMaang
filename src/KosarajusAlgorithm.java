import java.util.*;

public class KosarajusAlgorithm {
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj) {
        //First dfs 
        boolean[]visited=new boolean[V];
        Stack<Integer> stack= new Stack<>();
        for (int i = 0; i < V; i++) {
                if(!visited[i])
                 dfs(i,visited,adj,stack);
        }
        ArrayList<ArrayList<Integer>> adjT= new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjT.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            visited[i]=false;
            for(int neighbor:adj.get(i)){
                adjT.get(neighbor).add(i);
            }
        }



        int scc=0;

        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                scc++;
                dfs3(node, visited, adjT);
            }
        }


        return scc;
    }

    private void dfs(int node, boolean[]visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stack) {
        visited[node]=true;
        for(int neighbor:adj.get(node)){
            if(!visited[neighbor]){
                dfs(neighbor,visited,adj,stack);
            }
        }
        stack.push(node);
    }
    private void dfs3(int node, boolean[] vis, ArrayList<ArrayList<Integer>> adjT) {
        vis[node] = true;
        for (Integer it : adjT.get(node)) {
            if (!vis[it]) {
                dfs3(it, vis, adjT);
            }
        }
    }

    public static void main(String[] args) {
        int V = 8;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(0);
        adj.get(2).add(3);
        adj.get(3).add(4);
        adj.get(4).add(5);
        adj.get(4).add(7);
        adj.get(5).add(6);
        adj.get(6).add(4);
        adj.get(6).add(7);

        KosarajusAlgorithm obj = new KosarajusAlgorithm();
        System.out.println("SCC count: " + obj.kosaraju(V, adj));
    }
}
