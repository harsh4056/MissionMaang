import java.util.*;

public class CountCollisionsOnARoad {
    public int countCollisions(String directions) {
        CharStack stack= new CharStack(100000);
        char[]cs=directions.toCharArray();
        int collison=0;
        char last='0';
        for(char c:cs){
            switch (c){
                case 'L':
                    if(stack.isEmpty()){
                        continue;
                    }
                    else if(stack.peek()=='S'){
                        collison++;
                    }
                    else if(stack.peek()=='R'){
                        collison+=2;
                        stack.pop();
                        while (!stack.isEmpty()){
                            if(stack.peek()=='R'){
                                collison++;
                            }
                            stack.pop();
                        }
                        stack.push('S');
                    }
                    break;


                case 'R':
                    stack.push('R');
                    break;
                case 'S':
                    if(!stack.isEmpty() && stack.peek()=='R'){
                        while (!stack.isEmpty()){
                            if(stack.peek()=='R'){
                                collison++;
                            }
                            stack.pop();
                        }
                    }
                    stack.push('S');
                    break;

            }
        }

        return collison;
    }
    class CharStack {
        private final char[] data;
        private int top = -1;
        public CharStack(int capacity) { data = new char[capacity]; }
        public void push(char c) { data[++top] = c; }
        public char pop()    { return data[top--]; }
        public int peek()    { return data[top]; }
        public boolean isEmpty() { return top == -1; }
        public int size() {return top + 1; }
    }

    public static void main(String[] args) {
        CountCollisionsOnARoad soln= new CountCollisionsOnARoad();
        System.out.println(soln.countCollisions("RLRSLL"));
        System.out.println(soln.countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }
}
