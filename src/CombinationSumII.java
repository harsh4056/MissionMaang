import java.util.*;

public class CombinationSumII {

    List<List<Integer>> answer;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        int n=candidates.length;
        int[]nextIndex= new int[n];
        for(int i=0;i<n;i++){
            int l=i+1;
            int r=n;
            int curr=candidates[i];
            while(l<r){
                int mid=(l+r)>>>1;
                if(candidates[mid]>curr){
                    r=mid;
                }
                else{
                    l=mid+1;
                }
            }
            nextIndex[i]=l;
        }
        answer= new ArrayList<>();
        solve(candidates,nextIndex,0,target,new ArrayList<>());
        return answer;
    }


    public void solve(int[]nums,int[]next,int index,int target,List<Integer> list){
        if(target==0){
            answer.add(new ArrayList<>(list));
            return;
        }
        if(index==nums.length|| target<0){
            return;
        }


        list.add(nums[index]);
        solve(nums,next,index+1,target-nums[index],list);
        list.removeLast();
        solve(nums,next,next[index],target,list);

    }
    public static void main(String[] args) {
        CombinationSumII solution = new CombinationSumII();
        StringBuilder sb= new StringBuilder();
        
        // Test case 1
        int[] candidates1 = {10,1,2,7,6,1,5};
        int target1 = 8;
        System.out.println(solution.combinationSum2(candidates1, target1));
        // Expected: [[1,1,6], [1,2,5], [1,7], [2,6]]

        // Test case 2
        int[] candidates2 = {2,5,2,1,2};
        int target2 = 5;
        System.out.println(solution.combinationSum2(candidates2, target2));
        // Expected: [[1,2,2], [5]]

        // Test case 3
        int[] candidates3 = {3,1,3,5,1,1};
        int target3 = 8;
        System.out.println(solution.combinationSum2(candidates3, target3));
        // Expected: [[1,1,1,5], [1,1,3,3], [3,5]]
    }


}
