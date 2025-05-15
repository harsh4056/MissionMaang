import java.util.HashMap;

public class HappyNumber {
    public static boolean isHappy(int n) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        int number=n;
        while (number>1)
        {
            if(hashMap.containsKey(number)){
                return false;
            }
            else {
                int next = nextStep(number);
                hashMap.put(number, next);
                number=next;
            }
        }

        return true;

    }

    public static int nextStep(int n){
        int sum=0;
        while(n>0 ){
            int remainder=n%10;
            n=n/10;
            sum=sum +(remainder*remainder);
        }
        return sum;
    }

    public static void main(String[] args) {
        HappyNumber.isHappy(2);
    }
}
