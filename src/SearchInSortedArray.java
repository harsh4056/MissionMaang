public class SearchInSortedArray {


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target is in left sorted half
                } else {
                    left = mid + 1;  // target is in right half
                }
            }
            // Right half must be sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;  // target in right sorted half
                } else {
                    right = mid - 1; // target in left half
                }
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        SearchInSortedArray solution= new SearchInSortedArray();
        System.out.println(
        solution.search(new int[]{1,3},1));
    }
}
