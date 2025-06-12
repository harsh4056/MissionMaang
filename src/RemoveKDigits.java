import java.util.Stack;

public class RemoveKDigits {

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char digit = num.charAt(i);
            while (!stack.isEmpty() && stack.peek() > digit && k > 0) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // Remove from end if k still > 0
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build result efficiently
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            answer.append(stack.pop());
        }
        answer.reverse(); // reverse after popping from stack

        // Remove leading zeros
        while (!answer.isEmpty() && answer.charAt(0) == '0') {
            answer.deleteCharAt(0);
        }

        return answer.isEmpty() ? "0" : answer.toString();
    }



    public static void main(String[] args) {
        RemoveKDigits removeKDigits = new RemoveKDigits();
        System.out.println(removeKDigits.removeKdigits("33526221184202197273", 19));
    }
}


