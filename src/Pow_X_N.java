public class Pow_X_N {
    public double myPow(double x, int n) {
        if(n<0){
        n=-n;
        x=1/x;
        }
        double ans=1.0;
        double m=x;

        for(int i=0;i<31;i++){
            int curr=(n>>i)&1;
            if(curr==1){
                ans*=m;
            }
            m=m*m;
        }
        return ans;
    }


    public static void main(String[] args) {
        Pow_X_N soln= new Pow_X_N();
        System.out.println(soln.myPow(3,3));
    }
}
