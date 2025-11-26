public class LongestContinuousPairOfRunningOnesAndZeros {
    public int findMaxLength(int[] nums) {

        int lastCOne=0;
        int lastCZero=0;
        int len=Integer.MIN_VALUE;
        int prev=-1;
        for(int num:nums){
            if(prev==0 && num==1){
                lastCOne=0;
            }
            else if(prev==1 && num==0){
                lastCZero=0;
            }
            if(num==1)
                lastCOne++;
            else
                lastCZero++;
            if(lastCOne>0 && lastCZero>0) {
                int lesser = Math.min(lastCOne, lastCZero);
                len = Math.max(len, lesser * 2);
            }
            prev=num;
        }
        return len;

    }

    public static void main(String[] args) {
        LongestContinuousPairOfRunningOnesAndZeros soln= new LongestContinuousPairOfRunningOnesAndZeros();
        System.out.println(soln.findMaxLength(new int[]{0,1}));
        System.out.println(soln.findMaxLength(new int[]{0,1,1,1,1,1,0,0,0}));

    }
}
