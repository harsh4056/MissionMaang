import java.util.*;

public class HappyNumber {
    public boolean isHappy(int n) {
        HashSet<Integer> set= new HashSet<>();
        while(!set.contains(n)){
            int num=n;
            int sum=0;
            set.add(n);
            while(num>0){
                int rem=num%10;
                num=num/10;
                sum+=rem*rem;
            }
            if(sum==1) return true;
            n=sum;
        }
        return false;
    }


    public static void main(String[] args) {
        HappyNumber soln= new HappyNumber();
        System.out.println(soln.isHappy(7));
    }
}
