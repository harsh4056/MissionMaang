public class SetMismatch {

    public int[] findErrorNums(int[] nums) {
        int[] counts = new int[nums.length+1];
        int[] answer= new int[2];

        for (int i = 1; i < counts.length; i++) {
            counts[nums[i-1]]++;
            if(counts[i]==0){
                answer[1]=i;
            }
            if(counts[i]==2){
                answer[0]=i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        SetMismatch sm = new SetMismatch();

        int[] result1 = sm.findErrorNums(new int[]{1,2,2,4});
        System.out.println(java.util.Arrays.toString(result1)); //

        int[] result2 = sm.findErrorNums(new int[]{3,2,2});
        System.out.println(java.util.Arrays.toString(result2)); // Expected: [2, 1]

        int[] result3 = sm.findErrorNums(new int[]{2, 2});
        System.out.println(java.util.Arrays.toString(result3)); // Expected: [2, 1]
    }

}
