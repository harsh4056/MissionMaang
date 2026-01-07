import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.TreeMap;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        int n= position.length;
        int[][]ps= new int[n][2];
        for (int i = 0; i < ps.length; i++) {
           ps[i][0]=position[i];
           ps[i][1]=speed[i];

        }
        Arrays.sort(ps,(a,b)->{
          return   b[0]-a[0];
        });
        Stack<Double> stack= new Stack<>();
        for (int[] p : ps) {
            int rem=target-p[0];
            double div= (double) rem /p[1];
            if(stack.isEmpty()){
                stack.push(div);
            }
            else {
                if (stack.peek() < div) {
                    stack.push(div);
                }
            }
        }
        return stack.size();

    }
    public static void main(String[] args) {
        CarFleet cf = new CarFleet();

        // Test case 1
        int target1 = 10;
        int[] position1 = {4, 1, 0, 7};
        int[] speed1 = {2, 2, 1, 1};
        System.out.println(cf.carFleet(target1, position1, speed1));
        // Expected result: 3

        // Test case 2
        int target2 = 10;
        int[] position2 = {3};
        int[] speed2 = {3};
        System.out.println(cf.carFleet(target2, position2, speed2));
        // Expected result: 1

        // Test case 3
        int target3 = 100;
        int[] position3 = {0, 2, 4};
        int[] speed3 = {4, 2, 1};
        System.out.println(cf.carFleet(target3, position3, speed3));
        // Expected result: 1
    }

}
