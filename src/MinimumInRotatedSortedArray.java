public class MinimumInRotatedSortedArray {

    public int search(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int min=Integer.MAX_VALUE;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                min=Math.min(min,nums[left]);
                left = mid + 1;
            }
            // Right half must be sorted
            else {
                min=Math.min(min,nums[mid]);
                right = mid - 1;
            }
        }

        return min;
    }

    public static void main(String[] args) {
        MinimumInRotatedSortedArray minimumInRotatedSortedArray= new MinimumInRotatedSortedArray();
        System.out.println(
                minimumInRotatedSortedArray.search(new int[]{11,13,15,17}));
    }

}
