public class RemoveDuplicatesFromSortedArray2 {

    public static int removeDuplicates(int[] nums) {

            int index=0;
            int counter=0;

        for (int i = 0; i < nums.length; i++) {
           if(i>0 &&nums[i]==nums[i-1]){
               counter++;
           }
           else if(i>0 &&nums[i]!=nums[i-1]){
               counter=0;
           }
            if(counter<2) {
                nums[index++] = nums[i];
            }

        }
        return index;

    }
/*
             }*/
    public static void main(String[] args) {
        int []nums={1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));

    }
}
