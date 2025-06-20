public class ReverseALinkedList {

    public ListNode reverseList(ListNode head) {
        if(head==null)
            return null;
        ListNode[] answer = new ListNode[1];
        reverse(head,head.next,answer);
        head.next=null;
        return answer[0];

    }

    public void reverse(ListNode head, ListNode second,ListNode[] answer){
        if(second==null) {
            answer[0]=head;
            return;
        }
        reverse(head.next,second.next,answer);
        second.next=head;
    }

    public static void main(String[] args) {
        ReverseALinkedList solution = new ReverseALinkedList();

        // Helper method to create list and print result
        System.out.println(printList(solution.reverseList(createList(new int[]{1, 2, 3, 4, 5})))); // Expected: 5 -> 4 -> 3 -> 2 -> 1
        System.out.println(printList(solution.reverseList(createList(new int[]{1, 2})))); // Expected: 2 -> 1
        System.out.println(printList(solution.reverseList(createList(new int[]{1})))); // Expected: 1
        System.out.println(printList(solution.reverseList(createList(new int[]{})))); // Expected: (empty string or null)
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
