import java.util.Arrays;

public class CountingBits {


    public int[] countBits(int n) {
        int []ans= new int[n+1];
        for (int i=0;i<=n;i++){
                ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;

    }

    public static void main(String[] args) {
        CountingBits cb = new CountingBits();

        System.out.println(Arrays.toString(cb.countBits(2))); // Expected: [0,1,1]
        System.out.println(Arrays.toString(cb.countBits(5))); // Expected: [0,1,1,2,1,2]
        System.out.println(Arrays.toString(cb.countBits(10))); // Expected: [0,1,1,2,1,2,2,3,1,2,2]
    }

}
