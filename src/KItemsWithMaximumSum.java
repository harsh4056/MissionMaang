public class KItemsWithMaximumSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int sum = 0;
        if (numOnes > 0 && k > 0) {
            if (numOnes >= k) {
                return k;
            } else {
                k = k - numOnes;
                sum += numOnes;
            }
        }
        if (numZeros > 0 && k > 0) {
            if (numZeros >= k) {
                return sum ;
            } else {
                k = k - numZeros;

            }
        }
        if (numNegOnes > 0 && k > 0) {
            if (numNegOnes >= k) {
                return sum - k;
            } else {
                return 0;

            }
        }

        return sum;
    }
    public static void main(String[] args) {
        KItemsWithMaximumSum solver = new KItemsWithMaximumSum();



        // Test case 2
        System.out.println(solver.kItemsWithMaximumSum(3, 3, 5, 11)); // Expected: -2


    }
}
