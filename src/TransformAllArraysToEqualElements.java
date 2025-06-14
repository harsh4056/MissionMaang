public class TransformAllArraysToEqualElements {


    public boolean canMakeEqual(int[] nums, int k) {

        int minus=0;
        int plus=0;
        int n= nums.length;
        for (int num : nums) {
            if(num==-1){
                minus++;
            }
            else{
                plus++;
            }
        }
        if(minus%2==1 && plus%2==1){
            return false;
        }




        return true;

    }
}
