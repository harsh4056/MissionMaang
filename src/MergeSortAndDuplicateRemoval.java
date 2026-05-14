import java.util.ArrayList;
import java.util.List;

public class MergeSortAndDuplicateRemoval {
    public static int[] sortAndRemoveDuplicates (int[]nums){

        nums= sort(nums,0,nums.length-1);

        List<Integer> list= new ArrayList<>();
        Integer prev=null;
        for(int num:nums){
            if(prev==null){
                list.add(num);
            }

            else if(prev!=num){
                list.add(num);

            }
            prev=num;
        }

        int[]ans= new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;



    }

    public static int[] merge(int[]nums1,int []nums2){

        int[] merged= new int[nums1.length+nums2.length];

        int i=0;int j=0;
        int k=0;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]>nums2[j]) {
                merged[k] = nums2[j];
                j++;

            }
            else{
                merged[k]=nums1[i];
                i++;
            }
            k++;
        }

        while(i<nums1.length){
            merged[k]=nums1[i];
            i++;
            k++;
        }
        while(j<nums2.length){
            merged[k]=nums1[j];
            j++;
            k++;
        }
        return merged;


    }

    public static int[] sort(int[] nums, int start, int end){

        int l=start;
        int r=end;
        if(l==r)
            return nums;

        int mid=(l+r)>>>1;
        int [] nums1= sort(nums,l,mid);
        int [] nums2= sort(nums,mid+1,r);

        int[]merged=merge(nums1,nums2);
        return merged;



    }


}
