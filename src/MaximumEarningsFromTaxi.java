import java.util.Arrays;

public class MaximumEarningsFromTaxi {
    //recursion + memo
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides,(a,b)->{
            return a[0]-b[0];
        });
        int[]next= new int[rides.length];
        for (int i = 0; i < rides.length; i++) {
            next[i] = lowerBound(i, rides);
        }
        int ans=0;
        long[]dp= new long[rides.length+1];
        Arrays.fill(dp,-1);
        return solve(rides,0,next,dp);



    }
        //tabulation
    public long maxTaxiEarnings2(int n, int[][] rides) {
        Arrays.sort(rides,(a,b)->{
            return a[0]-b[0];
        });
        int[]next= new int[rides.length];
        for (int i = 0; i < rides.length; i++) {
            next[i] = lowerBound(i, rides);
        }
        int ans=0;
        long[]dp= new long[rides.length+1];
        dp[rides.length]=0;
        for (int i = rides.length-1; i >=0; i--) {
            long take= (rides[i][1]-rides[i][0] +rides[i][2])+dp[next[i]];
            long skip= dp[i+1];
            dp[i]=Math.max(take,skip);

        }

        return dp[0];

    }




    public long solve(int[][]rides,int index,int[]next,long[]dp){

        if(index==rides.length) return 0;
        if(dp[index]!=-1) return dp[index];
        long take=(rides[index][1]-rides[index][0] +rides[index][2])+ solve(rides,next[index],next,dp);
        long skip=solve(rides,index+1,next,dp);
        return dp[index]=Math.max(take,skip);
    }
    public int lowerBound(int index,int[][] rides){
        int l=index+1;
        int r=rides.length;
        int val=rides[index][1];
        while(l<r){
            int mid=(l+r)>>>1;
            if(rides[mid][0]>=val){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        MaximumEarningsFromTaxi sol = new MaximumEarningsFromTaxi();

        // Test case 1
        int n1 = 5;
        int[][] rides1 = {
                {2, 5, 4},
                {1, 5, 1}
        };
        System.out.println(sol.maxTaxiEarnings(n1, rides1));   // Expected: 7
        System.out.println(sol.maxTaxiEarnings2(n1, rides1));  // Expected: 7

        // Test case 2
        int n2 = 20;
        int[][] rides2 = {
                {1, 6, 1},
                {3, 10, 2},
                {10, 12, 3},
                {11, 12, 2},
                {12, 15, 2},
                {13, 18, 1}
        };
        System.out.println(sol.maxTaxiEarnings(n2, rides2));   // Expected: 20
        System.out.println(sol.maxTaxiEarnings2(n2, rides2));  // Expected: 20

        // Test case 3
        int n3 = 10;
        int[][] rides3 = {
                {1, 2, 5},
                {2, 3, 6},
                {3, 4, 5},
                {1, 4, 10}
        };
        System.out.println(sol.maxTaxiEarnings(n3, rides3));   // Expected: 19
        System.out.println(sol.maxTaxiEarnings2(n3, rides3));  // Expected: 19
    }

}
