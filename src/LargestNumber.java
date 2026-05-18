import java.util.Arrays;

public class LargestNumber {

    public String largestNumber(int[] nums) {

        StringBuilder sb= new StringBuilder();
        Integer[] numbers= new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = nums[i];
        }
        Arrays.sort(numbers,(a,b)->{
            String as=a+"";
            String bs=b+"";
            String num1= as+bs;
            String num2= bs+as;

            return num2.compareTo(num1);

        });
        for (int num : numbers) {
            sb.append(num);
        }
        if(sb.charAt(0)==0) return "0";
        return sb.toString();

    }
    public static void main(String[] args) {
        LargestNumber obj = new LargestNumber();

        int[] nums1 = {3432,34323};
        System.out.println(obj.largestNumber(nums1));
        // Expected: 210

        int[] nums2 = {3, 30, 34, 5, 9};
        System.out.println(obj.largestNumber(nums2));
        // Expected: 9534330

        int[] nums3 = {1, 20, 23, 4, 8};
        System.out.println(obj.largestNumber(nums3));
        // Expected: 8423201
    }
}
