public class MinimumTImeToCompleteTrips {

    public long minimumTime(int[] time, int totalTrips) {
        long low=Integer.MAX_VALUE;
        long high=0;
        for (int i : time) {
            low=Math.min(low,i);
        }
        high=low*totalTrips;




        while(low<high){

            long mid=low+(high-low)/2;
            long trips=0;
            for (int t : time) {
                trips+=mid/t;
            }
            if(trips>=totalTrips){
                high=mid;
            }
            else {
                low=mid+1;
            }

        }
        return low;
    }

    public static void main(String[] args) {
        MinimumTImeToCompleteTrips sol = new MinimumTImeToCompleteTrips();

        int[] time1 = {9,2};
        int totalTrips1 = 2;
        System.out.println(sol.minimumTime(time1, totalTrips1));
        // Expected: 3

        int[] time2 = {2};
        int totalTrips2 = 1;
        System.out.println(sol.minimumTime(time2, totalTrips2));
        // Expected: 2

        int[] time3 = {5,10,10};
        int totalTrips3 = 9;
        System.out.println(sol.minimumTime(time3, totalTrips3));
        // Expected: 25
    }

}
