import javax.lang.model.util.Elements;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        List<List<Integer>> listList= new ArrayList<>();
        for(int i=0;i<n;i++){
        int target=-nums[i];
        int left=i+1;
        int right= nums.length-1;

        while(left<right){

            if(target==nums[left]+nums[right]){
                List<Integer> list= new ArrayList<>();
                list.add(-target);
                list.add(nums[left]);
                list.add(nums[right]);
                listList.add(list);
                while (left<n-1 && nums[left]==nums[left+1]){
                    left++;
                }
                left++;

                continue;

            }
            if(target<nums[left]+nums[right]){
                right--;
            }
            else {
                left++;
            }
        }
        while (i<n-1 && nums[i]==nums[i+1]){
            i++;
        }

        }

        return listList;
    }


    // Pair class to store index pairs



    public static void main(String[] args) {
        ThreeSum sum= new ThreeSum();
        System.out.println(sum.threeSum(new int[]{0,0,0,0}));
        System.out.println(sum.threeSum(new int[]{-1,0,1,2,-1}));
    }





}
