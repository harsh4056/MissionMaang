import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p, q);
    }

    private TreeNode dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        if (root == p || root == q) return root;

        TreeNode left = dfs(root.left, p, q);
        TreeNode right = dfs(root.right, p, q);

        if (left != null && right != null) {
            return root; // p and q found in different subtrees
        }

        return left != null ? left : right;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        LowestCommonAncestor solution = new LowestCommonAncestor();

        TreeNode result1 = solution.lowestCommonAncestor(root, root, root.left.right.left);
        System.out.println("LCA of 3 and 7: " + result1.val); // Expected: 3

        TreeNode result2 = solution.lowestCommonAncestor(root, root.left, root.left.right.right);
        System.out.println("LCA of 5 and 4: " + result2.val); // Expected: 5

        TreeNode result3 = solution.lowestCommonAncestor(root, root.right.left, root.right.right);
        System.out.println("LCA of 0 and 8: " + result3.val); // Expected: 1
    }

}
