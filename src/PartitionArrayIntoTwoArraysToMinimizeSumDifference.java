import java.util.HashSet;
import java.util.TreeSet;

public class PartitionArrayIntoTwoArraysToMinimizeSumDifference {
    public int minimumDifference(int[] nums) {
        int n=nums.length;
        TreeSet<Integer> first= new TreeSet<>();
        TreeSet<Integer> second= new TreeSet<>();

        solve(nums,0,0,n,0,first);
        //solve(nums,0,(n/2),n,second);

        int mini=Integer.MAX_VALUE;
        int goal=0;
        //x-y=min
        for (Integer x : first) {
            int val=x;
            Integer y1= second.floor((val));
            Integer y2= second.ceiling((val));
            if(y1!=null){
                int abs=Math.abs(x-y1);
                mini=Math.min(mini,abs);
            }
            if(y2!=null){
                int abs=Math.abs(x-y2);
                mini=Math.min(mini,abs);
            }
        }

        return mini;
    }

    public void solve(int []nums,int sum, int index, int limit,int count, TreeSet<Integer> treeSet){
        if(count==limit/2) {
            treeSet.add(sum);
            return;
        }
        if(index==limit){

            return;
        }

        //take
        solve(nums,sum+nums[index],index+1,limit,count+1,treeSet);
        //skip
        solve(nums,sum,index+1,limit,count,treeSet);

    }

    public static void main(String[] args) {
        PartitionArrayIntoTwoArraysToMinimizeSumDifference soln= new PartitionArrayIntoTwoArraysToMinimizeSumDifference();
        //System.out.println(soln.minimumDifference(new int[]{7772197,4460211,-7641449,-8856364,546755,-3673029,527497,-9392076,3130315,-5309187,-4781283,5919119,3093450,1132720,6380128,-3954678,-1651499,-7944388,-3056827,1610628,7711173,6595873,302974,7656726,-2572679,0,2121026,-5743797,-8897395,-9699694}));
        System.out.println(soln.minimumDifference(new int[]{1,2,3,4,5,6}));
        System.out.println(soln.minimumDifference(new int[]{3,9,7,3}));
        System.out.println(soln.minimumDifference(new int[]{-36,36}));
    }
}
