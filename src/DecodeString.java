import java.util.Stack;

public class DecodeString {


    public String decodeString(String s) {
        CharStack stack = new CharStack(s.length()*1000);

        char[]arr= s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=']'){
                stack.push(arr[i]);
            }
            if(arr[i]==']'){

                StringBuilder temp= new StringBuilder();
                while (!stack.isEmpty() && stack.peek()>='a' && stack.peek()<='z'){
                    temp.append(stack.pop());
                }
                stack.pop();

                int count = 0;
                int multiplier = 1;
                while (!stack.isEmpty() && stack.peek() >= '0' && stack.peek() <= '9') {
                    count += (stack.pop() - '0') * multiplier;
                    multiplier *= 10;
                }
                for (int j = 0; j < count; j++) {
                    for (int k = temp.length()-1; k >=0 ; k--) {
                        stack.push(temp.charAt(k));
                    }

                }

            }
        }
        String ss= String.valueOf(stack.data,0, stack.size());
        return ss;


    }

    class CharStack {
        private final char[] data;
        private int top = -1;
        public CharStack(int capacity) { data = new char[capacity]; }
        public void push(char c) { data[++top] = c; }
        public char pop()    { return data[top--]; }
        public char peek()    { return data[top]; }
        public boolean isEmpty() { return top == -1; }
        public int size() {return top + 1; }
    }

    public static void main(String[] args) {
        DecodeString obj = new DecodeString();

        System.out.println(obj.decodeString("100[leetcode]")); // Expected: "aaabcbc"
        System.out.println(obj.decodeString("3[a2[c]]")); // Expected: "accaccacc"
        System.out.println(obj.decodeString("2[abc]3[cd]ef")); // Expected: "abcabccdcdcdef"
    }

}
