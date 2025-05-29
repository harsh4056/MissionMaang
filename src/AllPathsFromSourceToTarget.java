import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourceToTarget {


    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> paths= new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(graph,0, path,paths);
        return paths;
    }

    public void dfs(int[][] graph,int i,List<Integer> path,List<List<Integer>> paths){
        for (int k = 0; k <graph[i].length ; k++) {
            int node=graph[i][k];
            path.add(node);
            if(node==graph.length-1){
                paths.add(new ArrayList<>(path));
            }
            else{
                dfs(graph,node,path,paths);
            }
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        AllPathsFromSourceToTarget solution = new AllPathsFromSourceToTarget();

        int[][] graph1 = {
                {1, 2},
                {3},
                {3},
                {}
        };
        printPaths(solution.allPathsSourceTarget(graph1));

        int[][] graph2 = {
                {4,3,1},
                {3,2,4},
                {3},
                {4},
                {}
        };
        printPaths(solution.allPathsSourceTarget(graph2));

        int[][] graph3 = {
                {1},
                {2},
                {3},
                {}
        };
        printPaths(solution.allPathsSourceTarget(graph3));
    }

    public static void printPaths(List<List<Integer>> paths) {
        for (List<Integer> path : paths) {
            System.out.println(path);
        }
        System.out.println();
    }

}
