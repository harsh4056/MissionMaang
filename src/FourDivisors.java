import java.util.*;

public class FourDivisors {

    List<Integer> primes= getPrimesUpTo100000();
        public int sumFourDivisors(int[] nums) {

            int ans=0;
            for(int num:nums){
                int count=0;
                int sum=0;
                for(int prime:primes){
                    if(num%prime==0 && num!=prime){
                        sum+=prime;
                        count++;
                    }
                    if(prime>num|| count>2){


                        break;
                    }
                }
                if(count==2)
                {
                    ans+=sum+1+num;
                }


            }
            return ans;
        }



        public static List<Integer> getPrimesUpTo100000() {
            int n = 100000;
            boolean[] isPrime = new boolean[n + 1];
            Arrays.fill(isPrime, true);

            isPrime[0] = false;
            isPrime[1] = false;

            for (int i = 2; i * i <= n; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = false;
                    }
                }
            }

            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i <= n; i++) {
                if (isPrime[i]) {
                    primes.add(i);
                }
            }
            return primes;
        }





    public static void main(String[] args) {
        FourDivisors soln= new FourDivisors();
        System.out.println(soln.sumFourDivisors(new int[]{6,7,8,9,10}));
    }
}
