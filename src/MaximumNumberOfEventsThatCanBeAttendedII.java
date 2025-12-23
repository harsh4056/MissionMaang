import java.util.Arrays;

public class MaximumNumberOfEventsThatCanBeAttendedII {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events,(a,b)->{
            return a[0]-b[0];
        });
        int[] next=new int[events.length];
        for (int i = 0; i < next.length; i++) {
           next[i]=lowerBound(events,i);
        }
        int[][]dp = new int[events.length+1][k+1];
        for (int[] ints : dp) {
            Arrays.fill(ints,-1);
        }
        return solve(events,next,0,0,k,dp);

    }
    public int solve(int[][] events,int[]next,int count,int index,int k,int[][]dp){
        if(index==events.length || count==k) return 0;
        if(dp[index][count]!=-1) return dp[index][count];
        int take=events[index][2]+solve(events,next,count+1,next[index],k,dp);
        int skip=solve(events,next,count,index+1,k,dp);
        return dp[index][count]=Math.max(take,skip);
    }



    public int lowerBound(int[][] events,int index ){
        int val=events[index][1];
        int l=index+1;
        int r=events.length;
        while(l<r){
            int mid= (l+r)>>>1;
            if(events[mid][0]>val){
                r=mid;
            }
            else {
                l=mid+1;
            }
        }
        return l;
    }

    public static void main(String[] args) {

        MaximumNumberOfEventsThatCanBeAttendedII solution =
                new MaximumNumberOfEventsThatCanBeAttendedII();

        // Example 1
        int[][] events1 = {
                {1, 2, 4},
                {3, 4, 3},
                {2, 3, 1}
        };
        int k1 = 2;
        System.out.println(solution.maxValue(events1, k1));
        // Expected output: 7

        // Example 2
        int[][] events2 = {
                {1, 2, 4},
                {3, 4, 3},
                {2, 3, 10}
        };
        int k2 = 2;
        System.out.println(solution.maxValue(events2, k2));
        // Expected output: 10

        // Example 3
        int[][] events3 = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3},
                {4, 4, 4}
        };
        int k3 = 3;
        System.out.println(solution.maxValue(events3, k3));
        // Expected output: 9
    }

}
