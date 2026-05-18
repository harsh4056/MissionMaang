import java.util.*;

public class IntervalListIntersections {

    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list= new ArrayList<>();
        int p1=0;
        int p2=0;
        while(p1<firstList.length && p2<secondList.length){
            int fs=firstList[p1][0];
            int fe=firstList[p1][1];
            int ss=secondList[p2][0];
            int se=secondList[p2][1];

            //check if overlap
            if((fs<=ss || fe>=ss)|| (fs<=se ||fe>=se)){
                int[]ni= new int[2];
                ni[0]=Math.max(fs,ss);
                ni[1]=Math.min(fe,se);
                if(ni[0]<=ni[1])
                 list.add(ni);
            }
            if(se>=fe){
                p1++;
            }
            else{
                p2++;
            }
        }
        int[][]answer=new int[list.size()][2];
        int i=0;
        for(int[] curr: list){
            answer[i++]=curr;
        }
        return  answer;
    }

    public static void main(String[] args) {
        IntervalListIntersections obj = new IntervalListIntersections();

        int[][] first1 = {{0,2},{5,10},{13,23},{24,25}};
        int[][] second1 = {{1,5},{8,12},{15,24},{25,26}};
        print(obj.intervalIntersection(first1, second1));
        // Expected: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

        int[][] first2 = {{1,3},{5,9}};
        int[][] second2 = {};
        print(obj.intervalIntersection(first2, second2));
        // Expected: []

        int[][] first3 = {{1,7}};
        int[][] second3 = {{3,10}};
        print(obj.intervalIntersection(first3, second3));
        // Expected: [[3,7]]
    }

    private static void print(int[][] arr) {
        for (int[] a : arr) {
            System.out.print("[" + a[0] + "," + a[1] + "] ");
        }
        System.out.println();
    }
}
