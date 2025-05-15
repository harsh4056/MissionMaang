public class NumberOf1Bits {

    public int hammingWeight(int n) {
        int result=0;
        int count=0;
        for (int i = 0; i < 32; i++) {

            result=n&1;
            if(result==1){
                count++;
            }
            n=n>>1;

        }
        return count;
    }


    public static void main(String[] args) {
        NumberOf1Bits numberOf1Bits= new NumberOf1Bits();
        System.out.println(numberOf1Bits.hammingWeight(2147483645));
    }
}
