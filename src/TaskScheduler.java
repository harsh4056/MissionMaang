import java.util.*;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        int[][]freq= new int[26][2];
        for(int task:tasks){
            freq[task-'A'][0]++;
        }
        int i;
        for(i=0;i<100000;i++){

            int winner=Integer.MAX_VALUE;
            for(int[]f:freq){
                if(f[0]>0 && f[1]<=i){

                    f[0]--;
                    f[1]=i+n;
                    break;
                }
                else {
                    winner=Math.min(winner,f[1]);
                }
            }
            if(winner>=i && winner!=Integer.MAX_VALUE)
             i=winner;


        }
        int ans=0;
        for(int[]f:freq){
             ans=Math.max(ans,f[1]);

        }
        return ans-1;
    }


    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler();
        // Example 1:
        char[] tasks1 = {'A','A','A','B','B','B'};
        int n1 = 2;
        System.out.println("Output 1: " + scheduler.leastInterval(tasks1, n1));  // Expected Output: 8

        // Example 2:
        char[] tasks2 = {'A','C','A','B','D','B'};
        int n2 = 1;
        System.out.println("Output 2: " + scheduler.leastInterval(tasks2, n2));  // Expected Output: 6

        // Example 3:
        char[] tasks3 = {'A','A','A','B','B','B'};
        int n3 = 3;
        System.out.println("Output 3: " + scheduler.leastInterval(tasks3, n3));  // Expected Output: 10
    }

}
