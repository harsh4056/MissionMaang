public class SmallestDivisibleDigitProductI {
    public int smallestNumber(int n, int t) {
        for(int k=n;k<100;k++){
            int i=k;
            int p=1;
            while(i>0){
                int rem=i%10;
                p*=rem;
                i=i/10;
            }

            if(  p%t==0) return k;
        }
        return 0;
    }

    public static void main(String[] args) {
        SmallestDivisibleDigitProductI soln= new SmallestDivisibleDigitProductI();
        //System.out.println(soln.smallestNumber(15,3));
        int a=(int)(Math.log(512) / Math.log(2));
        System.out.println(a);


    }
}
