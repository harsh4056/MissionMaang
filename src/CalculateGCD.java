public class CalculateGCD {

    public int gcd(int a,int b){

        if(b>a){
            int temp=a;
            a=b;
            b=temp;
        }
        if(a%b==0){
            return b;
        }
        else{
           return gcd(b,a%b);
        }
    }
    public static void main(String[] args) {
        CalculateGCD calc = new CalculateGCD();

        System.out.println(calc.gcd(60, 36)); // Expected: 12
        System.out.println(calc.gcd(101, 10)); // Expected: 1
        System.out.println(calc.gcd(56, 98)); // Expected: 14
    }

}
