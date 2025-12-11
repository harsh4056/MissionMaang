package drils;

public class Testing {

    public static void main(String[] args) {
        int [] nums= new int[]{3,1,5,3,2,-1,6,4};
        int n=nums.length;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]<=0) continue;
            dfs(nums,nums[i]);
        }

        return;
    }

    public static  void dfs(int[]nums,int element){
        if(element==-1 ||nums[element - 1] == element) return;
        int temp=nums[element-1];
        nums[element-1]=element;
        dfs(nums,temp);
    }
}
