import java.util.Arrays;

public class LongestBitonicSequence {

    public static int longestBitonicSequence(int[] arr, int n) {
        int[] incr = new int[n];
        int[] decr = new int[n];
        for(int i=0;i<n;i++){
            incr[i]=1;
            decr[i]=1;
        }

        for (int i = 0; i < n; i++) {
            // Forward: LIS ending at i
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    incr[i] = Math.max(incr[i], incr[j] + 1);
                }
            }

            // Backward: LDS starting at (n-1 - i)
            int k = n - 1 - i;
            for (int j = n - 1; j > k; j--) {
                if (arr[k] > arr[j]) {
                    decr[k] = Math.max(decr[k], decr[j] + 1);
                }
            }
        }

        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            maxLen = Math.max(maxLen, incr[i] + decr[i] - 1);
        }

        return maxLen;
    }


    public static void main(String[] args) {
        int[] test1 = {1, 3, 5, 4, 2};
        System.out.println(longestBitonicSequence(test1, test1.length)); // Expected: 5

        int[] test2 = {1, 2, 3, 4, 5};
        System.out.println(longestBitonicSequence(test2, test2.length)); // Expected: 5

        int[] test3 = {9,8,1,7,6,5,4,3,2,1};
        System.out.println(longestBitonicSequence(test3, test3.length)); // Expected: 5
    }

}
