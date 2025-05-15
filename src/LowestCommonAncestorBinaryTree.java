import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorBinaryTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Set<TreeNode> pPathSet = new HashSet<>();
        findPathToSet(root, p, pPathSet);

        TreeNode[] result = new TreeNode[1]; // simulate pass-by-reference
        findLCAFromQ(root, q, pPathSet, result);
        return result[0];
    }

    // Store path from root to p in a HashSet
    boolean findPathToSet(TreeNode root, TreeNode target, Set<TreeNode> set) {
        if (root == null) return false;

        if (root == target ||
                findPathToSet(root.left, target, set) ||
                findPathToSet(root.right, target, set)) {
            set.add(root);
            return true;
        }

        return false;
    }

    // Traverse from q up using recursion and check for first node in p's path
    TreeNode findLCAFromQ(TreeNode root, TreeNode target, Set<TreeNode> pPathSet, TreeNode[] result) {
        if (root == null) return null;

        if (root == target ||
                findLCAFromQ(root.left, target, pPathSet, result) != null ||
                findLCAFromQ(root.right, target, pPathSet, result) != null) {

            if (result[0] == null && pPathSet.contains(root)) {
                result[0] = root;
            }

            return root;
        }

        return null;
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
        TreeNode q = root.right; // 1

        LowestCommonAncestorBinaryTree lcaFinder = new LowestCommonAncestorBinaryTree();
        TreeNode lca = lcaFinder.lowestCommonAncestor(root, p, q);

        System.out.println("LCA of " + p.val + " and " + q.val + " is: " + lca.val); // Expected: 5
    }
}
