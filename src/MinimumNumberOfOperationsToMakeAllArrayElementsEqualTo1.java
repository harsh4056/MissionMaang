public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {

    public int minOperations(int[] nums) {
        int n=nums.length;
        int ops=0;
        for (int i = 0; i < n - 1; i++) {
           int gcd=gcd(nums[i],nums[i+1]);
           if(gcd==1){
               return ops+n-1;
           }
           else{
               nums[i+1]=gcd;
               ops=ops+2;
           }
        }
        return -1;
    }


    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
