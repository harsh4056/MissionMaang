public class TribonacciNumber {

    public int tribonacci(int n) {
        int first=0;
        int second =1;
        int third=1;

        if(n==0)
            return first;
        if (n == 1) {
            return second;
        }
        if(n==2){
            return third;
        }
        for (int i = 3; i <=n ; i++) {
            int temp=first+second+third;
            first=second;
            second=third;
            third=temp;
        }
        return third;
    }
    public static void main(String[] args) {
        TribonacciNumber obj = new TribonacciNumber();

        // Test case 1
        int n1 = 4;
        System.out.println(obj.tribonacci(n1)); // Expected: 4

        // Test case 2
        int n2 = 25;
        System.out.println(obj.tribonacci(n2)); // Expected: 1389537

        // Test case 3
        int n3 = 0;
        System.out.println(obj.tribonacci(n3)); // Expected: 0
    }

}
