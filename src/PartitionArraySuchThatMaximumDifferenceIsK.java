import java.util.*;

public class PartitionArraySuchThatMaximumDifferenceIsK {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int total=1;
        int n=nums.length;
        int min=0;
        int max=0;
        for(int i=0;i<n;i++){

            if(nums[min]>nums[i]){
                min=i;
            }
            if(nums[max]<nums[i]){
                max=i;
            }
            if(nums[max]-nums[min]>k){
                total++;
                min=i;
                max=i;
            }

        }
        return total;
    }

    public static void main(String[] args) {
        PartitionArraySuchThatMaximumDifferenceIsK soln= new PartitionArraySuchThatMaximumDifferenceIsK();
        System.out.println(soln.partitionArray(new int[]{1,2,3},1));
        System.out.println(soln.partitionArray(new int[]{3,6,1,2,5},2));

    }
}
