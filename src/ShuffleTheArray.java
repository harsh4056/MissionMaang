import java.util.Arrays;

public class ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int k=n;
        int l=0;
        int[]answer= new int[nums.length];
        for (int i = 0; k< nums.length; i++) {
            if(i%2==0){
                answer[i]=nums[l];
                l++;
            }
            else{
                answer[i]=nums[k];
                k++;
            }

        }
        return answer;
    }

    public static void main(String[] args) {
        ShuffleTheArray solution = new ShuffleTheArray();

        int[] result1 = solution.shuffle(new int[]{2,5,1,3,4,7}, 3);
        System.out.println(Arrays.toString(result1)); // Expected: [2,3,5,4,1,7]

        int[] result2 = solution.shuffle(new int[]{1,2,3,4,4,3,2,1}, 4);
        System.out.println(Arrays.toString(result2)); // Expected: [1,4,2,3,3,2,4,1]

        int[] result3 = solution.shuffle(new int[]{1,1,2,2}, 2);
        System.out.println(Arrays.toString(result3)); // Expected: [1,2,1,2]
    }

}
