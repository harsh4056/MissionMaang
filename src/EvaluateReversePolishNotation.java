import java.util.Objects;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String curr : tokens) {
            if (Objects.equals(curr, "+")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = b + a;
                stack.push(c + "");
            } else if (Objects.equals(curr, "/")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = b / a;
                stack.push(c + "");
            } else if (Objects.equals(curr, "-")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = b - a;
                stack.push(c + "");
            } else if (Objects.equals(curr, "*")) {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                int c = b * a;
                stack.push(c + "");
            } else {
                stack.push(curr);
            }

        }
        int ans = Integer.parseInt(stack.pop());
        return ans;
    }


    public static void main(String[] args) {
        EvaluateReversePolishNotation notation= new EvaluateReversePolishNotation();;
        //System.out.println(notation.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(notation.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
