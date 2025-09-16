public class FindTheKBeautyOfNumber {
    public int divisorSubstrings(int num, int k) {
        String string=""+num;
        char[] arr=string.toCharArray();
        int n=arr.length;
        int count=0;
        for(int i=k;i<=n;i++){
            String curr=new String(arr,i-k,k);
            int currInt=Integer.parseInt(curr);
            if(currInt>0&& num%currInt==0 ){
                count++;
            }

        }
        return count;

    }
    public int gcd(int a,int b){
        if(a%b==0) return b;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        FindTheKBeautyOfNumber solution = new FindTheKBeautyOfNumber();

        // Test case 1
        int result1 = solution.divisorSubstrings(30003, 3);
        System.out.println(result1); // Expected output: 2

        // Test case 2
        int result2 = solution.divisorSubstrings(430043, 2);
        System.out.println(result2); // Expected output: 2

        // Test case 3
        int result3 = solution.divisorSubstrings(100, 1);
        System.out.println(result3); // Expected output: 1
    }


}
