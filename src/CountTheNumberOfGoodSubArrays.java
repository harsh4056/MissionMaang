import java.util.*;

public class CountTheNumberOfGoodSubArrays {

    public long countGood(int[] nums, int k) {
        int n=nums.length;
        Map<Integer,Long> map= new HashMap<>();
        int l=0,r=0;
        long cp=0;
        long total=0;
        for(r=0;r<n;r++){


            if(map.getOrDefault(nums[r],0L)+1>1L){
                long a=   map.getOrDefault(nums[r],0L);
                long b=a+1;
                cp+=((b*(b-1))/2)-((a*(a-1))/2);
            }
            map.put(nums[r],map.getOrDefault(nums[r],0L)+1);
            while(cp>=k){
                total+=n-r;
                if(map.getOrDefault(nums[l],0L)>1){
                    long a=   map.getOrDefault(nums[l],0L);
                    long b=a-1;
                    cp-=((a*(a-1))/2)-((b*(b-1))/2);

                }
                map.put(nums[l],map.getOrDefault(nums[l],0L)-1);
                l++;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        CountTheNumberOfGoodSubArrays solution = new CountTheNumberOfGoodSubArrays();

        // Test case 1
        int[] nums1 = {3,1,4,3,2,2,4};
        int k1 = 2;
        //System.out.println("Output 1: " + solution.countGood(nums1, k1));

        // Test case 2
        int[] nums2 = {1, 1, 1, 1, 1};
        int k2 = 10;
        System.out.println("Output 2: " + solution.countGood(nums2, k2));

        // Test case 3
        int[] nums3 = {1, 2, 3, 4};
        int k3 = 1;
        System.out.println("Output 3: " + solution.countGood(nums3, k3));

        // Test case 4
        int[] nums4 = {1, 2, 2, 1, 2};
        int k4 = 2;
        System.out.println("Output 4: " + solution.countGood(nums4, k4));
    }
}
