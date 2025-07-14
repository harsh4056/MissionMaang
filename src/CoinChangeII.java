public class CoinChangeII {

    public int change(int amount, int[] coins) {
        return dfs(amount,coins,0,0);
    }

    public int dfs(int amount, int[] coins,int index,int prev){

        if(amount<0 || index>=coins.length){
            return 0;
        }
        if(amount==0){
            return 1;
        }


        int notTake=dfs(amount-coins[index],coins,index-1,coins[index]);
        int take=dfs(amount-coins[index],coins,index,coins[index]);
        return take+notTake;

    }
    public static void main(String[] args) {
        CoinChangeII solution = new CoinChangeII();

        System.out.println(solution.change(5, new int[]{1, 2, 5})); // Expected: 4
        System.out.println(solution.change(3, new int[]{2}));       // Expected: 0
        System.out.println(solution.change(10, new int[]{10}));     // Expected: 1
    }

}
