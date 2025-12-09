package tools;

public class IntStack {


    private  int[] data;
    private final int capacity;
    private int top = -1;
    public IntStack(int capacity) {
        this.capacity=capacity;
        data = new int[capacity];
    }
    public void clear(){data = new int[capacity];}
    public void push(int c) { data[++top] = c; }
    public int pop()    { return data[top--]; }
    public int peek()    { return data[top]; }
    public boolean isEmpty() { return top == -1; }
    public int size() {return top + 1; }
}
