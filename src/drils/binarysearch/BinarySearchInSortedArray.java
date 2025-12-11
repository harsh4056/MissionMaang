package drils.binarysearch;

public class BinarySearchInSortedArray {


        // 1. Exact Search (classic binary search)
        public static int exactSearch(int[] nums, int target) {
            int n=nums.length;
            int l=0;
            int r=n-1;

            while(l<r){
                int mid= l+(r-l)/2;
                if(nums[mid]>=target){
                    r=mid;
                }
                else{
                    l=mid+1;
                }
            }
            return nums[l]==target?l:-1;
        }

        // 2. Lower Bound (first index where nums[i] >= target)
        public static int lowerBound(int[] nums, int target) {
            int n=nums.length;
            int l=0;int r=n-1;
            while(l<r){
                int mid=l+(r-l)/2;
                if(nums[mid]>=target){
                    r=mid;
                }
                else{
                    l=mid+1;
                }
            }
            return nums[l]==target?l:-1;

        }

        // 3. Upper Bound (first index where nums[i] > target)
        public static int upperBound(int[] nums, int target) {
            int n= nums.length;
            int l=0;
            int r=n;
            while(l<r){
                int mid=l+(r-l)/2;
                if(nums[mid]>target){
                    r=mid;
                }
                else{
                    l=mid+1;
                }
            }
            return nums[l-1]==target?l-1:-1;
        }

        public static void main(String[] args) {
            int[] nums = {1, 2, 4, 4, 5,5,5};

            // --- Exact Search ---
            System.out.println("Exact Search:");
            System.out.println("target=4 → " + exactSearch(nums, 4)); // index of 4 (2 or 3)
            System.out.println("target=3 → " + exactSearch(nums, 3)); // -1 not found
            System.out.println("target=5 → " + exactSearch(nums, 5)); // -1 not found
            System.out.println("target=6 → " + exactSearch(nums, 6)); // -1 not found

            // --- Lower Bound ---
            System.out.println("\nLower Bound:");
            System.out.println("target=4 → " + lowerBound(nums, 4)); // 2
            System.out.println("target=3 → " + lowerBound(nums, 3)); // -1
            System.out.println("target=5 → " + lowerBound(nums, 5)); // 2
            System.out.println("target=6 → " + lowerBound(nums, 6)); // -1 (nums.length)

            // --- Upper Bound ---
            System.out.println("\nUpper Bound:");
            System.out.println("target=4 → " + upperBound(nums, 4)); // 4 (after last 4)
            System.out.println("target=3 → " + upperBound(nums, 3)); // -1
            System.out.println("target=5 → " + upperBound(nums, 5)); // 6
            System.out.println("target=6 → " + upperBound(nums, 6)); // -1 (nums.length)
        }





}
