import java.util.Stack;

public class ReverseLinkedListII

{

    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy=new ListNode(501);
        dummy.next=head;
        ListNode current= dummy;
        Stack<ListNode> stack=new Stack<>();
        int count=0;
        while(count<left-1){
            current=current.next;
            count++;
        }
        ListNode start=current;

        while(count<right){

            current=current.next;
            stack.push(current);
            count++;
        }
        ListNode last=stack.peek().next;
        while(!stack.isEmpty()){
            start.next=stack.pop();
            start=start.next;
        }
        start.next=last;
        return dummy.next;


    }

    public static void main(String[] args) {
        // Build linked list: [1,2,3,4,5]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        // Call reverseBetween
        ReverseLinkedListII obj = new ReverseLinkedListII();
        ListNode newHead = obj.reverseBetween(head, 2, 3);
        ListNode newHead1 = obj.reverseBetween(new ListNode(5), 1, 1);

        // Print list
        printList(newHead);
        printList(newHead1);
    }

    public static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) System.out.print(" -> ");
            node = node.next;
        }
        System.out.println();
    }


}
