import java.util.ArrayDeque;
import java.util.Queue;

public class PopulatingNextRightPointers {

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };
    public Node connect(Node root) {
        Node dummy = new Node (-1,null,null,root);
        Queue<Node> nodeQueue = new ArrayDeque<>();
        Node currentLevel=dummy;



        while (currentLevel.next!=null) {
            Node traverse=currentLevel;
            while (traverse.next != null) {
                if(traverse.next.left!=null)
                 nodeQueue.offer(traverse.next.left);
                if(traverse.next.right!=null)
                 nodeQueue.offer(traverse.next.right);
                traverse = traverse.next;

            }
            currentLevel.left = new Node(-1, null, null, null);
            traverse = currentLevel.left;
            while (!nodeQueue.isEmpty()) {

                traverse.next = nodeQueue.poll();
                traverse = traverse.next;

            }
            currentLevel = currentLevel.left;
        }

        return dummy.next;
    }



    public Node connect2(Node root) {

        Queue<Node> nodeQueue = new ArrayDeque<>();
        Queue<Integer> valueQueue = new ArrayDeque<>();

        valueQueue.offer(root.val);
        root.val=0;
        nodeQueue.offer(root);

        while(!nodeQueue.isEmpty()){

            Node current= nodeQueue.poll();
            if(!nodeQueue.isEmpty() && current.val==nodeQueue.peek().val) {
                current.next = nodeQueue.peek() == null ? null : nodeQueue.peek();
            }

            if(current.left!=null) {
                valueQueue.offer(current.left.val);
                current.left.val=current.val+1;
                nodeQueue.offer(current.left);
            }
            if(current.right!=null) {
                valueQueue.offer(current.right.val);
                current.right.val=current.val+1;
                nodeQueue.offer(current.right);
            }
            if(!valueQueue.isEmpty())
                current.val=valueQueue.poll();

        }


        return root;

    }


    public static void main(String[] args) {
        PopulatingNextRightPointers solution = new PopulatingNextRightPointers();

        // Test case 1
        Node node1 = solution.new Node(1);
        Node node2 = solution.new Node(2);
        Node node3 = solution.new Node(3);
        Node node4 = solution.new Node(4);
        Node node5 = solution.new Node(5);
        Node node6 = solution.new Node(6);
        Node node7 = solution.new Node(7);

        node1.left = node2; node1.right = node3;
        node2.left = node4; node2.right = node5;
        node3.left = node6; node3.right = node7;

        Node result1 = solution.connect2(node1);
        printTreeWithNext(result1); // Expected: 1->null, 2->3->null, 4->5->6->7->null

        // Test case 2
        Node single = null;
        Node result2 = solution.connect2(single);
        printTreeWithNext(result2); // Expected: 10->null
    }

    public static void printTreeWithNext(Node root) {
        while (root != null) {
            Node curr = root;
            while (curr != null) {
                System.out.print(curr.val + "->");
                curr = curr.next;
            }
            System.out.println("null");
            root = root.left;
        }
    }

}
