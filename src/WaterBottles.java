public class WaterBottles {

    public int numWaterBottles(int numBottles, int numExchange) {
        int sum=0;
        while(numBottles>0){

            int extra=numBottles/numExchange;
            if(extra>0){
                sum+=numExchange*extra;
                int remaining=numBottles%numExchange;
                numBottles=extra+remaining;
            }
            else{
               sum+=numBottles;
               numBottles=0;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        WaterBottles waterBottles= new WaterBottles();
        System.out.println(waterBottles.numWaterBottles(9,3));
    }
}
