public class MaxSubArraySumWithOneDelete {

    public int maximumSum(int[] arr) {
        int maxSum = arr[0];
        int currentSum = arr[0];
        int recentMin=Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            if (currentSum + arr[i] > arr[i]) {
                currentSum = currentSum + arr[i];
                recentMin= Math.min(arr[i], recentMin);
            } else {
                currentSum = arr[i];
                recentMin= Math.min(arr[i], 0);
            }

            if (maxSum < currentSum) {
                maxSum = currentSum;
            }
        }

        return maxSum-recentMin;

    }

    public static void main(String[] args) {
        MaxSubArraySumWithOneDelete solution = new MaxSubArraySumWithOneDelete();

        int[] arr1 = {1, -2, 0, 3};
        System.out.println(solution.maximumSum(arr1)); // Expected: 4

        int[] arr2 = {1, -2, -2, 3};
        System.out.println(solution.maximumSum(arr2)); // Expected: 3

        int[] arr3 = {-1, -1,2,3,3, -1,-1, 5,5,-1};
        System.out.println(solution.maximumSum(arr3)); // Expected: -1
    }


}
