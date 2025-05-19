public class PeakElement {

    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] < nums[mid + 1]) {
                // ascending slope
                left = mid + 1;
            } else {
                // descending slope
                right = mid;
            }
        }

        return left; // or right — both point to a peak
    }

}
