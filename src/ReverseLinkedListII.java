import java.util.Stack;

public class ReverseLinkedListII

{

    public ListNode reverseBetween(ListNode head, int left, int right) {

        Stack<ListNode> stack= new Stack<>();
        ListNode current=head;
        ListNode newHead=null;
        int r=right;
        int l=left;
        if(left==1){
            l++;
            r++;
            current= new ListNode(0);
            newHead=current;
            current.next=head;
        }


        ListNode leftEnd=null;
        ListNode rightEnd=null;
        while(current!=null){

            if(l==2){
                leftEnd=current;
            }

            if (r==0){
                rightEnd=current;
            }

            if(r==0 && l==2){
                break;
            }
            current=current.next;
            l--;
            r--;
        }
        if(leftEnd!=null) {
            ListNode traverse = leftEnd.next;
            while (traverse != rightEnd && traverse != null) {
                stack.add(traverse);
                traverse = traverse.next;
            }
            while (!stack.empty() && leftEnd != null) {

                leftEnd.next = stack.pop();
                leftEnd = leftEnd.next;
            }
            if (leftEnd != null)
                leftEnd.next = rightEnd;
        }
        if(newHead!=null)
            return newHead.next;

        return head;


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
