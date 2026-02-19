import java.util.Stack;

class StockSpanner {

        Stack<int[]> stack;
        int count=0;
        public StockSpanner() {
            stack= new Stack<>();

        }

        public int next(int price) {
            while(!stack.isEmpty() && stack.peek()[0]<=price){
                stack.pop();
            }

            int ans= stack.isEmpty()?count+1:count-stack.peek()[1];
            stack.push(new int[]{price,count});
            count++;
            return ans;
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