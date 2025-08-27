public class KokoEatingBanana {

    public int minEatingSpeed(int[] piles, int h) {

        int low=1;
        int high=Integer.MIN_VALUE;
        for (int pile : piles) {

            high=Math.max(high,pile);
        }
        int mid = 0;

        int hours=0;
        while (low<high) {
            hours=0;
             mid=low+(high-low)/2;
            for (int pile : piles) {
                int hour=Math.ceilDiv(pile,mid);
                hours+=hour;
            }

            if(hours<=h){
                high=mid;
            }
            else{
                low=mid+1;
            }

        }
        return low;

    }



    public static void main(String[] args) {
        KokoEatingBanana obj = new KokoEatingBanana();

        // Test case 1
        int[] piles1 = {312884470};
        int h1 = 312884469;
        System.out.println(obj.minEatingSpeed(piles1, h1)); // Expected: 4

        // Test case 2
        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println(obj.minEatingSpeed(piles2, h2)); // Expected: 30

        // Test case 3
        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println(obj.minEatingSpeed(piles3, h3)); // Expected: 23
    }

}
