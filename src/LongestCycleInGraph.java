import java.util.*;

public class LongestCycleInGraph {
    int answer=0;
    public int longestCycle(int[] edges) {


        boolean[]visited= new boolean[edges.length];
        int[]depth= new int[edges.length];
        dfs(0,0,edges,visited,depth);
        if(answer==0) return -1;
        return answer;


    }

    public void dfs(int depth,int node,int[]graph,boolean []visited,int[]depths){

        if(!visited[node]){
            depths[node]=depth;
            visited[node]=true;
            dfs(depth+1,graph[node],graph,visited,depths );
        }
        else{
            answer=Math.max(depth-depths[node],answer);
        }

    }

    public static void main(String[] args) {
        LongestCycleInGraph soln= new LongestCycleInGraph();
        System.out.println(soln.longestCycle(new int[]{3,3,4,2,3}));
    }
}
