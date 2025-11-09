import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximizeTheMinimumPoweredCity {
    public long maxPower(int[] stations, int r, int k) {
        int n=stations.length;

        PriorityQueue<int[]> minHeap= new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < stations.length; i++) {
            int station = stations[i];
            minHeap.offer(new int[]{station,i});
        }
        while (k>0){
            int[] can=minHeap.poll();
            stations[can[1]]++;
            can[0]++;
            minHeap.offer(can);
            k--;
        }


        long[]prefixSum=new long[n];
        long prev=0;
        for (int i = 0; i < stations.length; i++) {
            int station = stations[i];
            prefixSum[i]=prev+station;
            prev=prefixSum[i];
        }
        long []totalPower=new long[n];
        long min=Long.MAX_VALUE;
        for (int i = 0; i < totalPower.length; i++) {
            long back,front=0;
            if(i-r>0){
                int s=i - r-1;
                int f=i-1;
                back=prefixSum[f]-prefixSum[s];
            }
            else{
                if(i==0){
                    back=0;
                }
                else{
                    back=prefixSum[i-1];
                }
            }
            if(i!=n-1) {
                int s = i;
                int f = Math.min(i + r, n - 1);
                front = prefixSum[f] - prefixSum[s];
            }

            totalPower[i]=front+back+stations[i];
            min=Math.min(min,totalPower[i]);


        }

        return min;

    }

    public static void main(String[] args) {
        MaximizeTheMinimumPoweredCity soln= new MaximizeTheMinimumPoweredCity();
        System.out.println(soln.maxPower(new int[]{1,2,4,5,0},3,2));
        System.out.println(soln.maxPower(new int[]{1,2,4,5,0},1,2));
        System.out.println(soln.maxPower(new int[]{4,4,4,4},0,3));
    }
}
