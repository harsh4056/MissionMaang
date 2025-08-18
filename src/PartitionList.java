import java.util.Stack;

public class PartitionList {


    /*Input: head = [1,4,3,2,5,2], x = 3
    Output: [1,2,2,4,3,5]*/
    public ListNode partition(ListNode head, int x) {


        ListNode dummy=new ListNode(-101);
        dummy.next=head;
        ListNode current=dummy;
        ListNode ahead=head;
        while(ahead.val<x){
            ahead=ahead.next;
            current=current.next;
        }
        while(ahead!=null &&ahead.next!=null ){
            if(ahead.next.val<x){
                ListNode temp=ahead.next;
                ahead.next=ahead.next.next;
                ListNode next=current.next;
                current.next=temp;
                temp.next=next;
                current=current.next;
            }
            ahead=ahead.next;
        }
        return dummy.next;
    }



    public static void main(String[] args) {
        PartitionList solution = new PartitionList();

        // Create a test list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = createList(new int[]{1,4,3,2,5,2});

        // Apply the method
        ListNode newHead = solution.partition(head,3);

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
