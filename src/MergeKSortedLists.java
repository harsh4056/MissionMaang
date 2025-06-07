import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode list : lists) {
            if(list!=null) {
                minHeap.offer(list);
            }
        }
        ListNode head= minHeap.poll();
        if(head!=null && head.next!=null){
            minHeap.offer(head.next);
        }
        ListNode current=head;
        while (!minHeap.isEmpty()){
            ListNode poppedNode= minHeap.poll();
            if(poppedNode.next!=null){
                minHeap.offer(poppedNode.next);
            }
            current.next=poppedNode;
            current=current.next;
        }
        return head;
    }

    /*
    * ListNode mergeKLists(ListNode[] lists) {
    if (lists.length == 0) return null;

    int interval = 1;
    while (interval < lists.length) {
        for (int i = 0; i + interval < lists.length; i = i + interval * 2) {
            lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
        }
        interval *= 2;
    }
    return lists[0];
}

    *
    * */

    public static void main(String[] args) {
        MergeKSortedLists merge = new MergeKSortedLists();

        // Test Case 1: 3 sorted lists
        ListNode[] lists1 = new ListNode[]{
                buildList(new int[]{1, 4, 5}),
                buildList(new int[]{1, 3, 4}),
                buildList(new int[]{2, 6})
        };
        ListNode result1 = merge.mergeKLists(lists1);
        printList(result1);

        // Test Case 2: some lists are empty
        ListNode[] lists2 = new ListNode[]{
                buildList(new int[]{}),
                buildList(new int[]{1}),
                buildList(new int[]{0, 2, 5})
        };
        ListNode result2 = merge.mergeKLists(lists2);
        printList(result2);

        // Test Case 3: all lists empty
        ListNode[] lists3 = new ListNode[]{
                buildList(new int[]{}),
                buildList(new int[]{}),
                buildList(new int[]{})
        };
        ListNode result3 = merge.mergeKLists(lists3);
        printList(result3);
    }

    // Helper method to build list from array
    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print list
    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }


}
