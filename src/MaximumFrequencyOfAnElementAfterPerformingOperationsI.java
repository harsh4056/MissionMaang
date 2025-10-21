import java.util.Arrays;

public class MaximumFrequencyOfAnElementAfterPerformingOperationsI {

    public int maxFrequency(int[] nums, int k, int numOperations) {
        int n=nums.length;
        Arrays.sort(nums);
        int max=0;
        for (int i = 0; i < n; i++) {
            int num=nums[i];
            int ops=numOperations;
            int count=1;
            int s=num-k;
            int e=num+k;
            for (int j = i+1; j < n; j++) {
                int cs=nums[j]-k;
                int ce=nums[j]+k;
                if(cs>=s && cs<=e|| ce>=s && ce<=e){
                    count++;
                }
            }
            max=Math.max(max,count);
        }
        return max;

    }

    public static void main(String[] args) {
        MaximumFrequencyOfAnElementAfterPerformingOperationsI soln= new MaximumFrequencyOfAnElementAfterPerformingOperationsI();
        System.out.println(soln.maxFrequency(new int[]{6,10,14,17},2,2));
        System.out.println(soln.maxFrequency(new int[]{1,3,5,6,7,9},3,2));
    }
}
