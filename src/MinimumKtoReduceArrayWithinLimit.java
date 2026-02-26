public class MinimumKtoReduceArrayWithinLimit {

    public int minimumK(int[] nums) {
        long r=0;
        for (int num : nums) {
            r+=num;
        }
        long l=1;
        while (l<r){
            long mid=(l+r)>>>1;
            long val=nonPositive(nums,mid);
            if(val<=(mid *mid)){
                r=mid;
            }
            else{
                l=mid+1;
            }
        }
        return Math.toIntExact(l);


    }
    public long nonPositive(int[]nums, long k){
        long val=0;
        for (int num : nums) {
           val+=Math.ceilDiv(num,k);
        }
        return val;
    }
    public static void main(String[] args) {
        MinimumKtoReduceArrayWithinLimit obj = new MinimumKtoReduceArrayWithinLimit();

        int[] nums3 = {100000};
        System.out.println(obj.minimumK(nums3));
        // Expected: 3

        int[] nums2 = {3, 7, 5};
        System.out.println(obj.minimumK(nums2));
        // Expected: 3

        int[] nums1 = {1, 2, 3, 4};
        System.out.println(obj.minimumK(nums1));
        // Expected: 2




    }
}
