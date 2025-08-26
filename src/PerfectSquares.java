import java.util.*;

public class PerfectSquares {

    public int numSquares(int n) {
        List<Integer> squares=new ArrayList<>();

        int[] dp= new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=1;
        dp[1]=1;
        int limit= (int) Math.floor( Math.sqrt(n));

        for (int i=1;i<limit;i++){
            dp[i*i]=1;
            squares.add(i*i);
        }



        for (int i=1;i<=n;i++){
            for(int square:squares){
                int value=i-square>0?dp[i-square]+1:Integer.MAX_VALUE;
                dp[i]=Math.min(dp[i],value);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares ps = new PerfectSquares();

        //System.out.println(ps.numSquares(12)); // Expected: 3 (4 + 4 + 4)
        //System.out.println(ps.numSquares(13)); // Expected: 2 (4 + 9)
        System.out.println(ps.numSquares(4));  // Expected: 1 (1)
    }

}
