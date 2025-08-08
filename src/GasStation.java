public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n=gas.length;
        for(int start=0;start<n;start++){

            int currentGas=gas[start];
            int currentStation=start;
            while(cost[currentStation]<=currentGas){
                currentGas-=cost[currentStation];
                currentGas+=gas[(currentStation+1)%n];
                currentStation=(currentStation+1)%n;
                if(currentStation==start){
                    return start;
                }
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        GasStation gs = new GasStation();

        int[] gas1 = {1,2,3,4,5};
        int[] cost1 = {3,4,5,1,2};
        System.out.println("Expected: 3, Got: " + gs.canCompleteCircuit(gas1, cost1));

        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};
        System.out.println("Expected: -1, Got: " + gs.canCompleteCircuit(gas2, cost2));

        int[] gas3 = {5,1,2,3,4};
        int[] cost3 = {4,4,1,5,1};
        System.out.println("Expected: 4, Got: " + gs.canCompleteCircuit(gas3, cost3));
    }


}
