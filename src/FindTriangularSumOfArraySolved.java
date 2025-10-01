import java.math.BigInteger;

public class FindTriangularSumOfArraySolved {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        BigInteger[] coef = getCoefficients(n - 1);
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i < n; i++) {
            sum = sum.add(BigInteger.valueOf(nums[i]).multiply(coef[i]).mod(BigInteger.TEN));
        }

        return sum.mod(BigInteger.TEN).intValue();
    }

    public static BigInteger[] getCoefficients(int n) {
        BigInteger[] coeff = new BigInteger[n + 1];
        coeff[0] = BigInteger.ONE; // C(n,0) = 1

        // Build row of Pascal's triangle iteratively
        for (int i = 1; i <= n; i++) {
            coeff[i] = coeff[i - 1]
                    .multiply(BigInteger.valueOf(n - i + 1))
                    .divide(BigInteger.valueOf(i));
        }

        return coeff;
    }

    public static void main(String[] args) {
        FindTriangularSumOfArraySolved solver = new FindTriangularSumOfArraySolved();

        // Test case 3 (large input)
        int[] nums3 = {5,3,5,1,7,2,6,6,4,0,4,6,4,3,1,4,0,8,2,4,3,4,9,0,5,5,0,4,6,0,6,
                3,4,2,2,7,3,8,1,0,5,3,1,9,0,2,2,5,8,6,2,3,2,3,5,8,5,4,1,2,0,9,
                3,4,4,4,1,5,1,9,2,0,8,4,3,2,4,1,9,2,4,9,2,0,1,2,3,3,8,6,0,7,3,5,
                7,7,9,2,5,3,2,3,4,9,3,3,5,3,4,0,7,2,1,2,5,0,5,0,6,9,7,6,5,3,2,9,8,9,4,1,8,4,8,
                3,7,2,2,0,1,2,3,2,2,5,8,0,1,1,3,3,3,8,4,5,6,2,6,5,7,0,4,6,6,2,2,6,7,6,1,2,7,7,6,
                0,4,9,9,8,1,8,3,3,5,4,5,0,9,4,0,8,6,3,7,1,8,3,4,6,6,1};
        System.out.println("Result 3: " + solver.triangularSum(nums3)); // Expected: 5

        // Test case 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println("Result 1: " + solver.triangularSum(nums1)); // Expected: 8

        // Test case 2
        int[] nums2 = {5};
        System.out.println("Result 2: " + solver.triangularSum(nums2)); // Expected: 5
    }
}
