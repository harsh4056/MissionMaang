import java.util.ArrayDeque;
import java.util.Queue;

public class NumberOfProvinces {
    public int findCircleNum(int[][] isConnected) {
        boolean[]visited= new boolean[isConnected.length];
        int counter=0;
        for (int i = 0; i < isConnected.length; i++) {
            if(!visited[i]) {
                dfs(isConnected,visited,i);
                counter++;
            }
        }
        return counter;
    }
    public void dfs (int[][] isConnected,boolean[]visited,int current){
        visited[current] = true;
        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[current][j] == 1 && !visited[j]) {
                dfs(isConnected, visited, j);
            }
        }
    }
    public static void main(String[] args) {
        NumberOfProvinces solution = new NumberOfProvinces();

        int[][] test = {
                {1, 0, 0, 1},
                {0, 1, 1, 0},
                {0, 1, 1, 1},
                {1, 0, 1, 1}
        };
        System.out.println(solution.findCircleNum(test)); // 1
    }


}
