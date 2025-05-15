import java.util.List;

public class MergeTwoSortedLists {


    /*
    *
list1: 1 → 2 → 4

list2: 1 → 3 → 4
    *
    * */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {



        ListNode dummyNode=new ListNode(-101);
        ListNode mergedHead=dummyNode;
        while(list2!=null || list1!=null){
            ListNode temp;
            if(list2 == null  ||  list1!=null && list1.val < list2.val ){
                temp = list1;
              list1=list1.next;
            }
          else{
                temp = list2;
              list2=list2.next;
            }
            dummyNode.next=temp;
          dummyNode=dummyNode.next;
        }

        return mergedHead.next;
    }

    // Helper method to create linked list from array
    public static ListNode createList(int[] values) {
        if (values.length == 0) return null;

        ListNode head = new ListNode(values[0]);
        ListNode current = head;

        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }

        return head;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MergeTwoSortedLists solution = new MergeTwoSortedLists();

        int[] arr1 = {1, 2, 4};
        int[] arr2 = {1,3,4,5};

        ListNode list1 = createList(arr1);
        ListNode list2 = createList(arr2);

        System.out.println("List 1:");
        printList(list1);

        System.out.println("List 2:");
        printList(list2);

        ListNode merged = solution.mergeTwoLists(list1, list2);

        System.out.println("Merged List:");
        printList(merged);
    }


}
