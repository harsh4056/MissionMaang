public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int currentMax=nums[0],currentMin=nums[0],prevMax=nums[0],prevMin=nums[0],res=nums[0];
        for(int i=1;i<nums.length;i++){
            currentMax=Math.max(Math.max(prevMax*nums[i],prevMin*nums[i]),nums[i]);
            currentMin=Math.min(Math.min(prevMax*nums[i],prevMin*nums[i]),nums[i]);
            res=Math.max(currentMax,res);
            prevMax=currentMax;
            prevMin=currentMin;
        }
        return res;
    }

    public static void main(String[] args) {
        MaximumProductSubarray soln= new MaximumProductSubarray();
        System.out.println(soln.maxProduct(new int[]{-1,-2,0,-1,-3,-9}));
    }
}
