public class SumOfIntegers {
    public int getSum(int a, int b) {
        int carry=0;
        int ans=0;

        for(int i=0;i<32;i++){
            int a1=((a>>i)&1);
            int b1=((b>>i)&1);
            int c=a1^b1^carry;
            ans=(ans|(c<<i));
            carry=(a1&b1)|(a1&carry)|(b1&carry);
        }
        return ans;
    }

    public static void main(String[] args) {
        SumOfIntegers soln= new SumOfIntegers();
        System.out.println(soln.getSum(-1,-2));

    }
}
