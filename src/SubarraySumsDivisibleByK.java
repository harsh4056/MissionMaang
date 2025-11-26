import java.util.HashMap;
import java.util.Map;

public class SubarraySumsDivisibleByK {

    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);
        int sum=0;
        int count=0;
        for(int num:nums){
            sum+=num;
            int modded=((sum%k)+k)%k;
            if(map.containsKey(modded)){
                count+=map.get(modded);
            }
            map.put(modded,map.getOrDefault(modded,0)+1);
        }
        return count;

    }







    public static void printResult(int[] nums, int k) {
        SubarraySumsDivisibleByK obj = new SubarraySumsDivisibleByK();
        int result = obj.subarraysDivByK(nums, k);
        System.out.println("Result: " + result);
    }

    public static void main(String[] args) {

        // Test Case 1
        int[] nums1 = {-1,2,9};
        int k1 = 2;
        printResult(nums1, k1);  // Expected Output: 7

        // Test Case 2
        int[] nums2 = {5};
        int k2 = 9;
        printResult(nums2, k2);  // Expected Output: 0

        // Test Case 3
        int[] nums3 = {2, -2, 2, -4};
        int k3 = 6;
        printResult(nums3, k3);  // Expected Output: 2

    }

}
