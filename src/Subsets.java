import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        int pos= (int) Math.pow(2,n);
        List<List<Integer>> lists= new ArrayList<>();
        for (int i = 0; i < pos; i++) {
            int k=0;
            List<Integer> list= new ArrayList<>();
            while (k<n){
                int include=(i >>k)& 1;
                if(include!=0){
                    list.add(nums[k]);
                }
                k++;
            }
            lists.add(list);
        }
        return lists;
    }

    List<List<Integer>> answer;
    public List<List<Integer>> subsets2(int[] nums) {
        answer = new ArrayList<>();
        recurseSubset(0,new ArrayList<>(),nums);

        return answer;
    }

    public void recurseSubset(int k,List<Integer> combination,int nums[]){
        answer.add(new ArrayList<>(combination));
        for(int i=k;i<nums.length;i++){//
            combination.add(nums[i]);
            recurseSubset(i+1,combination,nums);
            combination.removeLast();
        }

    }

    public static void main(String[] args) {
        Subsets solution = new Subsets();
        int[] nums1 = {1, 2, 3};
        List<List<Integer>> result1 = solution.subsets2(nums1);
        System.out.println(result1); // Expected: [[], [1], [2], [3], [1,2], [1,3], [2,3], [1,2,3]]

        int[] nums2 = {};
        List<List<Integer>> result2 = solution.subsets(nums2);
        System.out.println(result2); // Expected: [[], [0]]

        int[] nums3 = {1, 2};
        List<List<Integer>> result3 = solution.subsets(nums3);
        System.out.println(result3); // Expected: [[], [1], [2], [1,2]]
    }

}
