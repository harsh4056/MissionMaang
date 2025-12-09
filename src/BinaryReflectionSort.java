import java.util.Arrays;

public class BinaryReflectionSort {
    public int[] sortByReflection(int[] nums) {
        Integer[] arr = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = nums[i];

        Arrays.sort(arr, (a, b) ->{
           int ar= reverseBinary(a);
           int br=reverseBinary(b);
           if(ar==br){
               return a-b;
           }
           return ar-br;

        });

        for (int i = 0; i < nums.length; i++) nums[i] = arr[i];
        return nums;
    }
    public int reverseBinary(int num) {
        int ans = 0;
        while (num > 0) {
            ans = (ans << 1) | (num & 1);
            num >>= 1;
        }
        return ans;
    }


    public static void main(String[] args) {
        BinaryReflectionSort soln= new BinaryReflectionSort();

        System.out.println(Arrays.toString(soln.sortByReflection(new int[]{8, 2})));
    }
}
