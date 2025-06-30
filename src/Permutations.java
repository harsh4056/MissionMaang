import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permute =new ArrayList<>();
        backtrack(nums, 0, permute);

         return permute;
    }



    public void backtrack (int[] nums,int start,List<List<Integer>> permute){

        if(start>= nums.length){
            List<Integer> ds = new ArrayList<>();
            for (int num : nums) {
                ds.add(num);
            }
            permute.add(ds);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums,start,i);
            backtrack(nums,start+1,permute);
            swap(nums,start,i);
        }
    }

    public void swap (int[]nums,int i,int j){
        int temp =nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args) {
        Permutations p= new Permutations();
        System.out.println(p.permute(new int[]{1,2,3}));


    }
}
