public class NumberOfSubarraysWithAverageAtLeastThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count = 0;
        int sum = 0;
        int n = arr.length;
        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        double avg=(double)sum/k;
        if(avg>=threshold) count++;
        for(int i=k;i<n;i++){
            sum-=arr[i-k];
            sum+=arr[i];
            avg=(double)sum/k;
            if(avg>=threshold) count++;
        }
        return count;
    }
    public static void main(String[] args) {
        NumberOfSubarraysWithAverageAtLeastThreshold sol = new NumberOfSubarraysWithAverageAtLeastThreshold();

        // Test case 1
        int[] arr1 = {2, 2, 2, 2, 5, 5, 5, 8};
        System.out.println(sol.numOfSubarrays(arr1, 3, 4));
        // Expected: 3 ([2,5,5], [5,5,5], [5,5,8])

        // Test case 2
        int[] arr2 = {1, 1, 1, 1, 1};
        System.out.println(sol.numOfSubarrays(arr2, 1, 1));
        // Expected: 5 (all single elements satisfy)

        // Test case 3
        int[] arr3 = {11, 13, 17, 23, 29, 31, 7, 5, 2};
        System.out.println(sol.numOfSubarrays(arr3, 3, 5));
        // Expected: 6
    }

}
