public class MaximumDepthBinaryTree {

    public int maxDepth(TreeNode root) {

        int max=Math.max(root.right==null?0:maxDepth(root.right),root.left==null?0:maxDepth(root.left))+1;
        return  max;
    }
    public static void main(String[] args) {
        MaximumDepthBinaryTree tree = new MaximumDepthBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = tree.maxDepth(root);
        System.out.println("Maximum Depth: " + depth); // Expected: 3
    }

}
