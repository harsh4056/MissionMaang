import java.util.*;


public class KahnsAlgorithm {

        // Function to detect cycle in a directed graph.
        public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
            int indegree[] = new int[V];

            for(int i = 0; i < V; i++) {
                for(int it : adj.get(i)) {
                    indegree[it]++;
                }
            }

            Queue<Integer> q = new LinkedList<Integer>();
            for(int i = 0; i < V; i++) {
                if(indegree[i] == 0) {
                    q.add(i);
                }
            }

            int cnt = 0;
            // O(V + E)
            while(!q.isEmpty()) {
                int node = q.peek();
                q.remove();
                cnt++;
                // node is in your topo sort
                // so please remove it from the indegree
                for(int it : adj.get(node)) {
                    indegree[it]--;
                    if(indegree[it] == 0) q.add(it);
                }
            }

            if(cnt == V) return false; // No cycle
            return true; // Cycle exists
        }
    }


