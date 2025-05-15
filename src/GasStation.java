public class GasStation {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int totalCost = 0;

        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }

        // 🚨 If total gas is less than total cost, no solution is possible
        if (totalGas < totalCost) return -1;


        int startingPosition=0;
        int end=gas.length;
        int travelling=1;
        int runningSum=gas[startingPosition];

                while(travelling!=startingPosition ){

                    int costIndex=(travelling-1<0)? gas.length -1:travelling-1;
                    runningSum=runningSum-cost[(costIndex)];

                    if(runningSum<0)
                    {
                        startingPosition=(travelling)%gas.length;
                        travelling=(startingPosition+1)%gas.length;
                        runningSum=gas[startingPosition];

                    }
                    else {
                        travelling = (travelling + 1) % gas.length;
                        costIndex=(travelling-1<0)? gas.length -1:travelling-1;
                        runningSum+=gas[costIndex];
                    }

                }

        return startingPosition;
    }

    public static void main(String[] args) {
        int[] gas = {5,1,2,3,4};
        int[] cost = {4,4,1,5,1};

        int startIndex = canCompleteCircuit(gas, cost);
        System.out.println("Start index: " + startIndex);
    }

}
