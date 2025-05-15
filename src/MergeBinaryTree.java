public class MergeBinaryTree {


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        root2.val = root1.val + root2.val;
        root2.left = mergeTrees(root1.left, root2.left);
        root2.right = mergeTrees(root1.right, root2.right);
        return root2;
    }
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(5);

        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        root2.left.right = new TreeNode(4);
        root2.right.right = new TreeNode(7);

        MergeBinaryTree mbt = new MergeBinaryTree();
        TreeNode merged = mbt.mergeTrees(root1, root2);

        printTree(merged);
    }
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.print("null ");
            return;
        }
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
