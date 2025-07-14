import java.util.Arrays;

public class SquaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int negatives=-1;
        for(int i=0;i<nums.length;i++){
           if(nums[i]<0){
               negatives=i;
           }
           else{
               break;
           }
        }
        int[]ans=new int[nums.length];
        int positives=negatives+1;
        int index=0;
        while(negatives>=0 &&positives<nums.length){

            if(Math.abs(nums[negatives])<nums[positives]){
                ans[index++]=nums[negatives--];
            }
            else{
                ans[index++]=nums[positives++];
            }
        }
        while(negatives>=0) ans[index++]=nums[negatives--];
        while(positives<nums.length) ans[index++]=nums[positives++];

        for (int i = 0; i < ans.length; i++) {
            ans[i]*= ans[i];

        }
        return ans;

    }

    public static void main(String[] args) {
        SquaresOfSortedArray solution = new SquaresOfSortedArray();

      /*  int[] nums1 = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(solution.sortedSquares(nums1))); // Expected: [0, 1, 9, 16, 100]

        int[] nums2 = {-7, -3, 2, 3, 11};
        System.out.println(Arrays.toString(solution.sortedSquares(nums2))); // Expected: [4, 9, 9, 49, 121]*/

        int[] nums3 = {-1};
        System.out.println(Arrays.toString(solution.sortedSquares(nums3))); // Expected: [1, 4, 9, 25]
    }

}
