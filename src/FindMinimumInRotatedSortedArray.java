public class FindMinimumInRotatedSortedArray {

        public int findMin(int[] nums) {
            int left=0;
            int right=nums.length-1;
            int mini=Integer.MAX_VALUE;
            while(left<=right){
                int mid=(left+right)>>>1;
                if(nums[left]<=nums[mid]){
                    mini=Math.min(mini,nums[left]);
                    left=mid+1;
                }
                else{
                    mini=Math.min(mini,nums[mid+1]);
                    right=mid;
                }



            }
            return mini;
        }


}
