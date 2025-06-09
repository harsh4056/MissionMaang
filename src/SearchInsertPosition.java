public class SearchInsertPosition {


    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;

    }

    public static void main(String[] args) {
        SearchInsertPosition s= new SearchInsertPosition();
        System.out.println(s.searchInsert(new int[]{1,3,5,6},7));
    }

}
