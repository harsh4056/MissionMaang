import java.util.*;

public class PacificAtlanticWaterFlow {

    public List<List<Integer>> pacificAtlantic(int[][] heights) {



        int n=heights.length;
        int m=heights[0].length;
        List<List<Integer>> pacificAtlantic= new ArrayList<>();


        Queue<int[]> bfsQueue= new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <m; j++) {
                boolean upperLeft=false;
                boolean bottomRight=false;
                bfsQueue.offer(new int[]{i,j});
                while (!bfsQueue.isEmpty()){
                    int[]curr= bfsQueue.poll();
                    int[]up=new int[]{curr[0]-1,curr[1]};
                    int[]down=new int[]{curr[0]+1,curr[1]};
                    int[]left=new int[]{curr[0],curr[1]-1};
                    int[]right=new int[]{curr[0],curr[1]+1};

                    if(up[0]==-1){
                        upperLeft=true;
                    }
                    else{
                        bfsQueue.offer(up);
                    }
                    if(down[0]==n) {
                        bottomRight = true;
                    }
                    else{
                        bfsQueue.offer(down);
                    }
                    if(left[1]==-1){
                        upperLeft=true;
                    }
                    else{
                        bfsQueue.offer(left);
                    }
                    if(right[0]==m) {
                        bottomRight = true;
                    }
                    else{
                        bfsQueue.offer(right);
                    }
                    if(bottomRight && upperLeft){
                        List<Integer> list= new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        pacificAtlantic.add(list);
                        break;
                    }
                }

            }
        }
        return pacificAtlantic;
    }
}
