import java.util.List;

public class ReverseNodesInKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy=new ListNode(-101);
        ListNode zeroHead=dummy;
        dummy.next=head;
        while(zeroHead!=null){
            int count=k;
            ListNode current=zeroHead.next;
            while (current!=null && count>0){
                current=current.next;
                count--;

            }
            if(count>0){
                return dummy.next;
            }

            Pair nodes= reverseList(zeroHead.next,k);
            ListNode temp=zeroHead.next;
            zeroHead.next.next=nodes.end;
            zeroHead.next=nodes.start;
            zeroHead=temp;


        }


        return  dummy.next;


    }

    public Pair reverseList(ListNode head,int length){
        ListNode current=head;
        ListNode forward;
        ListNode previous=null;

        while (length>1){
            forward=current.next;
            current.next=previous;
            previous=current;
            current=forward;
            length--;
        }
        ListNode end=current.next;
        current.next=previous;

        head=current;
        return new Pair(head,end);
    }

    class Pair{
        ListNode start;
        ListNode end;

        public Pair(ListNode start, ListNode end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

        // Create a test list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = createList(new int[]{1,2,3,4,5,6});

        // Apply the method
        ListNode newHead = solution.reverseKGroup(head,3);

        // Print the result
        printList(newHead);
    }

    // Helper to create list from array
    private static ListNode createList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper to print list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }


}
