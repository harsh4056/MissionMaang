import java.util.HashSet;

public class BitwiseORofSubarrays {

    public int subarrayBitwiseORs(int[] arr) {
        HashSet<Integer> set= new HashSet<>();

        for(int num:arr){
            set.add(num);
        }

        for(int i=0;i<arr.length;i++){
            int result=0;
            for (int j=i;j<arr.length;j++){
                result|=arr[j];
                set.add(result);
            }
        }
        return set.size();

    }

    public static void main(String[] args) {
        BitwiseORofSubarrays solution = new BitwiseORofSubarrays();

        int[] test1 = {39,19,30,56,79,50,19,70,30};
        System.out.println(solution.subarrayBitwiseORs(test1)); // Expected: 1

        int[] test2 = {1,1,2};
        System.out.println(solution.subarrayBitwiseORs(test2)); // Expected: 3

        int[] test3 = {1,11,6,11};
        System.out.println(solution.subarrayBitwiseORs(test3)); // Expected: 4
    }

}
