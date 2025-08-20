import java.util.*;

public class MinimumNumberOfDaysToMakemBouqets {

    public int minDays(int[] bloomDay, int m, int k) {
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();

        HashSet<Integer> set= new HashSet<>();
        for(int day:bloomDay){
            set.add(day);
        }
        for(int day:set){
            minHeap.offer(day);
        }
        int []arr=new int[minHeap.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=minHeap.poll();
        }
        int lastDay=-1;
        int left=0;
        int right= arr.length-1;
        int mid;
        int bouqet = 0;
        while(left<right){
            mid=left+(right-left)/2;
            int curr=arr[mid];
            bouqet=0;
            int flower=0;
            for(int i=0;i<bloomDay.length;i++){
                if(bloomDay[i]<=curr){
                    bloomDay[i]=-1;
                    flower++;
                    if((flower/k)==1){
                        bouqet++;
                        flower=0;
                    }
                }
                else{
                    flower=0;
                }
            }
            if(bouqet>m){
                right=mid-1;
            }
            else if(bouqet<m){
                left=mid+1;
            }


        }
            if(bouqet<m){
                return -1;
            }
        return arr[left];
    }

    public static void main(String[] args) {
        MinimumNumberOfDaysToMakemBouqets sol = new MinimumNumberOfDaysToMakemBouqets();

        int[] bloomDay1 = {1,10,3,10,2};
        System.out.println(sol.minDays(bloomDay1, 4, 2)); // Expected: 3

        int[] bloomDay2 = {1,10,3,10,2};
        System.out.println(sol.minDays(bloomDay2, 3, 2)); // Expected: 10

        int[] bloomDay3 = {7,7,7,7,12,7,7};
        System.out.println(sol.minDays(bloomDay3, 2, 3)); // Expected: 12
    }

}
