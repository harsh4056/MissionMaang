import java.util.*;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(candidates);
        findCombinations(candidates,target,set,new ArrayList<>(),0);
        List<List<Integer>> answer= set.stream().toList();
        return answer;
    }

    public void findCombinations(int[] candidates, int target, Set<List<Integer>> set,List<Integer> list,int i){

        if(i>=candidates.length || target<0){
            return;
        }if(target==0){
            set.add(new ArrayList<>(list));
        }

        for (int j = i; j < candidates.length; j++) {

            if(j>i && candidates[j]== candidates[j-1])
                continue;

            int candidate = candidates[j];
            list.add(candidate);
            findCombinations(candidates,target-candidate,set,list,j+1);
            list.removeLast();

        }

    }

    public static void main(String[] args) {
        CombinationSumII solution = new CombinationSumII();

        // Test case 1
        int[] candidates1 = {10,1,2,7,6,1,5};
        int target1 = 8;
        System.out.println(solution.combinationSum2(candidates1, target1));
        // Expected: [[1,1,6], [1,2,5], [1,7], [2,6]]

        // Test case 2
        int[] candidates2 = {2,5,2,1,2};
        int target2 = 5;
        System.out.println(solution.combinationSum2(candidates2, target2));
        // Expected: [[1,2,2], [5]]

        // Test case 3
        int[] candidates3 = {3,1,3,5,1,1};
        int target3 = 8;
        System.out.println(solution.combinationSum2(candidates3, target3));
        // Expected: [[1,1,1,5], [1,1,3,3], [3,5]]
    }


}
