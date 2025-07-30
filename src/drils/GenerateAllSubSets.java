package drils;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllSubSets {

    public List<List<Integer>> generateAllSubsets(int[]nums){
        List<List<Integer>> lists= new ArrayList<>();
        generate(nums,0,lists,new ArrayList<>());
        return lists;
    }

    public void generate(int[]nums,int index,List<List<Integer>> lists,List<Integer> list){
        if(index==nums.length){
            lists.add(new ArrayList<>(list));
            return;
        }
        for(int i=index;i<nums.length;i++){

           list.add(nums[i]);
           generate(nums,i+1,lists,list);
           list.removeLast();

        }
    }

    public static void main(String[] args) {
        GenerateAllSubSets generateAllSubSets= new GenerateAllSubSets();

        int []nums= new int[]{1,2,3};
        System.out.println(generateAllSubSets.generateAllSubsets(nums));
    }
}
