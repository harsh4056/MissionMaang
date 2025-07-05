import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {

      char[] digits=num.toCharArray();
      List<String> list = new ArrayList<>();
      findExpressions(new StringBuilder(),list,digits,0,target);
        return list;
    }
    public void findExpressions(StringBuilder builder, List<String> list, char[] digits, int digitIndex, int target){

        if(digitIndex==digits.length-1){
            builder.append(digits[digitIndex]);
            for(int i=0;i<builder.length();i++){
                char c=builder.charAt(i);

                if(Character.isDigit(c)){
                    if (c == '0' && (i + 1 < builder.length() && Character.isDigit(builder.charAt(i + 1)))) {
                        builder.deleteCharAt(builder.length()-1);
                        return;
                    }

                    for (;Character.isDigit(c)&&i<builder.length() ; i++) {
                        c=builder.charAt(i);
                    }
                    i--;
                }
            }


            String expression =builder.toString();
            long ans= evaluate(expression);
            if(ans==target)
                list.add(builder.toString());
            builder.deleteCharAt(builder.length()-1);
            return;
        }


        builder.append(digits[digitIndex]);
        builder.append("-");
        findExpressions(builder,list,digits,digitIndex+1,target);
        builder.deleteCharAt(builder.length()-1);
        builder.append("+");
        findExpressions(builder,list,digits,digitIndex+1,target);
        builder.deleteCharAt(builder.length()-1);
        builder.append("*");
        findExpressions(builder,list,digits,digitIndex+1,target);
        builder.deleteCharAt(builder.length()-1);


        findExpressions(builder, list, digits, digitIndex + 1, target);
        builder.deleteCharAt(builder.length() - 1);


    }


    public long evaluate(String s) {
        Stack<Long> stack = new Stack<>();
        long num = 0;
        char sign = '+';
        s = s.replaceAll(" ", "") + "+"; // remove spaces & add sentinel operator

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (!Character.isDigit(c)) {
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                sign = c;
                num = 0;
            }
        }

        long result = 0;
        for (long val : stack) result += val;
        return result;
    }


    public static void main(String[] args) {
        ExpressionAddOperators solution = new ExpressionAddOperators();

       /* System.out.println(solution.addOperators("123", 6));
        // Expected: ["1+2+3", "1*2*3"]

        System.out.println(solution.addOperators("232", 8));
        // Expected: ["2*3+2", "2+3*2"]*/

        System.out.println(solution.addOperators("100000009", 9));
        // Expected: ["1*0+5", "10-5"]
    }


}
