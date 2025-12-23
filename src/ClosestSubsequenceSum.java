import java.util.TreeSet;

public class ClosestSubsequenceSum {
    public int minAbsDifference(int[] nums, int goal) {

        int n=nums.length;
        TreeSet<Integer> first= new TreeSet<>();
        TreeSet<Integer> second= new TreeSet<>();

        solve(nums,0,0,(n/2),first);
        solve(nums,0,(n/2),n,second);
        int mini=Integer.MAX_VALUE;

        //x+y=sum & (x+y)-goal =>
        for (Integer x : first) {
            int val=goal-x;
            Integer y1= second.floor((val));
            Integer y2= second.ceiling((val));
            if(y1!=null){
                int abs=Math.abs(x+y1-goal);
                mini=Math.min(mini,abs);
            }
            if(y2!=null){
                int abs=Math.abs(x+y2-goal);
                mini=Math.min(mini,abs);
            }
        }

        return mini;
    }

    public void solve(int []nums,int sum, int index, int limit, TreeSet<Integer> treeSet){

        if(index==limit){
            treeSet.add(sum);
            return;
        }

        //take
        solve(nums,sum+nums[index],index+1,limit,treeSet);
        //skip
        solve(nums,sum,index+1,limit,treeSet);

    }

    public static void main(String[] args) {
        ClosestSubsequenceSum obj = new ClosestSubsequenceSum();

        // Test case 1
        int[] nums1 = {5, -7, 3, 5};
        int goal1 = 6;
        System.out.println(obj.minAbsDifference(nums1, goal1));
        // Expected output: 0

        // Test case 2
        int[] nums2 = {7, -9, 15, -2};
        int goal2 = -5;
        System.out.println(obj.minAbsDifference(nums2, goal2));
        // Expected output: 1

        // Test case 3
        int[] nums3 = {1, 2, 3};
        int goal3 = -7;
        System.out.println(obj.minAbsDifference(nums3, goal3));
        // Expected output: 7
    }

}
