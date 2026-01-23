import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestIncreasingSubsequence {



    public int lengthOfLIS(int[] nums) {

        int end=1;

        int[] arr= new int[nums.length];
        arr[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            int l=0;
            int r=end;
            int curr=nums[i];
            while(l<r){
                int mid= (l+r)>>>1;
                if(arr[mid]>=curr){
                    r=mid;
                }
                else{
                    l=mid+1;
                }
            }
            arr[l]=curr;
            if(l==end){
                end++;
            }

        }
        return end;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence= new LongestIncreasingSubsequence();
        System.out.println(
        longestIncreasingSubsequence.lengthOfLIS(new int[]{9,1,4,2,3,3,7}));
    }
}
