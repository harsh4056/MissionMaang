import java.util.Arrays;
import java.util.Scanner;

public class UnconventionalPairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();  // number of test cases
        while (t-- > 0) {
            int n = sc.nextInt();  // size of array
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // TODO: implement logic to compute minimum operations
            int result = minOfMaxDifference(a);

            System.out.println(result);
        }

        sc.close();
    }

    public static int minOfMaxDifference(int[]nums){
        Arrays.sort(nums);
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i+=2){
            max=Math.max(max,Math.abs(nums[i]-nums[i+1]));
        }
        return max;
    }
}
