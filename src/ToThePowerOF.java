public class ToThePowerOF {

    public double myPow(double x, int n) {
        long N=n;
        double pow=1;
        if(N<0){
            N=-N;
            x=1/x;
        }
        while(N>0){
            if((N&1)!=0){
                pow*=x;
            }
            x*=x;
            N=N>>>1;
        }
        return pow;
    }

    public static void main(String[] args) {
        ToThePowerOF toThePowerOF= new ToThePowerOF();
        System.out.println(
        toThePowerOF.myPow(3,-4));
    }


}
