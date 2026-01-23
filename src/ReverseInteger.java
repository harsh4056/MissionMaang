public class ReverseInteger {

    public int reverse(int x) {

        int rev=0;
        int num=x;
        while(num!=0){
            int rem=num%10;
            int prev=rev;
            rev=rev*10+rem;
            int temp=(rev-rem)/10;
            if(temp!=prev)
                return 0;
            num=num/10;
        }
        return rev;



    }
    public int reverseIt(int num){
        int r=0;
        while(num>0){
            int rem=num%10;
            num=num/10;
            r=r*10+rem;
        }
        return r;
    }


//2147483647
    public static void main(String[] args) {
        ReverseInteger reverseInteger= new ReverseInteger();

        System.out.println(reverseInteger.reverse(1234));
        System.out.println(reverseInteger.reverse(-12));


    }
}
