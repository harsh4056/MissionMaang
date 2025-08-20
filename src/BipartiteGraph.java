import java.util.*;

public class BipartiteGraph {

    public boolean isBipartite(int[][] graph) {
        int max=0;
        int n=graph.length;
        int[]color=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            int []neighbors=graph[i];
            HashSet<Integer> set= new HashSet<>();
            for(int nei:neighbors){
                if(color[nei]!=-1){
                    set.add(color[nei]);
                }
            }
            int count=0;
            while(set.contains(count)){
                count++;
            }
            color[i]=count;
            max=Math.max(max,count);
        }
        return max<=1;


    }

    public static void main(String[] args) {
        BipartiteGraph bg = new BipartiteGraph();

        int[][] graph1 = {
                {1,3},
                {0,2},
                {1,3},
                {0,2}
        };
        //System.out.println(bg.isBipartite(graph1)); // Expected: true

        int[][] graph2 = {
                {1,2,3},
                {0,2},
                {0,1,3},
                {0,2}
        };
        //System.out.println(bg.isBipartite(graph2)); // Expected: false

        int[][] graph3 = {
                {1},
                {0,3},
                {3},
                {1,2}
        };
        System.out.println(bg.isBipartite(graph3)); // Expected: true
    }

}
