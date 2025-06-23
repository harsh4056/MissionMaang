import java.util.ArrayDeque;
import java.util.Queue;

public class NearestExitFromEntranceInMaze {

    public int nearestExit(char[][] maze, int[] entrance) {

        Queue<int[]> queue= new ArrayDeque<>();
        int[]start= new int[]{entrance[0],entrance[1],0};
        queue.add(start);
        int [][]directions=new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        maze[entrance[0]][entrance[1]]='+';
        while (!queue.isEmpty()){
                int[] current=queue.poll();
            for (int[] direction : directions) {

                int i=current[0]+direction[0];
                int j=current[1]+direction[1];
                if((i>=0 && i<maze.length && j>=0 && j< maze[0].length) &&(
                        i==0||j==maze[0].length-1||i==maze.length-1||j==0) &&
                        maze[i][j]!='+'){
                    return  current[2]+1;
                }
                else if((i>=0 && i<maze.length && j>=0 && j< maze[0].length) &&
                        maze[i][j]!='+'
                        ){
                    maze[i][j]='+';
                    queue.offer(new int[]{i,j,current[2]+1});
                }

            }
        }
        return -1;

    }

    public static void main(String[] args) {
        NearestExitFromEntranceInMaze solution = new NearestExitFromEntranceInMaze();

        // Test case 1
        char[][] maze1 = {
                {'+','+','.','+'},
                {'.','.','.','+'},
                {'+','+','+','.'}
        };
        int[] entrance1 = {1, 2};
        System.out.println(solution.nearestExit(maze1, entrance1)); // Expected: 1

        // Test case 2
        char[][] maze2 = {
                {'+','+','+'},
                {'.','.','.'},
                {'+','+','+'}
        };
        int[] entrance2 = {1, 0};
        System.out.println(solution.nearestExit(maze2, entrance2)); // Expected: 2

        // Test case 3
        char[][] maze3 = {
                {'.','+'}
        };
        int[] entrance3 = {0, 0};
        System.out.println(solution.nearestExit(maze3, entrance3)); // Expected: -1
    }



}
