public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {


        ListNode dummyNode=new ListNode(-101);
        ListNode mergedHead=dummyNode;
        int carry=0;
        while(l2!=null || l1!=null){
            ListNode temp;
            int l1Value=l1==null?0:l1.val;
            int l2Value=l2==null?0:l2.val;
            int sum=(l1Value+l2Value+carry);
            temp=new ListNode(sum%10);
            carry=(sum)/10;
            l1=l1==null?null:l1.next;
            l2=l2==null?null:l2.next;
            dummyNode.next=temp;
            dummyNode=dummyNode.next;
        }
        if(carry > 0){
            dummyNode.next = new ListNode(carry);
        }

        return mergedHead.next;
        
    }
    public static void main(String[] args) {

        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);


        // Call the method
        AddTwoNumbers solution = new AddTwoNumbers();
        ListNode result = solution.addTwoNumbers(l1, l2);

        // Print the result
        printList(result);
    }

    // Helper method to print the list
    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
    }
}



