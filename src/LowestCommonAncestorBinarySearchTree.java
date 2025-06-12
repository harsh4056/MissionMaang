public class LowestCommonAncestorBinarySearchTree {


    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(p.val<=root.val && q.val>=root.val){
            return root;
        }
        else if(q.val<=root.val && p.val>=root.val){
            return root;
        } else if (q.val<root.val) {
            return lowestCommonAncestor(root.left,p,q);
        }
        else {
            return lowestCommonAncestor(root.right,p,q);

        }

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        LowestCommonAncestorBinarySearchTree lca = new LowestCommonAncestorBinarySearchTree();

       /* TreeNode p1 = root.left; // 2
        TreeNode q1 = root.right; // 8
        System.out.println(lca.lowestCommonAncestor(root, p1, q1).val); // Expected: 6*/

        TreeNode p2 = root.left; // 2
        TreeNode q2 = root.left.right; // 4
        System.out.println(lca.lowestCommonAncestor(root, p2, q2).val); // Expected: 2

        TreeNode p3 = root.left.right.left; // 3
        TreeNode q3 = root.left.right.right; // 5
        System.out.println(lca.lowestCommonAncestor(root, p3, q3).val); // Expected: 4
    }

}
