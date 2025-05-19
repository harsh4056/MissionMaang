public class FirstAndLastPositionInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int arr[]=new int[]{-1,-1};
        int left=0;
        int right =nums.length-1;
        int mid=0;
        while(left<=right){

            mid = left+(right-left)/2;
            if(nums[mid]==target){
                if(mid-1<0 ){
                    arr[0]=mid;
                    break;
                }

                else if( nums[mid-1]!=target){
                    arr[0]=mid;
                    break;
                }

                right=mid-1;
            }


            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }



        left=0;
        right =nums.length-1;
        mid=0;
        while(left<=right){

            mid = left+(right-left)/2;
            if(nums[mid]==target){
                if(mid+1>=nums.length){
                    arr[1]=mid;
                    break;
                }

                else if (nums[mid+1]!=target ){
                    arr[1]=mid;
                    break;
                }

                left=mid+1;
            }


            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }

        return arr;


    }

    public static void main(String[] args) {
        FirstAndLastPositionInSortedArray solution = new FirstAndLastPositionInSortedArray();
        solution.searchRange(new int[]{1},1);
    }
}
