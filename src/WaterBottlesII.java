public class WaterBottlesII {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total=numBottles;
        int i=numExchange;
        while(i<=numBottles){
            numBottles-=i;
            i++;
            total++;
            numBottles++;
        }

        return total;
    }

    public static void main(String[] args) {
        WaterBottlesII soln= new WaterBottlesII();
        System.out.println(soln.maxBottlesDrunk(10,3));
    }
}
