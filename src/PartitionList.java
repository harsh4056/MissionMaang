import java.util.Stack;

public class PartitionList {


    /*Input: head = [1,4,3,2,5,2], x = 3
    Output: [1,2,2,4,3,5]*/
    public ListNode partition(ListNode head, int x) {


        ListNode current=head;
        ListNode dummyLess=new ListNode(-101);
        ListNode dummyLessPtr=dummyLess;
        ListNode dummyMore=new ListNode(-101);
        ListNode dummyMorePtr=dummyMore;
        while (current!=null){

            if(current.val>=x){
                dummyMore.next=current;
                dummyMore=dummyMore.next;
            }
            else {
                dummyLess.next=current;
                dummyLess=dummyLess.next;
            }
            current=current.next;
        }
        dummyMore.next=null;
        dummyLess.next=dummyMorePtr.next;
        return  dummyLessPtr.next;
    }



    public static void main(String[] args) {
        PartitionList solution = new PartitionList();

        // Create a test list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = createList(new int[]{1,4,3,2,5,2});

        // Apply the method
        ListNode newHead = solution.partition(head,3);

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
