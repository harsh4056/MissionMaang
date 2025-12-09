import java.util.ArrayList;
import java.util.List;

public class FurthestBuildingYouCanReach {

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n=heights.length;
        List<int[]> differences= new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if(heights[i-1]<heights[i]){
                differences.add(new int[]{heights[i]-heights[i-1],i});
            }
        }
        int reached=0;
        for (int[] diff:differences) {
            if(diff[0]<=bricks){
                bricks-=diff[0];
                reached=diff[1];
            }
            else if(ladders>0){
                ladders--;
                reached=diff[1];
            }
            else {
                break;
            }
        }
        while (reached<n-1 ){
            if(heights[reached]>=heights[reached+1]){
                reached++;
            }
            else{
                break;
            }
        }
        return reached;

    }

    public static void main(String[] args) {
        FurthestBuildingYouCanReach soln= new FurthestBuildingYouCanReach();
        System.out.println(soln.furthestBuilding(new int[]{1,5,1,2,3,4,10000},4,1));//5
    }
}
