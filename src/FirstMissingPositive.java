public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]>n || nums[i]<=0?0:nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int temp=nums[i];

        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return n+1;
    }


    public static void main(String[] args) {
        FirstMissingPositive soln = new FirstMissingPositive();

        System.out.println(soln.firstMissingPositive(new int[]{1,2,6,3,5,4})); // Expected: 7
        System.out.println(soln.firstMissingPositive(new int[]{1})); // Expected: 2
        // Single element - not smallest positive
        System.out.println(soln.firstMissingPositive(new int[]{2})); // Expected: 1
        // Basic test case
        System.out.println(soln.firstMissingPositive(new int[]{1, 2, 0})); // Expected: 3

        // Edge case: empty array
        System.out.println(soln.firstMissingPositive(new int[]{})); // Expected: 1

        // Edge case: all negative numbers
        System.out.println(soln.firstMissingPositive(new int[]{-1, -2, -3})); // Expected: 1

        // Edge case: missing number in middle
        System.out.println(soln.firstMissingPositive(new int[]{3, 4, -1, 1})); // Expected: 2

        // Edge case: consecutive positive numbers
        System.out.println(soln.firstMissingPositive(new int[]{1, 2, 3, 4, 5})); // Expected: 6

        // Edge case: duplicate numbers
        System.out.println(soln.firstMissingPositive(new int[]{1, 1, 2, 2})); // Expected: 3

        // Edge case: large gaps
        System.out.println(soln.firstMissingPositive(new int[]{7, 8, 9, 11, 12})); // Expected: 1




    }



}
