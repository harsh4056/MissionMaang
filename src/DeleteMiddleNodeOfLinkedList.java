import java.util.List;

public class DeleteMiddleNodeOfLinkedList {

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode fast= head;
        ListNode slow=dummy;

        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return head;
    }


    public static void main(String[] args) {
        DeleteMiddleNodeOfLinkedList solution = new DeleteMiddleNodeOfLinkedList();

        // Helper method to create list and print result
        System.out.println(printList(solution.deleteMiddle(createList(new int[]{1,2,3,4,5})))); // Expected: 1 -> 2 -> 4 -> 5
        System.out.println(printList(solution.deleteMiddle(createList(new int[]{1, 3, 4, 7, 1, 2, 6})))); // Expected: 1 -> 3 -> 4 -> 1 -> 2 -> 6
        System.out.println(printList(solution.deleteMiddle(createList(new int[]{1, 2, 3, 4})))); // Expected: 1 -> 2 -> 4
        System.out.println(printList(solution.deleteMiddle(createList(new int[]{2, 1})))); // Expected: 2
        System.out.println(printList(solution.deleteMiddle(createList(new int[]{1})))); // Expected: null
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

    private static String printList(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(" -> ");
            head = head.next;
        }
        return sb.toString();
    }

}
