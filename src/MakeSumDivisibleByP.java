import java.util.HashMap;

public class MakeSumDivisibleByP {
    public int minSubarray(int[] nums, int p) {
        long sum=0;
        for(int num:nums){
            sum+=(num%p);
        }

        int k= Math.toIntExact(sum % p);
        if(k==0) return 0;
        int len=nums.length;
        int  prefixSum=0;
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        hashMap.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            prefixSum=(prefixSum+num)%p;
            int need=(prefixSum-k+p)%p;
            if(hashMap.containsKey(need)){
                int idx=hashMap.get(need);
                len=Math.min(len,i-idx);
            }
            hashMap.put(prefixSum,i);
        }
        if(len==nums.length)return -1;
        return len;

    }

    public static void main(String[] args) {
        MakeSumDivisibleByP sol = new MakeSumDivisibleByP();

        // Test Case 2
        int[] nums2 = {26,19,11,14,18,4,7,1,30,23,19,8,10,6,26,3};
        int p2 = 26;
        System.out.println("Result 2: " + sol.minSubarray(nums2, p2));
        // Expected: 2

        // Test Case 1
        int[] nums1 = {3, 1, 4, 2};
        int p1 = 6;
        System.out.println("Result 1: " + sol.minSubarray(nums1, p1));
        // Expected: 1



        // Test Case 3
        int[] nums3 = {6,3,5,2};
        int p3 = 9;
        System.out.println("Result 3: " + sol.minSubarray(nums3, p3));
        // Expected: 0
    }

}
