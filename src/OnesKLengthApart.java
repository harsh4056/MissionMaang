public class OnesKLengthApart {

    public boolean kLengthApart(int[] nums, int k) {
        int last=-k-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                int diff=i-last-1;
                last=i;
                if(diff<k){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        OnesKLengthApart soln= new OnesKLengthApart();
        System.out.println(soln.kLengthApart(new int[]{1,0,0,0,1,0,0,1},2));
        System.out.println(soln.kLengthApart(new int[]{1,0,0,1,0,1},2));
    }
}
