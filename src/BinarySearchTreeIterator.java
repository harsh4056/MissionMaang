import java.util.Stack;

public class BinarySearchTreeIterator {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

    static class BSTIterator {
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            pushLeftChain(root);
        }

        private void pushLeftChain(TreeNode node) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
        }

        public int next() {
            TreeNode current = stack.pop();
            if (current.right != null) {
                pushLeftChain(current.right);
            }
            return current.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        // Constructing the tree:
        //       7
        //      / \
        //    15   3
        //   /  \
        //  9   20

        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator iterator = new BSTIterator(root);

        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        // Expected Output: 9 15 20 7 3
    }

}
