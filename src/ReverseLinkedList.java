public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {

        ListNode current=head;
        ListNode forward;
        ListNode previous=null;

        while (current.next!=null){
            forward=current.next;
            current.next=previous;
            previous=current;
            current=forward;
        }
        current.next=previous;

        head=current;
        return head;
    }


    public static void main(String[] args) {
        ReverseLinkedList solution = new ReverseLinkedList();

        // Create a test list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = createList(new int[]{1,2,3,4,5});

        // Apply the method
        ListNode newHead = solution.reverseList(head.next);

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
