import java.util.HashMap;
import java.util.HashSet;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {

        Node newHead= new Node(-100);
        Node newPointer=newHead;
        Node oldPointer=head;

        HashMap<Node,Node> nodeHashMap= new HashMap<>();
        while(oldPointer!=null){
            newPointer.next= new Node(oldPointer.val);
            nodeHashMap.put(oldPointer,newPointer.next);
            newPointer=newPointer.next;
            oldPointer=oldPointer.next;
        }
        newPointer=newHead.next;
        oldPointer=head;

        while(oldPointer!=null){
            newPointer.random= nodeHashMap.get(oldPointer.random);
            newPointer=newPointer.next;
            oldPointer=oldPointer.next;
        }

        return newHead.next;
    }


    public Node copyRandomList2(Node head) {
        Node newHead= new Node(-100);
        Node newPointer=newHead;
        Node oldPointer=head;


        while(oldPointer!=null){
            newPointer.next= new Node(oldPointer.val);
            newPointer=newPointer.next;
            newPointer.next=oldPointer.next;
            oldPointer.next=newPointer;
            oldPointer=newPointer.next;
        }
        newPointer = newHead.next; // Move newPointer to the first copy (skip dummy)
        oldPointer = head;
        while (oldPointer != null) {
            if (oldPointer.random != null) {
                newPointer.random = oldPointer.random.next;
            } else {
                newPointer.random = null;
            }
            newPointer = newPointer.next;
            oldPointer = oldPointer.next;
        }

// SECOND: detach the list
        newPointer = newHead;
        oldPointer = head;
        while (oldPointer != null) {
            newPointer.next = newPointer.next.next;
            oldPointer.next = oldPointer.next.next;
            newPointer = newPointer.next;
            oldPointer = oldPointer.next;
        }
        return newHead.next;

    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
