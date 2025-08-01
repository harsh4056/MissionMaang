import java.util.*;

public class CourseSchedule2 {


    public int[] findOrder2(int numCourses, int[][] prerequisites) {


        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for(int []arr:prerequisites){
            graph.get(arr[1]).add(arr[0]);
        }
        int[]indegree= new int[numCourses];
        for (int i = 0; i < indegree.length; i++) {
            for(int vertex:graph.get(i)){
                indegree[vertex]++;
            }
        }
        Queue<Integer> queue= new ArrayDeque<>();
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0)
                queue.add(i);
        }

        int count=0;
        int [] ans= new int[numCourses];
        while (!queue.isEmpty()){
            int vertex=queue.poll();

            ans[count]=vertex;

            count++;
            for(int neighbour:graph.get(vertex)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0) queue.offer(neighbour);
            }

        }
        if (count==numCourses){
            return ans;
        }
        else return new int[]{};

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        index=numCourses-1;
        int []order= new int[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course); // prereq → course
        }

        int[] visited = new int[numCourses]; // 0 = unvisited, 1 = visiting, 2 = visited

        for (int i = 0; i < numCourses; i++) {
            if (hasCycleDFS(i, graph, visited,order)) {
                return new int[]{};
            }
        }

        return order;
    }




    int index=0;

    private boolean hasCycleDFS(int node, List<List<Integer>> graph, int[] visited,int[]order) {
        if (visited[node] == 1) return true;  // found cycle
        if (visited[node] == 2) return false; // already safe

        visited[node] = 1; // mark as visiting

        for (int neighbor : graph.get(node)) {
            if (hasCycleDFS(neighbor, graph, visited,order)) {
                return true;
            }
        }
        order[index--]=node;
        visited[node] = 2; // mark as safe/finished
        return false;
    }

    public static void main(String[] args) {
        CourseSchedule2 solver = new CourseSchedule2();
        int numCourses1 = 2;
        int[][] prerequisites1 = {{1, 0}};
        System.out.println("Order: " + Arrays.toString(solver.findOrder2(numCourses1, prerequisites1))); // [0,1]

        int numCourses2 = 4;
        int[][] prerequisites2 = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        System.out.println("Order: " + Arrays.toString(solver.findOrder2(numCourses2, prerequisites2))); // [0,2,1,3] or [0,1,2,3]

        int numCourses3 = 2;
        int[][] prerequisites3 = {{0, 1}, {1, 0}};
        System.out.println("Order: " + Arrays.toString(solver.findOrder2(numCourses3, prerequisites3))); // []

    }


}
