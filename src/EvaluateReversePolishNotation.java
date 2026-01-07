import java.util.Objects;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {
        Stack<String> stack= new Stack<>();
        for(String t:tokens){
            switch (t) {
                case "+" -> {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push((a + b) + "");
                }
                case "-" -> {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push((a - b) + "");
                }
                case "*" -> {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push((a * b) + "");
                }
                case "/" -> {
                    int b = Integer.parseInt(stack.pop());
                    int a = Integer.parseInt(stack.pop());
                    stack.push((a / b) + "");
                }
                case null, default -> stack.push(t);
            }
        }
        return Integer.parseInt(stack.pop());
    }


    public static void main(String[] args) {
        EvaluateReversePolishNotation notation= new EvaluateReversePolishNotation();;
        System.out.println(notation.evalRPN(new String[]{"2","1","+","3","*"}));
        System.out.println(notation.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
