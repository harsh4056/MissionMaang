public class MaximumDistanceBetweenAPairOfValues {


        public int maxDistance(int[] nums1, int[] nums2) {
            int maxi=Integer.MIN_VALUE;
            for(int i=nums2.length-1;i>=0;i--){

                int l=0;
                int r=nums1.length;
                while(l<r){

                    int mid=(l+r)>>>1;
                    if(nums1[mid]<=nums2[i]){
                        r=mid;
                    }
                    else{
                        l=mid+1;
                    }
                }
                if(l<nums2.length){
                    maxi=Math.max(maxi,i-l);
                }
            }

            if(maxi<0) return 0;
            return maxi;

        }
    public static void main(String[] args) {
        int[] nums1 = {1};
        int[] nums2 = {10, 9, 8, 7};

        System.out.println(new MaximumDistanceBetweenAPairOfValues().maxDistance(nums1, nums2));
    }
}
