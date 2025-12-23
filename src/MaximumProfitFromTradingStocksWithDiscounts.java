import java.util.*;

public class MaximumProfitFromTradingStocksWithDiscounts {

    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {

        List<List<Integer>> graph= new ArrayList<>();
        for (int i = 0; i <= present.length; i++) {
            graph.add(new ArrayList<>());

        }
        for (int[] h : hierarchy) {
            graph.get(h[0]).add(h[1]);
        }
        return dfs(present,future,false,budget,1,graph);

    }

    public int dfs(int[] present, int[] future,boolean parentTook, int budget, int node,  List<List<Integer>> graph){
        if(budget<=0) return 0;
        int take=0;
        int cost=0;
        if(parentTook){
            cost=Math.floorDiv(present[node-1],2);
        }
        else {
            cost=present[node-1];
        }
        if(budget-cost>=0)
         take=future[node-1]-cost;
        int skip=0;
        for(int nei:graph.get(node)){
            take+=dfs(present,future,true,budget-cost,nei,graph);
            skip+=dfs(present,future,false,budget,nei,graph);
        }
        return Math.max(take,skip);
    }

    /*
        *
        * n =
3
present =
[26,17,11]
future =
[40,46,13]
hierarchy =
[[1,3],[3,2]]
budget =
98
        * */
    public static void main(String[] args) {
        MaximumProfitFromTradingStocksWithDiscounts sol =
                new MaximumProfitFromTradingStocksWithDiscounts();

        // Test case 1
        /*int n1 = 3;
        int[] present1 = {26,17,11};
        int[] future1 = {40, 46,13};
        int[][] hierarchy1 = {{1, 3},{3,2}};
        int budget1 = 98;
        System.out.println(sol.maxProfit(n1, present1, future1, hierarchy1, budget1));*/
        // Expected: 60

        // Test case 2
        int n2 = 2;
        int[] present2 = {3, 4};
        int[] future2 = {5, 8};
        int[][] hierarchy2 = {{1, 2}};
        int budget2 = 4;
        //System.out.println(sol.maxProfit(n2, present2, future2, hierarchy2, budget2));
        // Expected: 4

        // Test case 3
        int n3 = 3;
        int[] present3 = {4, 6, 8};
        int[] future3 = {7, 9, 11};
        int[][] hierarchy3 = {{1, 2}, {1, 3}};
        int budget3 = 10;
        System.out.println(sol.maxProfit(n3, present3, future3, hierarchy3, budget3));
        // Expected: 10

        // Test case 4
        int n4 = 3;
        int[] present4 = {5, 2, 3};
        int[] future4 = {8, 5, 6};
        int[][] hierarchy4 = {{1, 2}, {2, 3}};
        int budget4 = 7;
        System.out.println(sol.maxProfit(n4, present4, future4, hierarchy4, budget4));
        // Expected: 12
    }

}
