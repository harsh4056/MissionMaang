package tools;

class CharStack {
    private final char[] data;
    private int top = -1;
    public CharStack(int capacity) { data = new char[capacity]; }
    public void push(char c) { data[++top] = c; }
    public char pop()    { return data[top--]; }
    public boolean isEmpty() { return top == -1; }
    public int size() {return top + 1; }
}