public class BalancedBinaryTree {



    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;

        int left=height(root.left);
        int right=height(root.right);
        return Math.abs(right-left)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int height(TreeNode root){
        if(root==null)
            return 0;

        return Math.max(height(root.left),height(root.right))+1;
    }

    public static void main(String[] args) {
        // Level 0
        TreeNode root = new TreeNode(1);

        // Level 1
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        // Level 2
        root.left.left = new TreeNode(3);
        // root.left.right = null;
        // root.right.left = null;
        root.right.right = new TreeNode(3);

        // Level 3
        root.left.left.left = new TreeNode(4);
        root.right.right.right = new TreeNode(4);
        BalancedBinaryTree tree= new BalancedBinaryTree();
        System.out.println(tree.isBalanced(root));

    }

}
