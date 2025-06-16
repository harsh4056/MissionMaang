import java.util.Arrays;

public class SmallerThanCurrentNumber {

    public int[] smallerNumbersThanCurrent(int[] nums) {
        int []count= new int[101];
        int[]answer= new int[nums.length];
        for (int num : nums) {
            count[num]++;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(num==0){
                answer[i]=0;
            }
            else{
                int counter=0;
                for (int j = num-1; j >=0 ; j--) {
                    counter+=count[j];
                }
                answer[i]=counter;
            }
        }
        
        
        return answer;
    }

    public static void main(String[] args) {
        SmallerThanCurrentNumber solver = new SmallerThanCurrentNumber();

        System.out.println(Arrays.toString(solver.smallerNumbersThanCurrent(new int[]{8,1,2,2,3}))); // Expected: [4,0,1,1,3]
        System.out.println(Arrays.toString(solver.smallerNumbersThanCurrent(new int[]{6,5,4,8}))); // Expected: [2,1,0,3]
        System.out.println(Arrays.toString(solver.smallerNumbersThanCurrent(new int[]{7,7,7,7}))); // Expected: [0,0,0,0]
    }

}
