import java.util.*;

public class ReplaceNonCoPrimeNumbersInArray {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack= new Stack<>();
        for(int i=n-1;i>=0;i--){
            stack.push(nums[i]);
        };
        List<Integer> list= new ArrayList<>();
        while(!stack.isEmpty()){
            int a=stack.pop();
            int b=stack.pop();
            if(gcd(a,b)==1){
                list.add(a);
                stack.push(b);
            }
            else{
                int lcm=lcm(a,b);
                stack.push(lcm);
            }
        }
        return list;
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return Math.abs(a * b) / gcd(a, b);
    }
}
