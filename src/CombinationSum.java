import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class CombinationSum {



    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists= new ArrayList<>();
        HashSet<List<Integer>> hashSet= new HashSet<>();
        permute(candidates,target,0,0,new ArrayList<>(),lists);
        return lists;
    }

    public void permute(int[] candidates, int target,int sum,int index,List<Integer> integers,List<List<Integer>> lists){
        System.out.println(integers);
        if(sum>target){
            return;
        }

        if(sum==target){
            List<Integer> temp= new ArrayList<>(integers);
            lists.add(temp);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            sum +=candidates[i];
            integers.add(candidates[i]);
            permute(candidates,target,sum,i,integers,lists);
            sum-=integers.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum= new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[]{2,3,6,7},7));
    }
}
