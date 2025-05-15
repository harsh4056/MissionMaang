public class SingleNumberII {


    public int singleNumber(int[] nums) {
        int[] bitAddStore = new int[32];

        // Step 1: Add up all bits
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bitAddStore[i] += (num >> i) & 1;
            }
        }

        // Step 2: Build result from bits that are not multiples of 3
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bitAddStore[i] % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        SingleNumberII singleNumber= new SingleNumberII();
        System.out.println(singleNumber.singleNumber(new int[]{2,2,3,2}));

    }
}
