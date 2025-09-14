import java.util.*;


public class NumberOfPeopleAwareOfASecret {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
       int []dp= new int[n+1];
       dp[1]=1;
       int[] prefixSum= new int[n+1];
       for(int i=1;i<=n;i++){

            if(i+delay>n) break;
           if(dp[i]>0) {
               for (int j = delay; j < forget; j++) {
                    if(i+j>n)break;
                    dp[i+j]=(dp[i+j]+dp[i])%1_000_000_007;
               }
           }
       }
       int count=dp[n]%1_000_000_007;
       for(int i=1;i<forget;i++){
           count=(count+dp[n-i])%1_000_000_007;
       }
       return count%1_000_000_007;
    }
    public static void main(String[] args) {
        NumberOfPeopleAwareOfASecret sol = new NumberOfPeopleAwareOfASecret();

        System.out.println(sol.peopleAwareOfSecret(6, 2, 4)); // Expected: 5
        System.out.println(sol.peopleAwareOfSecret(4, 1, 3)); // Expected: 6
        System.out.println(sol.peopleAwareOfSecret(10, 2, 4)); // Expected: 14
        System.out.println(sol.peopleAwareOfSecret(684, 18, 496)); // Expected: 14
    }

}
