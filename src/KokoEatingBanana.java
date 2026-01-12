public class KokoEatingBanana {

    public int minEatingSpeed(int[] piles, int h) {
        int maxi=Integer.MIN_VALUE;
        for(int pile:piles){
            maxi=Math.max(maxi,pile);
        }
        int left=1;
        int right=maxi;
        while(left<right){
            int mid=(left+right)>>>1;
            int hours=hours(piles,mid);
            if(hours>=h){
                right=mid;
            }
            else{
                left=mid+1;
            }
        }
        return left;

    }
    public int hours(int[]piles,int b){
        int h=0;
        for(int pile:piles){
            h+=Math.ceilDiv(pile,b);
        }
        return h;
    }



    public static void main(String[] args) {
        KokoEatingBanana obj = new KokoEatingBanana();

        // Test case 1
        int[] piles1 = {312884470};
        int h1 = 312884469;
        //System.out.println(obj.minEatingSpeed(piles1, h1)); // Expected: 4

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
