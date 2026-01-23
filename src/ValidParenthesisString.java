import java.util.*;

public class ValidParenthesisString {

    public boolean checkValidString(String s) {
        char []cs= s.toCharArray();
        Stack<Character> stack= new Stack<>();
        int a=0;
        for(char c:cs){
            if(c=='('){

                while (!stack.isEmpty() && a>0){
                    stack.pop();
                    a--;
                }

                if(stack.isEmpty()){
                    a=0;
                }
                stack.push(c);

            }
            else if(c==')'){
                if(stack.isEmpty() && a>0){
                    a--;
                }
                else if(!stack.isEmpty()){
                    stack.pop();
                }
                else{
                    return false;
                }

            }
            else{
                a++;
            }

        }
        return stack.isEmpty();


    }

    public static void main(String[] args) {
        ValidParenthesisString soln = new ValidParenthesisString();
        System.out.println(soln.checkValidString("((**()))()"));
    }
}
