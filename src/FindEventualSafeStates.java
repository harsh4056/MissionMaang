import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindEventualSafeStates {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        boolean []visited=new boolean[graph.length];
        boolean []path=new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if(!visited[i])
             check(graph,visited,path,i);
        }
        List<Integer> answer= new ArrayList<>();

        for (int i = 0; i < path.length; i++) {
           if(!path[i]){
               answer.add(i);
           }

        }
        return answer;

    }
    public boolean check(int[][] graph,boolean []visited,boolean []path,int index){
            if(path[index]){
                return true;
            }

            visited[index]=true;
            path[index]=true;
            for (int node:graph[(index)]) {

                    if (!visited[node] && check(graph, visited, path, node)) {
                        return true;
                    }
                if (path[node]) return true;


            }
            path[index]=false;
            return false;
    }

    public static void main(String[] args) {
        FindEventualSafeStates solution = new FindEventualSafeStates();

        int[][] graph1 = {
                {1, 2},
                {2, 3},
                {5},
                {0},
                {5},
                {},
                {}
        };
        System.out.println(solution.eventualSafeNodes(graph1)); // Expected: [2,4,5,6]

        int[][] graph2 = {
                {1, 2, 3, 4},
                {1, 2},
                {3, 4},
                {0, 4},
                {}
        };
        System.out.println(solution.eventualSafeNodes(graph2)); // Expected: [4]

        int[][] graph3 = {
                {1, 2},
                {2, 3},
                {3, 0},
                {4},
                {}
        };
        System.out.println(solution.eventualSafeNodes(graph3)); // Expected: [4,3]
    }

}
