public class TwoSum2InputArrayIsSorted {


    public int[] twoSum(int[] numbers, int target) {

        int left=0;
        int right=numbers.length-1;
        while (left<right){
            if(numbers[left]+numbers[right]>target){
                right--;
            } else if (numbers[left]+numbers[right]<target) {
                left++;
            }
            else{
                break;
            }
        }
        int []arr=new int[]{left+1,right+1};
        return arr;
    }

    public static void main(String[] args) {
        TwoSum2InputArrayIsSorted sorted= new TwoSum2InputArrayIsSorted();
        sorted.twoSum(new int[]{-1,0},-1);
    }


}
