package tools;

public class IntStack {


    private final int[] data;
    private int top = -1;
    public IntStack(int capacity) { data = new int[capacity]; }
    public void push(char c) { data[++top] = c; }
    public int pop()    { return data[top--]; }
    public boolean isEmpty() { return top == -1; }
}
