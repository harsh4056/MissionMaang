public class MaxDifferenceIncreasingElements {

    public int maximumDifference(int[] nums) {
        int min=Integer.MAX_VALUE;
        int profit=0;
        for(int price:nums){
            if(price<min)
            {
                min=price;
            }
            if(price-min>profit){
                profit=price-min;
            }
        }
        if(profit==0)
            return -1;
        return profit;
    }
    public static void main(String[] args) {
        MaxDifferenceIncreasingElements solver = new MaxDifferenceIncreasingElements();

        System.out.println(solver.maximumDifference(new int[]{7,1,5,4})); // Expected: 4
        System.out.println(solver.maximumDifference(new int[]{9,4,3,2})); // Expected: -1
        System.out.println(solver.maximumDifference(new int[]{1,5,2,10})); // Expected: 9
        System.out.println(solver.maximumDifference(new int[]{999,997,980,976,948,940,938,928,924,917,907,907,881,878,864,862,859,857,848,840,824,824,824,805,802,798,788,777,775,766,755,748,735,732,727,705,700,697,693,679,676,644,634,624,599,596,588,583,562,558,553,539,537,536,509,491,485,483,454,449,438,425,403,368,345,327,287,285,270,263,255,248,235,234,224,221,201,189,187,183,179,168,155,153,150,144,107,102,102,87,80,57,55,49,48,45,26,26,23,15})); // Expected: -1
    }

}
