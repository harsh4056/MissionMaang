public class MissingNumber {
    public int missingNumber(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i]<nums.length && nums[i]!=i){
                int temp=nums[nums[i]];
                nums[nums[i]]=nums[i];
                nums[i]=temp;
            }

        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i) return i;
        }
        return nums.length;

    }

    public static void main(String[] args) {
        MissingNumber soln= new MissingNumber();
        System.out.println(soln.missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(soln.missingNumber(new int[]{3,2,1}));
        System.out.println(soln.missingNumber(new int[]{0,2}));

    }
}
