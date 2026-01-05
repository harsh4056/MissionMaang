import java.util.PriorityQueue;

public class MaximumPopulationYear {

    public int maximumPopulation(int[][] logs) {
        PriorityQueue<int[]> minHeap= new PriorityQueue<>((a, b)->{
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        for(int[]log:logs){
            int[] curr1= new int[]{log[0],1};
            int[] curr2= new int[]{log[1],-1};
            minHeap.offer(curr1);
            minHeap.offer(curr2);
        }
        int val=0;
        int maxi=0;
        int year=0;
        while(!minHeap.isEmpty()){
            int[]curr= minHeap.poll();
            val+=curr[1];
            if(val>maxi){
                maxi=val;
                year=curr[0];
            }
        }
        return year;
    }

    public static void main(String[] args) {
        MaximumPopulationYear soln = new MaximumPopulationYear();
        int[][] logs = {
                {2008, 2026},
                {2004, 2008},
                {2034, 2035},
                {1999, 2050},
                {2049, 2050},
                {2011, 2035},
                {1966, 2033},
                {2044, 2049}
        };

        System.out.println(soln.maximumPopulation(logs));
        // Expected: 2011


        int[][] logs3 = {
                {2001, 2005},
                {2002, 2003},
                {2003, 2004}
        };
        System.out.println(soln.maximumPopulation(logs3));
        // Expected: 2003


        int[][] logs1 = {
                {1993, 1999},
                {2000, 2010}
        };
        System.out.println(soln.maximumPopulation(logs1));
        // Expected: 1993

        int[][] logs2 = {
                {1950, 1961},
                {1960, 1971},
                {1970, 1981}
        };
        System.out.println(soln.maximumPopulation(logs2));
        // Expected: 1960


    }

}
