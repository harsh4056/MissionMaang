import java.util.*;

public class MinimumCostOfBuyingCandiesWithDiscount {

    public int minimumCost(int[] cost) {
        int n=cost.length;

        if(n==1) return cost[0];
        if(n==2) return cost[0]+cost[1];
        Arrays.sort(cost);

        int totalCost=0;
        int i=0;
       while(i<n){
            if(i+2<n){
                totalCost+=cost[i+1]+cost[i+2];
                i=i+3;
            }
            else{
                totalCost+=cost[i];
                i++;
            }
        }
        return totalCost;
    }

    public static void main(String[] args) {
        MinimumCostOfBuyingCandiesWithDiscount soln= new MinimumCostOfBuyingCandiesWithDiscount();
        System.out.println(soln.minimumCost(new int[]{6,5,7,9,2,2}));
    }
}
