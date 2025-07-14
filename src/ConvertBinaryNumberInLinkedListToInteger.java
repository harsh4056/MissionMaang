public class ConvertBinaryNumberInLinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        int ans=0;
        ListNode current=head;
        while(current!=null){
            ans=ans|current.val;
            ans=ans<<1;
            current=current.next;
        }
        ans=ans>>1;
        return ans;
    }
    public static void main(String[] args) {
        ConvertBinaryNumberInLinkedListToInteger solution = new ConvertBinaryNumberInLinkedListToInteger();

        ListNode head1 = new ListNode(1, new ListNode(0, new ListNode(1))); // Binary 101
        System.out.println(solution.getDecimalValue(head1)); // Expected: 5

        ListNode head2 = new ListNode(1, new ListNode(1)); // Binary 11
        System.out.println(solution.getDecimalValue(head2)); // Expected: 3

        ListNode head3 = new ListNode(0); // Binary 0
        System.out.println(solution.getDecimalValue(head3)); // Expected: 0
    }

}
