public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int fast=nums[nums[0]];
        int slow=nums[0];

        while(fast!=slow){
            slow=nums[slow];
            fast=nums[nums[fast]];
        }
        return slow;
    }

    public static void main(String[] args) {
      FindTheDuplicateNumber duplicateNumber= new FindTheDuplicateNumber();
        System.out.println(duplicateNumber.findDuplicate(new int[]{3,1,3,4,2}));
    }
}
