public class MinimumOperationsToMakeIntegerZero {
    public int makeTheIntegerZero(int num1, int num2) {

        for (int k = 1; k <=60; k++) {
            int R=num1-(k*num2);
            int popCount=0;
            for(int i=0;i<32;i++)
            {
                if(((R>>i)&1)==1){
                    popCount++;
                }

            }
            if(popCount<=k && R>=k){
                return k;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        MinimumOperationsToMakeIntegerZero soln= new MinimumOperationsToMakeIntegerZero();
        System.out.println(soln.makeTheIntegerZero(3,-2));
    }

}
