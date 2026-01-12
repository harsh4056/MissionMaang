public class SearchInARotatedSortedArray {
    public int search(int[] nums, int target) {
        int left=0;
        int right= nums.length-1;
        while(left<right){
            int mid=(left+right)>>>1;

            if(nums[left]<=nums[mid] ){
                if(nums[left]<=target && target<=nums[mid]){
                    right=mid;
                }

                else{
                    left=mid+1;
                }

            }
            else{
                if(nums[mid+1]<=target && target<=nums[right]){
                    left=mid+1;
                }
                else{
                    right=mid;
                }
            }

        }
        if(nums[left]==target) return left;
        return -1;
    }





    public static void main(String[] args) {
        SearchInARotatedSortedArray soln= new SearchInARotatedSortedArray();
        System.out.println(soln.search(new int[]{4,5,0,1,2},0));
    }
}
