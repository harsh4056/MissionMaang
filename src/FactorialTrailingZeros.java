public class FactorialTrailingZeros {

    public int trailingZeroes(int n) {
        int count =0;
        for (int i = 5; i <=n ; i*=5) {
            count+= n / i;
        }
        return count;
    }
    public static void main(String[] args) {
        FactorialTrailingZeros zeros= new FactorialTrailingZeros();
        System.out.println(
        zeros.trailingZeroes(250));
    }
}
