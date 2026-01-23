import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Subsets {

    List<List<Integer>> answer;
    public List<List<Integer>> subsets(int[] nums) {
        answer= new ArrayList<>();
        solve(nums,0,new HashSet<>());
        return answer;
    }
    public void solve(int[]nums, int index, HashSet<Integer> set){
        if(index==nums.length) {
            answer.add(new ArrayList<>(set));
            return;
        }
        set.add(nums[index]);
        solve(nums,index+1,set);
        set.remove(nums[index]);
        solve(nums,index+1,set);
    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.subsets(nums1);
        System.out.println(result1); // Expected: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]

        int[] nums2 = {};
        List<List<Integer>> result2 = solution.subsets(nums2);
        System.out.println(result2); // Expected: [[], [0]]

        int[] nums3 = {1, 2};
        List<List<Integer>> result3 = solution.subsets(nums3);
        System.out.println(result3); // Expected: [[], [1], [2], [1,2]]
    }

}
