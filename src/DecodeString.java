import java.util.Stack;

public class DecodeString {


    public String decodeString(String s) {
        Stack<Integer> stack= new Stack<>();
        char[] arr= s.toCharArray();
        String num="";
        StringBuilder sb= new StringBuilder();
        int i=0;
        int n=arr.length;
        while(i<n){
            char c= arr[i];
            if(Character.isDigit(c)){
                num=num+c;
                i++;
            }
            else {
                if(!num.equals("")){
                    int val= Integer.parseInt(num);
                    num="";
                    stack.push(val);
                }
                if(c=='['){
                    StringBuilder temp = new StringBuilder();
                    char tc=c;
                    while(tc!=']'){
                        tc= arr[i++];
                        temp.append(tc);
                    }
                    int times=stack.pop();
                    for(int j=0;j<times-1;j++){
                        temp.append(temp);
                    }
                    sb.append(temp);
                }
                else{
                    sb.append(c);
                    i++;
                }


            }
        }
        return sb.toString();


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

        //System.out.println(obj.decodeString("100[leetcode]")); // Expected: "aaabcbc"
        System.out.println(obj.decodeString("3[a2[c]]")); // Expected: "accaccacc"
        System.out.println(obj.decodeString("2[abc]3[cd]ef")); // Expected: "abcabccdcdcdef"
    }

}
