public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int size=0;
        ListNode current=head;
        while (current!=null){
            size++;
            current=current.next;
        }
        if(k==size){
            return head;
        }
        if(size<k){
            k=k%size;
        }
        ListNode dummy= new ListNode(-101);
        dummy.next=head;
        current=dummy;
        ListNode early=dummy;
        int move=k;
        while (move>0){
            early=early.next;
            move--;
        }
        while(early.next!=null){
            current=current.next;
            early=early.next;
        }
        early.next=head;
        head=current.next;
        current.next=null;

        return  head;


    }


    public static void main(String[] args) {
        RotateList solution = new RotateList();

        // Create a test list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = createList(new int[]{0,1,2});

        // Apply the method
        ListNode newHead = solution.rotateRight(head,3);

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
