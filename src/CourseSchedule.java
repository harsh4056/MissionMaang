import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Step 1: Build graph and indegree array
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] indegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        // Step 2: Add all courses with indegree 0 to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 3: Process the queue
        int finishedCourses = 0;
        while (!queue.isEmpty()) {
            int current = queue.poll();
            finishedCourses++;

            for (int neighbor : graph.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 4: Check if all courses were finished
        return finishedCourses == numCourses;
    }




    /*
    * public boolean canFinish(int numCourses, int[][] prerequisites) {
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
        if (hasCycleDFS(i, graph, visited)) {
            return false;
        }
    }

    return true;
}

private boolean hasCycleDFS(int node, List<List<Integer>> graph, int[] visited) {
    if (visited[node] == 1) return true;  // found cycle
    if (visited[node] == 2) return false; // already safe

    visited[node] = 1; // mark as visiting

    for (int neighbor : graph.get(node)) {
        if (hasCycleDFS(neighbor, graph, visited)) {
            return true;
        }
    }

    visited[node] = 2; // mark as safe/finished
    return false;
}

    *
    * */


}
