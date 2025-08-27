import java.util.Arrays;

public class CapacityToShipPackageWithDDays {
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for (int weight : weights) {
            low=Math.max(low,weight);
            high+=weight;
        }
        int mid = 0;
        //Arrays.sort(weights);

        while (low<high) {
           int d=0;
           int w=0;
            mid=low+(high-low)/2;
            for (int weight : weights) {
               w+=weight;
               if(w==mid){
                   w=0;
                   d++;

               }
               else if(w>mid){
                   w=weight;
                   d++;
               }
            }
            if(w>0){
                d++;
            }

            if(d<=days){
                high=mid;
            }
            else{
                low=mid+1;
            }

        }
        return low;
    }
    public static void main(String[] args) {
        CapacityToShipPackageWithDDays sol = new CapacityToShipPackageWithDDays();

        int[] weights1 = {1,2,3,4,5,6,7,8,9,10};
        int days1 = 5;
        System.out.println(sol.shipWithinDays(weights1, days1));
        // Expected: 15

        int[] weights2 = {3,2,2,4,1,4};
        int days2 = 3;
        System.out.println(sol.shipWithinDays(weights2, days2));
        // Expected: 6

        int[] weights3 = {1,2,3,1,1};
        int days3 = 4;
        System.out.println(sol.shipWithinDays(weights3, days3));
        // Expected: 3
    }

}
