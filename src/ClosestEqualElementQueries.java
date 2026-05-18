import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class ClosestEqualElementQueries {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        HashMap<Integer, TreeSet<Integer>> hashMap= new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            hashMap.putIfAbsent(num,new TreeSet<>());
            hashMap.get(num).add(i);
        }
        int n= nums.length;
        List<Integer> answer= new ArrayList<>();
        for (int query : queries) {
            int qNum= nums[query];
            int res;
            TreeSet<Integer> treeSet= hashMap.get(qNum);
            Integer lower= treeSet.lower(query);
            Integer higher= treeSet.higher(query);
            if(higher==null && lower==null){
                res=-1;
                answer.add(res);
                continue;
            }
            /* higher not there so we take first from start
               need to check wheter not same as query if same make lower ans
               otherwise need to make higher n+whatever we got and then check */

            else if(higher==null){
                higher= treeSet.first()!=query?treeSet.first():-1;
                if(higher==-1){
                    res=getMin(lower,query,n);
                    answer.add(res);
                    continue;
                }



            }
            /* lower not there so we take first from end
               need to check wheter not same as query if same make lower ans
               otherwise need to make higher n+whatever current is we got and then check */

            else if(lower==null){
                lower= treeSet.last()!=query?treeSet.last():-1;
                if(lower==-1){
                    res=getMin(higher,query,n);
                    answer.add(res);
                    continue;
                }


            }

            res=Math.min(getMin(higher,query,n),getMin(lower,query,n));
            answer.add(res);

        }
        return answer;

    }
    public int getMin(int index,int curr,int n){
        int mini;
        mini= Math.min(curr+n-index,index+n-curr);
        mini=Math.min(mini,Math.abs(curr-index));
        return mini;
    }



    public static void main(String[] args) {
        ClosestEqualElementQueries sol = new ClosestEqualElementQueries();

        int[] nums1 = {6,12,17,9,16,7,6};
        int[] queries1 = {5,6,0,4};
        System.out.println(sol.solveQueries(nums1, queries1));
        // Expected: [2, -1, 3]

        int[] nums2 = {1,2,3,4};
        int[] queries2 = {0,1,2,3};
        System.out.println(sol.solveQueries(nums2, queries2));
        // Expected: [-1, -1, -1, -1]

        int[] nums3 = {5,5,5,5};
        int[] queries3 = {0,1,2,3};
        System.out.println(sol.solveQueries(nums3, queries3));
        // Expected: [1, 1, 1, 1]
    }
}
