import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidParentheses {

    static class CharStack {
        private final char[] data;
        private int top = -1;
        public CharStack(int capacity) { data = new char[capacity]; }
        public void push(char c) { data[++top] = c; }
        public char pop()    { return data[top--]; }
        public boolean isEmpty() { return top == -1; }
    }

    public boolean isValid(String s) {
        CharStack stack = new CharStack(s.length());
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': stack.push(')'); break;
                case '{': stack.push('}'); break;
                case '[': stack.push(']'); break;
                default:
                    if (stack.isEmpty() || stack.pop() != c)
                        return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses= new ValidParentheses();
        System.out.println(validParentheses.isValid("({})])"));

    }
}
