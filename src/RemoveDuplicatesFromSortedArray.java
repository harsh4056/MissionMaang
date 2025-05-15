public class RemoveDuplicatesFromSortedArray {

    public static int removeDuplicates(int[] nums) {

        int p1=0;
        int p2=0;
        if(nums.length==0)
            return 0;

        for (int i = 0; i < nums.length; i++) {
            if(nums[p2]==nums[p1]){
                p2++;
            }
            else{
                p1++;
                nums[p1]=nums[p2];
                p2++;
            }

        }
        return p1+1;


    }

    public static void main(String[] args) {
        int []nums={0,0,1,1,1,2,2,3,3,4,5,5,5,6,6};
        removeDuplicates(nums);
    }
}
