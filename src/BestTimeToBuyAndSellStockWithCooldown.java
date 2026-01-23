import java.util.Arrays;

public class BestTimeToBuyAndSellStockWithCooldown {

    public int maxProfit(int[] prices) {
        return solve(prices,0,1);
    }

    public int solve(int[]nums,int index,int last){
        if(index>=nums.length){
            return 0;
        }
        int take=0;
        if(last>0){
            take=-nums[index]+solve(nums,index+1,-1);
        }
        else{
            take=nums[index]+solve(nums,index+2,1);
        }
        int skip=solve(nums,index+1,last);

        return Math.max(take,skip);
    }
    public static void main(String[] args) {
        BestTimeToBuyAndSellStockWithCooldown solution = new BestTimeToBuyAndSellStockWithCooldown();

        System.out.println(solution.maxProfit(new int[]{1,2,3,0,2})); // Expected: 3
        System.out.println(solution.maxProfit(new int[]{1})); // Expected: 0
        System.out.println(solution.maxProfit(new int[]{2,1,4})); // Expected: 3
    }

}
