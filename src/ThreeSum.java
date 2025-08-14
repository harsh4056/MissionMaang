import javax.lang.model.util.Elements;
import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-2;i++) {
            if (i>0&&nums[i] == nums[i - 1])
                continue;
            int target=-nums[i];
            int left=i+1;
            int right=n-1;
            while(left< right){
                if(nums[left]+nums[right]<target){
                    left++;
                }
                else if(nums[left]+nums[right]>target){
                    right--;
                }
                else{
                    List<Integer> temp= new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    result.add(temp);

                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    left++;
                    right--;

                }
            }

        }

        return result;
    }


    // Pair class to store index pairs



    public static void main(String[] args) {
        ThreeSum sum= new ThreeSum();
        System.out.println(
        sum.threeSum(new int[]{-1,0,1,2,-1,-4}));
    }





}
