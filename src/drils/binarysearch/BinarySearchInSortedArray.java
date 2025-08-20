package drils.binarysearch;

public class BinarySearchInSortedArray {


        // 1. Exact Search (classic binary search)
        public static int exactSearch(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] == target) return mid;
                else if (nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
            return -1; // not found
        }

        // 2. Lower Bound (first index where nums[i] >= target)
        public static int lowerBound(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] < target) left = mid + 1;
                else right = mid;
            }
            return left; // could be nums.length if no element >= target
        }

        // 3. Upper Bound (first index where nums[i] > target)
        public static int upperBound(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) left = mid + 1;
                else right = mid;
            }
            return left; // could be nums.length if all <= target
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 4, 4, 5};

            // --- Exact Search ---
            System.out.println("Exact Search:");
            System.out.println("target=4 → " + exactSearch(nums, 4)); // index of 4 (2 or 3)
            System.out.println("target=3 → " + exactSearch(nums, 3)); // -1 not found
            System.out.println("target=6 → " + exactSearch(nums, 6)); // -1 not found

            // --- Lower Bound ---
            System.out.println("\nLower Bound:");
            System.out.println("target=4 → " + lowerBound(nums, 4)); // 2
            System.out.println("target=3 → " + lowerBound(nums, 3)); // 2
            System.out.println("target=6 → " + lowerBound(nums, 6)); // 5 (nums.length)

            // --- Upper Bound ---
            System.out.println("\nUpper Bound:");
            System.out.println("target=4 → " + upperBound(nums, 4)); // 4 (after last 4)
            System.out.println("target=3 → " + upperBound(nums, 3)); // 2
            System.out.println("target=6 → " + upperBound(nums, 6)); // 5 (nums.length)
        }





}
