import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class PowerGridMaintenance {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        List<TreeSet<Integer>> orderedGraph= new ArrayList<>();
        for (int i = 0; i <= c; i++) {
            orderedGraph.add(new TreeSet<>());
        }
        for (int[] connection : connections) {
            orderedGraph.get(connection[0]).add(connection[1]);
            orderedGraph.get(connection[1]).add(connection[0]);
        }
        HashSet<Integer> offline= new HashSet<>();
        List<Integer> ans= new ArrayList<>();
        for (int[] query : queries) {
            int op=query[0];
            int station=query[1];
        }


        int[] arr = ans.stream().mapToInt(Integer::intValue).toArray();
        return arr;
    }
   
    public class DisjointSet {

        int[]parent;

        int[]size;

        public DisjointSet(int n) {
            parent= new int[n];
            size= new int[n];
            for(int i=0;i<n;i++) {
                parent[i] = i;
                size[i] = 0;
            }
        }
        public int findUltimateParent(int node){
            if(parent[node]==node){
                return node;
            }
            return parent[node]=findUltimateParent(node);
        }

        public void unionBySize(int u,int v){
            int pu = findUltimateParent(u);
            int pv = findUltimateParent(v);
            if (pu == pv) return;
            if (size[pu] >= size[pv]) {
                parent[pv] = pu;
                size[pu] += size[pv];
            } else {
                parent[pu] = pv;
                size[pv] += size[pu];
            }

        }
    }
    public static void main(String[] args) {
        PowerGridMaintenance solution = new PowerGridMaintenance();

        // Test Case 3
        int c3 = 4;
        int[][] connections3 = {{4,3},{3,1},{4,2},{3,2},{4,1}};
        int[][] queries3 = {
                {2,3},{1,2},{2,4},{1,1},{2,2},{1,2},{1,2},
                {2,2},{1,3},{2,3},{2,4},{2,3},{2,4},{1,2},{1,1}
        };
        int[] result3 = solution.processQueries(c3, connections3, queries3);
        System.out.println(java.util.Arrays.toString(result3));

        // Example 1
        int c1 = 5;
        int[][] connections1 = {{1,2},{2,3},{3,4},{4,5}};
        int[][] queries1 = {{1,3},{2,1},{1,1},{2,2},{1,2}};
        int[] result1 = solution.processQueries(c1, connections1, queries1);
        System.out.println(java.util.Arrays.toString(result1));
        // Expected Output: [3, 2, 3]

        // Example 2
        int c2 = 3;
        int[][] connections2 = {};
        int[][] queries2 = {{1,1},{2,1},{1,1}};
        int[] result2 = solution.processQueries(c2, connections2, queries2);
        System.out.println(java.util.Arrays.toString(result2));
        // Expected Output: [1, -1]
    }

}
