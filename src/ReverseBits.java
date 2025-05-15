import org.w3c.dom.ls.LSOutput;

public class ReverseBits {


    public int reverseBits(int n) {
        int num=n;
        num = ((num & 0xffff0000) >>> 16) | ((num & 0x0000ffff) << 16);
        num = ((num & 0xff00ff00) >>> 8) | ((num & 0x00ff00ff) << 8);
        num = ((num & 0xf0f0f0f0) >>> 4) | ((num & 0x0f0f0f0f) << 4);
        num = ((num & 0xcccccccc) >>> 2) | ((num & 0x33333333) << 2);
        num = ((num & 0xaaaaaaaa) >>> 1) | ((num & 0x55555555) << 1);

        return num;
    }

    public static void main(String[] args) {
        ReverseBits reverseBits= new ReverseBits();

        System.out.println(reverseBits.reverseBits(-3));
    }
/*
    *
    * // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result = (result << 1) | (n & 1); // Shift left and append the last bit of n
            n >>= 1; // Right shift n to process the next bit
        }
        return result;
    }
    * */
}
