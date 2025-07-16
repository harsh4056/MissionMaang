public class MaxLengthOfValidSequence {

    public int maximumLength(int[] nums) {

        int sequence1=0;

        int sequence2=0;

        int sequence3=0;

        int sequence4=0;
        boolean flip=true;
        boolean flip2=true;
        for (int i = 0; i < nums.length; i++) {
           if(nums[i]%2==1){
               sequence1++;
           }
           if(nums[i]%2==0){
               sequence2++;
           }
            if(nums[i]%2==1 &&flip){
                flip=false;
                sequence3++;
            }
            if(nums[i]%2==0 &&!flip){
                flip=true;
                sequence3++;
            }

            if(nums[i]%2==0 &&flip2){
                flip2=false;
                sequence4++;
            }
            if(nums[i]%2==1 &&!flip2){
                flip2=true;
                sequence4++;
            }
        }


        return Math.max(sequence4,Math.max(sequence3,Math.max(sequence2,sequence1)));
    }

    public static void main(String[] args) {
        MaxLengthOfValidSequence obj = new MaxLengthOfValidSequence();

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(obj.maximumLength(nums1)); // Expected: 4

        int[] nums2 = {2, 4, 6, 8};
        System.out.println(obj.maximumLength(nums2)); // Expected: 4 (all even numbers, no odd sum pair)

        int[] nums3 = {1, 2, 2};
        System.out.println(obj.maximumLength(nums3)); // Expected: 3
    }

}
