import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    List<List<Integer>> permute =new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer>hashSet= new HashSet<>();
        permute(nums, nums.length, new ArrayList<>(),hashSet);

         return permute;
    }

    public void permute(int[] nums,int start,List<Integer>integers,HashSet<Integer> set){

        if(nums.length== integers.size()){
            permute.add(new ArrayList<>(integers));
            return;

        }
        for (int j = 0; j < nums.length; j++) {
            if(set.contains(nums[j]))
                continue;
            set.add(nums[j]);
            integers.add(nums[j] );
            permute(nums, nums.length,integers,set);
            integers.removeLast();
            set.remove(nums[j]);

        }

    }

    public static void main(String[] args) {
        Permutations p= new Permutations();
        System.out.println(p.permute(new int[]{1,2,3}));


    }
}
