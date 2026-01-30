import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int n, int[][] A) {
        Stack<Integer> stack= new Stack<>();
        List<List<Integer>> graph= new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }


        int[] indegree= new int[n];
        for(int []edge:A){
            graph.get(edge[1]).add(edge[0]);
            indegree[edge[0]]++;
        }
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                stack.push(i);
            }
        }
        List<Integer> list= new ArrayList<>();
        while(!stack.isEmpty()){
            int curr=stack.pop();
            list.add(curr);
            for(int nei:graph.get(curr)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    stack.push(nei);
                }
            }
        }
        return list.size()==n;


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
