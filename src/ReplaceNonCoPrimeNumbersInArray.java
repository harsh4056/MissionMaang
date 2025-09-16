import java.util.*;

public class ReplaceNonCoPrimeNumbersInArray {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int num : nums) {
            stack.push(num);
            // keep merging while top two are not coprime
            while (stack.size() > 1) {
                int a = stack.pop();
                int b = stack.pop();
                int g = gcd(a, b);
                if (g > 1) { // merge
                    long lcm = (long) a * b / g;
                    stack.push((int) lcm);
                } else {
                    stack.push(b);
                    stack.push(a);
                    break;
                }
            }
        }

        return new ArrayList<>(stack);
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
    public static void main(String[] args) {
        ReplaceNonCoPrimeNumbersInArray sol = new ReplaceNonCoPrimeNumbersInArray();

        int[] nums1 = {287,41,49,287,899,23,23,20677,5,825};
        System.out.println(sol.replaceNonCoprimes(nums1));
        // Expected: [2009,20677,825]

        int[] nums2 = {2, 2, 1, 1, 3, 3, 3};
        System.out.println(sol.replaceNonCoprimes(nums2));
        // Expected: [2,1,1,3]

        int[] nums3 = {5, 10, 15, 20};
        System.out.println(sol.replaceNonCoprimes(nums3));
        // Expected: [60]
    }

}
