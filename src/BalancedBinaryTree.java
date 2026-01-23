public class BalancedBinaryTree {



    public boolean isBalanced(TreeNode root) {
        int height=getHeight(root);
        return height!=Integer.MAX_VALUE;
    }
    public int getHeight(TreeNode root){
        if(root==null) return 0;
        int left=getHeight(root.left);
        int right=getHeight(root.right);
        if(Math.abs(right-left)>1) return Integer.MAX_VALUE;
        if(left==Integer.MAX_VALUE || right==Integer.MAX_VALUE) return Integer.MAX_VALUE;
        return 1+Math.max(left,right);
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
