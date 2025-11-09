public class MinimumOneBitOperations {
    public int minimumOneBitOperations(int n) {
        int pos=0;
        for (int i = 0;i<32;i++) {
            int x=1<<i;
            if((x & n)>0){
                pos=x<<1;
            }
        }
        int diff= n-(pos>>1);
        return diff+(pos>>1);
    }

    public static void main(String[] args) {
        MinimumOneBitOperations soln= new MinimumOneBitOperations();
        System.out.println(soln.minimumOneBitOperations(11));
        System.out.println(soln.minimumOneBitOperations(8));
    }
}
