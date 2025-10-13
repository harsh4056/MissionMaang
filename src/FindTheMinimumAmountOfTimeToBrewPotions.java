public class FindTheMinimumAmountOfTimeToBrewPotions {

    public long minTime(int[] skill, int[] mana) {
        int n= skill.length;
        long[] ct= new long[n];
        long prev=0;
        for(int m:mana){
            long totalTimeSum=0;
            prev=ct[0];
            for (int i = 0; i < n; i++) {
                long time=(long)m*skill[i];
                totalTimeSum+=time;
                ct[i]=Math.max(ct[i],prev)+time;
                prev=ct[i];

            }
            long startFrom=ct[n-1]-totalTimeSum;
            for (int i = 0; i < n; i++) {
                long time=(long)m*skill[i];
                ct[i]=time+startFrom;
                startFrom=ct[i];
            }

        }
        return ct[n-1];
    }

    public static void main(String[] args) {
        FindTheMinimumAmountOfTimeToBrewPotions soln= new FindTheMinimumAmountOfTimeToBrewPotions();
        System.out.println(soln.minTime(new int[]{1,5,2,4},new int[]{5,1,4,2}));
        System.out.println(soln.minTime(new int[]{1,1,1},new int[]{1,1,1}));
        System.out.println(soln.minTime(new int[]{1,2,3,4},new int[]{1,2}));
    }
}
