public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null && slow != fast) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return (fast == slow);
    }




    public static void main(String[] args) {
        // Create nodes
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Link nodes
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // Creates cycle (tail connects to node2)

        LinkedListCycle cycleChecker = new LinkedListCycle();
        System.out.println("Test case 1 (should be true): " + cycleChecker.hasCycle(node1));

        // Another list without cycle
        ListNode singleNode = new ListNode(1);

        System.out.println("Test case 2 (should be false): " + cycleChecker.hasCycle(singleNode));
    }

}
