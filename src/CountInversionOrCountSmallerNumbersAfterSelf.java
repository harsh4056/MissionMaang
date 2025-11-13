import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountInversionOrCountSmallerNumbersAfterSelf {

    HashMap<Integer,Integer> map;

    public List<Integer> countSmaller(int[] nums) {
        int[] arr= new int[nums.length];
        map= new HashMap<>();
        List<Integer> answer= new ArrayList<>();
        for (int i = 0, numsLength = nums.length; i < numsLength; i++) {
            int num = nums[i];
            arr[i]=num;
            map.put(num, 0);
        }
        mergeSort(nums);
        for (int i1 : arr) {
            answer.add(map.get(i1));
        }



        return answer;



    }

    public void countInversion(int[]nums1,int[]nums2){

        int p1=0;
        int p2=0;

        while (p1<nums1.length && p2<nums2.length){
            if(nums1[p1]>nums2[p2]){
                for(int i=p1;i<nums1.length;i++){
                    map.put(nums1[i],map.get(nums1[i])+1);
                }

                
                p2++;
            }
            else{
                p1++;
            }
        }
    }


        public void mergeSort(int[]nums){
            merge(nums,0,nums.length-1);

        }

        public void merge(int[]nums, int start,int end){
            if(start==end) return;
            int mid=(start+end)/2;


            int []left=new int[mid-start+1];
            int[]right=new int[end-mid];

            // Copy Loops (Not counted, as they are part of the flawed O(N) setup)
            for (int i=0;i<=mid;i++){
                left[i]=nums[i];
            }

            int j=0;
            for (int i=mid+1;i<=end;i++){
                right[j]=nums[i];
                j++;
            }
            mergeSort(left);
            mergeSort(right);

            countInversion(left,right);
            int p1=0,p2=0;
            int i=start;

            // 2. Count increments inside the merging loops (O(N) work)
            while(p1<left.length && p2<right.length){
                if(left[p1]<right[p2]){
                    nums[i]=left[p1];
                    i++;
                    p1++;
                }
                else{
                    nums[i]=right[p2];
                    i++;
                    p2++;
                }

            }

            while (p1<left.length){
                nums[i]=left[p1];
                i++;
                p1++;

            }
            while (p2<right.length){
                nums[i]=right[p2];
                i++;
                p2++;

            }
        }

    public static void main(String[] args) {
        CountInversionOrCountSmallerNumbersAfterSelf soln= new CountInversionOrCountSmallerNumbersAfterSelf();
        System.out.println(soln.countSmaller(new int[]{0,2,1}));
    }



}
