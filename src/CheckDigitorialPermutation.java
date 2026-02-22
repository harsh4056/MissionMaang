public class CheckDigitorialPermutation {
    public boolean isDigitorialPermutation(int n) {
        int[] fact = {
                1,      // 0!
                1,      // 1!
                2,      // 2!
                6,      // 3!
                24,     // 4!
                120,    // 5!
                720,    // 6!
                5040,   // 7!
                40320,  // 8!
                362880  // 9!
        };
        int[]freq= new int[10];
        long sum=0;
        int x=n;
        while (n>0){
            int rem=n%10;
            freq[rem]++;
            sum+=fact[rem];

            n=n/10;
        }
        while (sum>0){
            int rem= Math.toIntExact(sum % 10);
            freq[rem]--;

            sum=sum/10;
        }


        for (int f:freq){
            if (f != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckDigitorialPermutation soln= new CheckDigitorialPermutation();
        System.out.println(soln.isDigitorialPermutation(40558));
    }


}
