public class MinimumPenaltyForAShop {
    public int bestClosingTime(String customers) {
        char[]cs= customers.toCharArray();
        int count=0;
        for (char c : cs) {
            if(c=='Y'){
                count++;
            }
        }
        int mini=count;
        int index=0;
        int yaccu=0;
        int naccu=0;
        for (int i = 1; i <= cs.length; i++) {
            char c = cs[i-1];
            if(c=='Y'){
                yaccu++;
            }
            else {
                naccu++;
            }
            if(mini>(count-yaccu+naccu)){
                mini=count-yaccu+naccu;
                index=i;
            }

        }
        return index;

    }
    public static void main(String[] args) {
        MinimumPenaltyForAShop obj = new MinimumPenaltyForAShop();

        // Test case 1
        String customers1 = "YYNY";
        System.out.println(obj.bestClosingTime(customers1)); // Expected: 2

        // Test case 2
        String customers2 = "NNNN";
        System.out.println(obj.bestClosingTime(customers2)); // Expected: 0

        // Test case 3
        String customers3 = "YYYY";
        System.out.println(obj.bestClosingTime(customers3)); // Expected: 4
    }

}
