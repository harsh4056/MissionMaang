import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack= new Stack<>();
        HashMap<Character,Character> map= new HashMap<>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        HashSet<Character> characterHashSet=new HashSet<>(map.values());
        for (Character c : s.toCharArray()) {
            if(characterHashSet.contains(c)){
                stack.push(c);
            }
            if(map.containsKey(c)){
                if(!stack.empty()) {
                    char tempC = stack.peek();
                    if (map.get(c) == tempC) {
                        stack.pop();
                    }
                    else return false;
                }
                else return false;
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidParentheses validParentheses= new ValidParentheses();
        System.out.println(validParentheses.isValid("([)]"));

    }
}
