import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

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
        while (!queue.isEmpty()){
            int vertex=queue.poll();
            count++;


            for(int neighbour:graph.get(vertex)){
                indegree[neighbour]--;
                if(indegree[neighbour]==0) queue.offer(neighbour);
            }

        }
        return count==numCourses;


    }
    public static void main(String[] args) {
        CourseSchedule obj = new CourseSchedule();

        int[][] prerequisites1 = {
                {1, 0}
        };
        System.out.println(obj.canFinish(2, prerequisites1)); // Expected: true

        int[][] prerequisites2 = {
                {1, 0},
                {0, 1}
        };
        System.out.println(obj.canFinish(2, prerequisites2)); // Expected: false
    }






}
