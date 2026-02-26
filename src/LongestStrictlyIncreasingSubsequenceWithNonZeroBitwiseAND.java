import java.util.ArrayList;
import java.util.List;

public class LongestStrictlyIncreasingSubsequenceWithNonZeroBitwiseAND {
    public int longestSubsequence(int[] nums) {
        int ans=1;
        for (int i = 0; i < 31; i++) {
            List<Integer> list= new ArrayList<>();
            int curr=1<<i;
            for (int num : nums) {
                if((num&curr)>0){
                   list.add(num);
                }
            }
            if(!list.isEmpty()){
                int lis=lengthOfLIS(list);
                ans=Math.max(lis,ans);
            }
        }
        return ans;

    }

    public int lengthOfLIS(List<Integer> list) {

        int end=1;

        int[] arr= new int[list.size()];
        arr[0]=list.getFirst();
        for(int i=1;i<list.size();i++){
            int l=0;
            int r=end;
            int curr=list.get(i);
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

}
