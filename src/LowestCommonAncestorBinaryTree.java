public class LowestCommonAncestorBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q)
            return root;
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if(left!=null && right!=null){
            return root;
        }
        else if(left==null){
            return right;
        }
        else {
            return left;
        }

    }

    // Sample main to test
    public static void main(String[] args) {
        // Build the tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // 5
        TreeNode q = root.left.right.right; // 4

        LowestCommonAncestorBinaryTree lcaFinder = new LowestCommonAncestorBinaryTree();
        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);

        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // Expected: 5
    }
}
