import java.util.List;

public class ReverseNodesInKGroup {


    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1) return head;
        ListNode[]list=null;
        int c=1;
        ListNode curr=head;
        while(c<k){
            curr=curr.next;
            c++;
        }
        ListNode nHead=head;
        if(c==k) nHead=curr;
        curr=head;
        ListNode lastEnd=null;

        while (canReverse(curr,k)){
           list= reverseK(curr,k);
           if(lastEnd!=null)
            lastEnd.next=list[1];
           lastEnd=list[0];
           curr=list[2];
        }
        if(lastEnd!=null)
         lastEnd.next=curr;


        return nHead;
    }
    public boolean canReverse(ListNode head,int k){
        int c=0;
        ListNode curr=head;
        while(c<k && curr!=null){
            curr=curr.next;
            c++;
        }
        return c==k;
    }
    public ListNode[] reverseK(ListNode head,int k){
        int c=0;
        ListNode curr=head;
        ListNode[] arr= new ListNode[3];
        arr[0]=curr;
        ListNode prev=null;
        while(c<k){
            ListNode temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;

            c++;
            if(c==k-1){
                arr[1]=curr;
            }
        }
        arr[2]=curr;
        return arr;
    }


    public static void main(String[] args) {
        ReverseNodesInKGroup solution = new ReverseNodesInKGroup();

        // Create a test list: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
        ListNode head = createList(new int[]{1,2,3,4,5,6,7,8,9});

        // Apply the method
        ListNode newHead = solution.reverseKGroup(head,2 );

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
