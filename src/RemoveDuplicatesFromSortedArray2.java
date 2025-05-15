public class RemoveDuplicatesFromSortedArray2 {

    public static int removeDuplicates(int[] nums) {

        int p1=0;
        int p2=0;
        if(nums.length==0)
            return 0;

        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[p2]==nums[p1] && count<=2){
                p1++;
                count++;
            }
            else{
                if(count<=2) {
                    nums[p1-1] = nums[p2];
                    count=0;
                }
                p2=p1;
            }

        }
        return p1+1;


    }

    public static void main(String[] args) {
        int []nums={0,0,1,1,1,2,2,3,3,4,5,5,5,6,6};
        removeDuplicates(nums);
    }
}
