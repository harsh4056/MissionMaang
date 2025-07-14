class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    public ListNode(int x, ListNode listNode) {
        val=x;
        next=listNode;
    }
}