public class RemoveNthNodeFromEndList {


    public ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode early = dummy;
        ListNode late = dummy;

// Step 1: Move early n+1 steps forward (so that late points one node before the one to delete)
        for (int i = 0; i <= n; i++) {
            early = early.next;
        }

// Step 2: Move early and late together until early reaches null
        while (early != null) {
            early = early.next;
            late = late.next;
        }

// Step 3: Delete the node
        late.next = late.next.next;

        return dummy.next;

    }
}
