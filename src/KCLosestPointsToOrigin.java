import java.util.*;

public class KCLosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Unit> maxHeap= new PriorityQueue<>((a, b)->{
            return -compareDouble(a.distance,b.distance);
        });
        for(int[] point:points){
            Unit unit= new Unit(point,distance(point));
            maxHeap.offer(unit);
            while(maxHeap.size()>k){
                maxHeap.poll();
            }
        }


        int[][] answer= new int[k][2];
        for(int i=0;i<k;i++){
            answer[i]=maxHeap.poll().point;
        }
        return answer;

    }

    public int compareDouble(double a,double b){
        if(a<b){
            return -1;
        }
        else if(a>b){
            return 1;
        }
        return 0;
    }
    class Unit{
        int []point;

        double distance;
        Unit(int[]point,double distance){
            this.point=point;
            this.distance=distance;
        }

    }

    public double distance(int[] point){
        double x=point[0]-0.0;
        x=x*x;
        double y=point[1]-0.0;
        y=y*y;
        return Math.sqrt(x+y);
    }
}
