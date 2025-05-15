public class RemoveDuplicatesFromSortedListII {



    public ListNode deleteDuplicates(ListNode head) {


        ListNode prev=new ListNode(-101);
        ListNode nodeZero=prev;
        prev.next=head;

        ListNode current=head;
        boolean duplicate;
        while(current!=null){
            duplicate=false;
            ListNode holder=current;
            while (current.next!=null && current.val==current.next.val  ){
                current=current.next;
                duplicate=true;
            }

            if(!duplicate){
                prev.next=current;
                prev=current;
            }
            current=current.next;
            if(duplicate && current==null){
                prev.next= null;

            }

        }

        return nodeZero.next;

    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedListII solution = new RemoveDuplicatesFromSortedListII();

        // Create a test list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = createList(new int[]{1,1,1,2,3,3});

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
