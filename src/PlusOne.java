import java.util.Arrays;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry=0;
        for (int i = digits.length-1; i >= 0; i--) {
            if(i==digits.length-1) {
                digits[i] = digits[i] +1;
                carry=digits[i]/10;
                if(carry>0){
                    digits[i]=digits[i]%10;
                }
            }
            else{
                digits[i] = digits[i] +carry;
                carry=digits[i]/10;
                if(carry>0){
                    digits[i]=digits[i]%10;
                }
            }

        }
        if(carry>0){
            int[]arr= Arrays.copyOf(digits,digits.length+1);
            arr[0]=1;
            return arr;
        }
        return digits;

    }

    public static void main(String[] args) {
        PlusOne plusOne= new PlusOne();
        plusOne.plusOne(new int[]{4,3,2,9});
    }
}
