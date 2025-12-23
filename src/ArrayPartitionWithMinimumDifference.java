public class ArrayPartitionWithMinimumDifference {

    public int minimumDifference(int[] arr) {

        int sum=0;
        for (int num : arr) {
            sum+=num;
        }
        int k=sum;
        int n=arr.length;
        boolean[] dp = new boolean[k+1];

        // base case: k == 0
        dp[0] = true;

        // index goes backward (same as before)
        for (int index = n-1; index >= 0; index--) {

            // j MUST go backward
            for (int j = k; j >= 0; j--) {

                boolean take = false;
                if (j - arr[index] >= 0)
                    take = dp[j - arr[index]];

                boolean skip = dp[j];

                dp[j] = take || skip;
            }
        }
        int mini=Integer.MAX_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if(dp[i]){
                int s1=sum-i;
                int s2=i;
                mini=Math.min(mini,Math.abs(s2-s1));
            }
        }
        return mini;
    }


    public static void main(String[] args) {
        ArrayPartitionWithMinimumDifference soln= new ArrayPartitionWithMinimumDifference();
        System.out.println(soln.minimumDifference(new int[]{1,3,6,9}));
    }
}
