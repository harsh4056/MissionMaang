public class ContiguousArray {
    public int findMaxLength(int[] nums) {

        int ones=0;
        int zeros=0;
        for(int num:nums){
            if(num==1) ones++;
            else  zeros++;
        }
        return 0;


    }

    public static void main(String[] args) {
        ContiguousArray soln= new ContiguousArray();
        System.out.println(soln.findMaxLength(new int[]{0,1}));
        System.out.println(soln.findMaxLength(new int[]{0,1,1,1,1,1,0,0,0}));

    }
}
