import java.util.*;

public class SortAndRemoveDuplicates {


    public static int[] sortAndRemoveDuplicates (int[]nums){

        nums= sort(nums,0,nums.length-1);

        List<Integer> list= new ArrayList<>();
        Integer prev=null;
        for(int num:nums){
            if(prev==null){
                list.add(num);
                prev=num;
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

    public static int[] merge(int[] nums1, int n1, int[] nums2, int n2) {

        int[] merged = new int[n1 + n2];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n1 && j < n2) {

            if (nums1[i] > nums2[j]) {
                merged[k] = nums2[j];
                j++;
            } else {
                merged[k] = nums1[i];
                i++;
            }

            k++;
        }

        while (i < n1) {
            merged[k] = nums1[i];
            i++;
            k++;
        }

        while (j < n2) {
            merged[k] = nums2[j];
            j++;
            k++;
        }

        return merged;
    }

    public static int[] sort(int[] nums, int start, int end){

        int l=start;
        int r=end;
        if(l==r)
            return new int[]{nums[l]};

        int mid=(l+r)>>>1;
        int[]nums1= sort(nums,l,mid);
        int[]nums2=sort(nums,mid+1,r);



        int[]merged=merge(nums1,nums1.length,nums2,nums2.length);
        return merged;



    }

    public static void main(String[] args) {
        sortAndRemoveDuplicates(new int[]{2,3,4,2,4,5,6,7,8,9,6,3,4,5,7,5,3,54,5,6,3,5});
    }

}
