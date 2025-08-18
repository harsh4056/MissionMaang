public class RemoveDuplicatesFromSortedListII {



    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy= new ListNode(101);
        dummy.next=head;
        ListNode current=dummy;
        ListNode ahead;
        while(current!=null){
            ahead=current.next;
            if(ahead!=null &&ahead.next!=null &&ahead.val==ahead.next.val) {
                while (ahead.next != null && ahead.val == ahead.next.val) {
                    ahead = ahead.next;
                }
                current.next=ahead.next;
            }
            else{
                current=current.next;
            }

        }
        return dummy.next;

    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();

        // Create a test list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = createList(new int[]{1,1,1,2,2,3,3});

        // Apply the method
        ListNode newHead = solution.deleteDuplicates(head);

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
