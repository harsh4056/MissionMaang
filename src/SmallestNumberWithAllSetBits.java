public class SmallestNumberWithAllSetBits {
    public int smallestNumber(int n) {
        int x=1;
        for(int i=0;i<32;i++){
            int temp=x<<i;
            if((temp-1)>=n) return temp-1;
        }
        return 0;
    }

    public static void main(String[] args) {
        SmallestNumberWithAllSetBits soln= new SmallestNumberWithAllSetBits();
        System.out.println(soln.smallestNumber(12));
    }
}
