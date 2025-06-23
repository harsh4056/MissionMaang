public class KokoEatingBanana {

    public int minEatingSpeed(int[] piles, int h) {
            int max=0;
        for (int pile : piles) {
            max=Math.max(max,pile);
        }
        int low=1;
        int high=max;

        int mid;

        while(low!=high){
            mid=low+(high-low)/2;
            int data=hoursNeeded(piles,mid);
            if(data<=h){
                high=mid;
            }
            else{
                low=mid+1;
            }

        }
        return low;
    }

    public int hoursNeeded(int[] piles, int candidate){
        int hours=0;
        for (int pile : piles) {
            hours+=Math.ceilDiv(pile,candidate);
        }
        return hours;
    }

    public static void main(String[] args) {
        KokoEatingBanana obj = new KokoEatingBanana();

        // Test case 1
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
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
