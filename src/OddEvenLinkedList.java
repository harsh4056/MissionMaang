public class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {

        if(head==null || head.next==null || head.next.next==null)
            return head;
        ListNode evenHolder= head.next;
        ListNode odd= head;
        ListNode even=head.next;
        ListNode current= head.next.next;
        while (current!=null && current.next!=null){
            odd.next=current;
            even.next=current.next;
            odd=odd.next;
            even=even.next;
            current=current.next.next;

        }
        if(current!=null) {
            odd.next = current;
            even.next = current.next;
        }
        if(odd.next!=even){
            odd=odd.next;
        }
        odd.next=evenHolder;

        return head;
    }

    public static void main(String[] args) {
        OddEvenLinkedList solution = new OddEvenLinkedList();

        // Helper method to create list and print result
        System.out.println(printList(solution.oddEvenList(createList(new int[]{1,2,3,4,5,6,7,8})))); //
        System.out.println(printList(solution.oddEvenList(createList(new int[]{1, 2, 3, 4, 5})))); // Expected: 1 -> 3 -> 5 -> 2 -> 4
        System.out.println(printList(solution.oddEvenList(createList(new int[]{2, 1, 3, 5, 6, 4, 7})))); // Expected: 2 -> 3 -> 6 -> 7 -> 1 -> 5 -> 4
        System.out.println(printList(solution.oddEvenList(createList(new int[]{1, 2})))); // Expected: 1 -> 2
        System.out.println(printList(solution.oddEvenList(createList(new int[]{1}))) ); // Expected: 1
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
