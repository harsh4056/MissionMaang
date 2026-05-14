public class SlidingWindow {


    public static void main(String[] args) {
        int[]nums= new int[]{1,2,3,1,4,1};
        int target=5;
        int val= subArrayEqualsTarget(nums,target);
        System.out.println(val);
    }

    public static int subArrayEqualsTarget(int []nums,int target){

        int l=0;
        int rSum=0;
        int count=0;
        for(int r=0;r<nums.length;r++){
            rSum=rSum+nums[r];

            while(rSum>=target){
                if(rSum==target)
                 count++;
                rSum=rSum-nums[l];
                l++;
            }

        }
        return count;
    }
}
