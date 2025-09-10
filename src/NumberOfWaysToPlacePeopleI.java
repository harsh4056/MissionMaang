import java.util.*;

public class NumberOfWaysToPlacePeopleI {

    public int numberOfPairs(int[][] points) {
        int n=points.length;
        Arrays.sort(points,(a,b)->{
            if(a[0]==b[0]){
                return a[1]-b[1];
            }
            return b[0]-a[0];
        });
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x1=points[i][0];
                int y1=points[i][1];
                int x2=points[j][0];
                int y2=points[j][1];

                if(x1>x2 && y1<y2){
                    boolean found=false;
                    for(int k=0;k<n;k++){
                        if(k==i || k==j) continue;
                        int xk=points[k][0];
                        int yk=points[k][1];
                        if(x1>xk && xk>x2 && y1<yk && yk<y2){
                            found=true;
                            break;
                        }
                    }
                    if(!found)
                     count++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        NumberOfWaysToPlacePeopleI sol = new NumberOfWaysToPlacePeopleI();

        int[][] points1 = {{1,1},{2,2},{3,3}};
        //System.out.println(sol.numberOfPairs(points1)); // expected: 0

        int[][] points2 = {{6,2},{4,4},{2,6}};
        System.out.println(sol.numberOfPairs(points2)); // expected: 2

        int[][] points3 = {{3,1},{1,3},{1,1}};
        System.out.println(sol.numberOfPairs(points3)); // expected: 2
    }



}
