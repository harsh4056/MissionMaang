public class MoveZeros {

    public void moveZeroes(int[] nums) {
        int p1=0;
        int zeroCounter=0;
        for (int i = 0; i < nums.length; i++) {
                if(nums[i]==0){
                    zeroCounter++;
                }
                else{
                    nums[p1++]=nums[i];
                }
        }
        for (int i = nums.length-zeroCounter; i < nums.length; i++) {
               nums[i]=0;
        }

    }

    public static void main(String[] args) {
        MoveZeros mz = new MoveZeros();

        int[] test1 = {0, 1, 0, 3, 12};
        mz.moveZeroes(test1);
        System.out.println(java.util.Arrays.toString(test1)); // Expected: [1, 3, 12, 3, 12] (Incorrect logic, should modify after shifting non-zeroes)

        int[] test2 = {0, 0, 1};
        mz.moveZeroes(test2);
        System.out.println(java.util.Arrays.toString(test2)); // Expected: [1, 1, 1] (Incorrect logic as above)

        int[] test3 = {1, 0, 2, 0, 3};
        mz.moveZeroes(test3);
        System.out.println(java.util.Arrays.toString(test3)); // Expected: [1, 2, 3, 0, 0] (current logic doesn't set trailing zeroes)
    }

}
