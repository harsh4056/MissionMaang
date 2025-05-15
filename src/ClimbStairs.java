public class ClimbStairs {


    public int climbStairs(int n) {
        if(n==1|| n==2 || n==0)
            return n;
       int n1=1;
       int n2=2;
       int answer=0;
        for (int i = 3; i <= n; i++) {
            answer=n1+n2;
            n1=n2;
            n2=answer;
        }
        return answer;
    }
}
