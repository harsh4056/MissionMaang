import java.util.Arrays;

public class TwoSum2InputArrayIsSorted {


    public int[] twoSum(int[] numbers, int target) {

        int n=numbers.length;
        for(int i=0;i<n;i++){
            int find=target-numbers[i];
            int left=i+1;
            int right=n-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(numbers[mid]==find){
                    return new int[]{i+1,mid+1};
                }
                else if(numbers[mid]>find){
                    right=mid-1;
                }
                else{
                    left=mid+1;
                }
            }

        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum2InputArrayIsSorted sorted= new TwoSum2InputArrayIsSorted();
        System.out.println(Arrays.toString(sorted.twoSum(new int[]{-1, 0}, -1)));
    }


}
