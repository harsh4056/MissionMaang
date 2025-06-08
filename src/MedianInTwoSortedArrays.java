public class MedianInTwoSortedArrays {



        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            // Always binary search on smaller array
            if (nums1.length > nums2.length) {
                return findMedianSortedArrays(nums2, nums1);
            }

            int m = nums1.length;
            int n = nums2.length;
            int totalLeft = (m + n + 1) / 2;

            int left = 0;
            int right = m;

            while (left <= right) {
                int i = (left + right) / 2;
                int j = totalLeft - i;

                int maxLeftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
                int minRightA = (i == m) ? Integer.MAX_VALUE : nums1[i];

                int maxLeftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
                int minRightB = (j == n) ? Integer.MAX_VALUE : nums2[j];

                if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                    if ((m + n) % 2 == 0) {
                        return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                    } else {
                        return Math.max(maxLeftA, maxLeftB);
                    }
                } else if (maxLeftA > minRightB) {
                    right = i - 1;  // move left
                } else {
                    left = i + 1;   // move right
                }
            }

            // This should never be reached if inputs are valid
            throw new IllegalArgumentException("Input arrays are not sorted or invalid");
        }

        public static void main(String[] args) {
            MedianInTwoSortedArrays solver = new MedianInTwoSortedArrays();

            int[] nums1 = {1, 2, 3, 4, 5, 6};
            int[] nums2 = {7, 8, 9, 10, 11};
            System.out.println(solver.findMedianSortedArrays(nums1, nums2)); // Output: 6.0

            int[] nums3 = {2, 4, 4, 8};
            int[] nums4 = {1, 3, 4, 4, 7, 9, 9, 12};
            System.out.println(solver.findMedianSortedArrays(nums3, nums4)); // Output: 4.0
        }


}
