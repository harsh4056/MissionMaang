import java.util.Arrays;

public class MinimumInitialEnergyToFinishTasks {
    public int minimumEffort(int[][] tasks) {
        int[][]temp= new int[tasks.length][2];
        System.arraycopy(tasks, 0, temp, 0, tasks.length);
        Arrays.sort(tasks,(a,b)->{
            int diff=(b[1]-b[0])-(a[1]-a[0]);
           return diff;
        });

        int l=0;int r=0;
        for (int[] task : tasks) {
            l+=task[0];
            r+=task[1];
        }

        while(l<r){

            int mid=l+(r-l)/2;

            if(isPossible(tasks,mid)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }

    private boolean isPossible(int[][] tasks, int energy) {

        for (int[] task : tasks) {
            if (energy >= task[1]) {
                energy -= task[0];
            } else {
                return false;
            }

        }
        return true;

    }

    public static void main(String[] args) {

        MinimumInitialEnergyToFinishTasks obj = new MinimumInitialEnergyToFinishTasks();

        int[][] tasks1 = {
                {1,2},
                {2,4},
                {4,8}
        };

        int[][] tasks2 = {
                {1,3},
                {2,4},
                {10,11},
                {10,12},
                {8,9}
        };

        int[][] tasks3 = {
                {1,7},
                {2,8},
                {3,9},
                {4,10},
                {5,11},
                {6,12}
        };
        System.out.println(obj.minimumEffort(tasks2)); // Expected: 32
        System.out.println(obj.minimumEffort(tasks1)); // Expected: 8

        System.out.println(obj.minimumEffort(tasks3)); // Expected: 27
    }


}
