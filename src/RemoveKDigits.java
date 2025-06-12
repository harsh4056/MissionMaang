import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        int top=-1;
      char []nums= num.toCharArray();
        for (int i = 0; i < nums.length; i++) {
            while(top>=0 && nums[top]>nums[i] && k>0){
                top--;
                k--;
            }

            nums[++top]=nums[i];
        }
        while (k > 0) {
            top--;
            k--;
        }
        int i = 0;
        while (i <=top && nums[i] == '0') i++;
        if (i > top) return "0";
        return String.valueOf(nums, i, top - i + 1);

    }
    public String removeKdigits2(String num, int k) {
        StringBuilder stack = new StringBuilder();

        for (char digit : num.toCharArray()) {
            while (!stack.isEmpty() && stack.charAt(stack.length() - 1) > digit && k > 0) {
                stack.deleteCharAt(stack.length() - 1);  // pop
                k--;
            }
            stack.append(digit);  // push
        }

        // Remove remaining from end
        while (k > 0) {
            stack.deleteCharAt(stack.length() - 1);
            k--;
        }

        // Remove leading zeros
        int i = 0;
        while (i < stack.length() && stack.charAt(i) == '0') i++;

        String result = stack.substring(i);
        return result.isEmpty() ? "0" : result;
    }


    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKdigits("33526221184202197273", 19));
    }
}


