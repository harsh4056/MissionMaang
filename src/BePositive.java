import java.util.*;

public class BePositive {
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
            int result = makeArrayPositiveProduct(a);

            System.out.println(result);
        }

        sc.close();
    }

     static int makeArrayPositiveProduct(int[]nums){

        int neg=0;
        int zero=0;
        int maxNeg=Integer.MIN_VALUE;

        for(int num:nums){
            if(num==0) zero++;
            if(num<0) {
                neg++;
                maxNeg=Math.max(maxNeg,num);
            }
        }
        int ops=0;
        if(zero>0) ops+=zero;
        if(neg%2==1) ops+=2;
        return ops;
    }
}
