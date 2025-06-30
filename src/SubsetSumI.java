import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetSumI {


    public List<Integer> subsetSums(int[] nums) {
        List<Integer> subsets = new ArrayList<>();
        findSubsetSum(nums, 0, 0, subsets);
        return subsets;
    }

    public void findSubsetSum(int[] nums, int index, int sum, List<Integer> subsets) {


        if (index >= nums.length) {
            subsets.add(sum);
            return;
        }


        findSubsetSum(nums, index + 1, sum + nums[index], subsets);
        findSubsetSum(nums, index + 1, sum, subsets);


    }

    public static void main(String[] args) {
        SubsetSumI solution = new SubsetSumI();

        // Test case 1
        int[] nums1 = {1, 2};
        System.out.println(solution.subsetSums(nums1));
        // Expected: [3, 2, 3, 2, 1, 3, 1, 2] (may include duplicates due to incorrect loop)

        // Test case 2
        int[] nums2 = {1, 2, 3};
        System.out.println(solution.subsetSums(nums2));
        // Expected: [6, 5, 4, 5, 4, 3, 3, 2] (may include duplicates due to incorrect loop)

        // Test case 3
        int[] nums3 = {0};
        System.out.println(solution.subsetSums(nums3));
        // Expected: [0, 0] (due to multiple entries with same index logic)
    }

}
