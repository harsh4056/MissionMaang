public class MaximumCandiesAllottedToKChildren {
    public int maximumCandies(int[] candies, long k) {
        int low=1;
        int high=0;
        for (int candy : candies) {
            high=Math.max(high,candy);
        }

        while (low < high) {
            int mid = low + (high - low + 1) / 2;
            long children = 0;
            for (int candy : candies) {
                children += candy / mid;
            }

            if (children >= k) {
                low = mid;   // mid-works, try higher
            } else {
                high = mid - 1; // too big
            }
        }
        return low;


    }

    public static void main(String[] args) {
        MaximumCandiesAllottedToKChildren sol = new MaximumCandiesAllottedToKChildren();

        int[] candies1 = {5, 8, 6};
        long k1 = 3;
        //System.out.println(sol.maximumCandies(candies1, k1));
        // Expected: 5 (Each child can get 5, 3 children possible)

        int[] candies2 = {2, 5, 7, 10};
        long k2 = 5;
        System.out.println(sol.maximumCandies(candies2, k2));
        // Expected: 3 (Each child can get 3 candies, 5 children possible)

        int[] candies3 = {1, 2, 3};
        long k3 = 5;
        System.out.println(sol.maximumCandies(candies3, k3));
        // Expected: 1 (At most 5 children can get 1 candy each)
    }

}
