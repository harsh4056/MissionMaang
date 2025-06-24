import java.util.Stack;

class StockSpanner {
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }

        stack.push(new int[]{price, span});
        return span;
    }
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();

        System.out.println(stockSpanner.next(100)); // Expected: 1
        System.out.println(stockSpanner.next(80));  // Expected: 1
        System.out.println(stockSpanner.next(60));  // Expected: 1
        System.out.println(stockSpanner.next(70));  // Expected: 2
        System.out.println(stockSpanner.next(60));  // Expected: 1
        System.out.println(stockSpanner.next(75));  // Expected: 4
        System.out.println(stockSpanner.next(85));  // Expected: 6
    }

}