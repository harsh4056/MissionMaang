public class UniqueNumberOccurrences {


    public boolean uniqueOccurrences(int[] arr) {
        int[]nums= new int[2001];

        for (int i : arr) {
           nums[i+1000]++;
        }
        int[] counter= new int[2001];
        for (int i = 0; i <2001; i++) {
            if(nums[i]!=0)
             counter[nums[i]]++;
        }

        for (int i : counter) {
            if(i>1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        UniqueNumberOccurrences solution = new UniqueNumberOccurrences();


        int[] test2 = {2,2};
        System.out.println(solution.uniqueOccurrences(test2));  // Expected: false

        int[] test3 = {-3,0,1,-3,1,1,1,-3,10,0};
        System.out.println(solution.uniqueOccurrences(test3));  // Expected: true
    }


}
