import java.util.*;

public class SpecialXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        int ans=-1;
        Arrays.sort(nums);
        int low=1;
        int high=nums[nums.length-1];
        boolean equal=false;
        while(low<high || equal){

            int medium=low+(high-low)/2;
            int left=0;
            int right=nums.length;
            while(left<right){
                int mid=left+(right-left)/2;
                if(nums[mid]>=medium){
                    right=mid;
                }
                else{
                    left=mid+1;
                }
            }
            int count=nums.length-left;
            if(count==medium){
                return count;
            }
            else if(count>medium){
                low=medium+1;
            }
            else{
                high=medium;
            }
            if(low==high) equal=!equal;
        }
        return ans;
    }

    public static void main(String[] args) {
        SpecialXElementsGreaterThanOrEqualX soln= new SpecialXElementsGreaterThanOrEqualX();
        System.out.println(soln.specialArray(new int[]{3,6,7,7,0}));
        System.out.println(soln.specialArray(new int[]{7,7,7,7,7,7,7}));
    }
}
