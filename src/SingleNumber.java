public class SingleNumber {
    public int singleNumber(int[] nums) {
        int val=0;
        for (int num : nums) {
            val=val^num;
        }
        return val;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber= new SingleNumber();
        System.out.println(singleNumber.singleNumber(new int[]{4,1,2,1,2}));

    }
}
