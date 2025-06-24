public class MinimumBitFlipsToMakeCFromAB {
    public int minFlips(int a, int b, int c) {
        int count=0;
        for (int i = 0; i < 32; i++) {
            boolean aBit=(a>>i&1)==1;
            boolean bBit=(b>>i&1)==1;
            boolean cBit=(c>>i&1)==1;
            if(cBit!= (aBit|bBit)) {
                if (cBit) {
                    count++;

                } else {
                    if (aBit && bBit) {
                        count += 2;
                    }
                    else{
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        MinimumBitFlipsToMakeCFromAB solution = new MinimumBitFlipsToMakeCFromAB();

        System.out.println(solution.minFlips(2, 6, 5)); // Expected: 3
        System.out.println(solution.minFlips(4, 2, 7)); // Expected: 1
        System.out.println(solution.minFlips(8, 3, 5)); // Expected: 3
    }

}
