public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        boolean[]aux= new boolean[nums.length+1];
        for(int num:nums){
            if(num>0 &&num<aux.length){
                aux[num]=true;
            }
        }
        for(int i=1;i<aux.length;i++){
            if(!aux[i]) return i;
        }
        return aux.length;
    }

    public static void main(String[] args) {
        FirstMissingPositive soln = new FirstMissingPositive();
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

        // Single element - already smallest positive
        System.out.println(soln.firstMissingPositive(new int[]{1})); // Expected: 2


    }

}
