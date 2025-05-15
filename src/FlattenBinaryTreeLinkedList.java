import com.sun.source.tree.Tree;

public class FlattenBinaryTreeLinkedList {


    TreeNode prev = null;

    public void flatten(TreeNode root) {
        preOrder(root);
    }

    public void preOrder(TreeNode root) {
        if (root == null)
            return;

        if (prev != null) {
            prev.right = root;
            prev.left = null;
        }

        prev = root;

        // Store left and right before recursion
        TreeNode left = root.left;
        TreeNode right = root.right;

        preOrder(left);
        preOrder(right);
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;



        // Store left and right before recursion
        TreeNode left = root.left;
        TreeNode right = root.right;

        inOrder(left);
        if (prev != null) {
            prev.right = root;
            prev.left = null;
        }
        System.out.print(root.val + " ");


        inOrder(right);

    }


    /*private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }*/
    public static void main(String[] args) {
        // Construct tree: [1,2,5,3,4,null,6]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        FlattenBinaryTreeLinkedList solution = new FlattenBinaryTreeLinkedList();
        solution.inOrder(root);

        // Print result as right-skewed list
        TreeNode current = root;
        while (current != null) {
            System.out.println();
            System.out.print(current.val + " ");
            current = current.right;
        }
    }

}
