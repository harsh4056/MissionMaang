import java.util.*;

public class SubsetSumII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> set = new ArrayList<>();
        Arrays.sort(nums);
        findCombinations(nums,set,new ArrayList<>(),0);
        List<List<Integer>> answer= set.stream().toList();
        return answer;
    }

    public void findCombinations(int[] candidates, List<List<Integer>> set,List<Integer> list,int i){
            set.add(new ArrayList<>(list));
        for (int j = i; j < candidates.length; j++) {

            if(j>i && candidates[j]== candidates[j-1])
                continue;

            int candidate = candidates[j];
            list.add(candidate);
            findCombinations(candidates,set,list,j+1);
            list.removeLast();
        }
    }

    public static void main(String[] args) {
        SubsetSumII solution = new SubsetSumII();

        // Test case 1
        int[] nums1 = {1, 2, 2};
        System.out.println(solution.subsetsWithDup(nums1));
        // Expected: [[], [1], [1,2], [1,2,2], [2], [2,2]]

        // Test case 2
        int[] nums2 = {0};
        System.out.println(solution.subsetsWithDup(nums2));
        // Expected: [[], [0]]

        // Test case 3
        int[] nums3 = {4, 4, 4, 1, 4};
        System.out.println(solution.subsetsWithDup(nums3));
        // Expected: [[], [1], [1,4], [1,4,4], [1,4,4,4], [1,4,4,4,4], [4], [4,4], [4,4,4], [4,4,4,4]]
    }

}
