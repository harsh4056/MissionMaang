public class Pow_X_N {
    public double myPow(double x, int n) {
        double ans=1;
        double mul=x;

        for(int i=0;i<31;i++){
            int bit=(n>>i)&1;
            if(bit==1){
                ans*=mul;
            }
            mul=mul*mul;
        }
        return ans;
    }

    public static void main(String[] args) {
        Pow_X_N soln= new Pow_X_N();
        System.out.println(soln.myPow(2.0,5));
    }
}
