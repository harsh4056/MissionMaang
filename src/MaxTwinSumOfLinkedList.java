import java.util.Stack;

public class MaxTwinSumOfLinkedList {
        int max=0;
    public int pairSum(ListNode head) {
        max=0;
        recursePairSum(head,head);
        return max;
    }

    public ListNode recursePairSum(ListNode head,ListNode first){
        if(head==null){
            return first;
        }
        ListNode half=recursePairSum(head.next,first);
        max= Math.max(half.val+head.val,max);
        return half.next;
    }


    public int pairSum2(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;
        int max=0;
        IntStack stack = new IntStack(10000);
        while(fast!=null){
            stack.push(slow.val);
            slow=slow.next;
            fast=fast.next.next;
        }

        while(slow!=null){
            max=Math.max(slow.val+stack.pop(),max);
            slow=slow.next;

        }

       return max;
    }

    public class IntStack {


        private final int[] data;
        private int top = -1;
        public IntStack(int capacity) { data = new int[capacity]; }
        public void push(int c) { data[++top] = c; }
        public int pop()    { return data[top--]; }
        public int peek()    { return data[top]; }
        public boolean isEmpty() { return top == -1; }
        public int size() {return top + 1; }
    }
    public static void main(String[] args) {
        MaxTwinSumOfLinkedList solution = new MaxTwinSumOfLinkedList();

        System.out.println(solution.pairSum2(createList(new int[]{1, 2, 13, 4,5,6,7,8}))); //19
        System.out.println(solution.pairSum2(createList(new int[]{1, 2}))); //3

    }

    private static ListNode createList(int[] vals) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : vals) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }

}
