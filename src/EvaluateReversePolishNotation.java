import java.util.Objects;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<String> stack= new Stack<>();
        int index=tokens.length-1;
        if(index==0){
          return   Integer.parseInt(tokens[0]);
        }

        stack.push(tokens[index--]);
        while(!stack.isEmpty()){
            if( isNumber(tokens[index])){
                String number1=tokens[index];
                String s=stack.peek();
                if(isNumber(s)){
                    String number2=stack.pop();
                    String operation=stack.pop();
                    int res=evaluate(number1,number2,operation);
                    tokens[index]=res+"";
                }
                else {
                    stack.push(tokens[index--]);
                }
            }
            else{
                stack.push(tokens[index--]);
            }
        }
        return Integer.parseInt(tokens[0]);
    }

    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }


    public int evaluate(String number1 ,String number2,String operation){
        int n1=Integer.parseInt(number1);
        int n2=Integer.parseInt(number2);
        return switch (operation) {
            case "-" -> (n1 - n2);
            case "+" -> (n1 + n2);
            case "/" -> (n1 / n2);
            case "*" -> (n1 * n2);
            default -> 0;
        };
    }
    public boolean isNumber(String s){
       return !(s.equals( "-") || s.equals( "+")||s.equals( "/") || s.equals("*"));
    }

    public static void main(String[] args) {
        EvaluateReversePolishNotation notation= new EvaluateReversePolishNotation();;
        System.out.println(notation.evalRPN(new String[]{"10","6","9","3","+","-11","*","/","*","17","+","5","+"}));
    }
}
