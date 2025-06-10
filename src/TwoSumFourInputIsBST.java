import java.util.HashSet;

public class TwoSumFourInputIsBST {


    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set= new HashSet<>();
        return inorder(root,k,set);
    }

    public boolean inorder(TreeNode root, int k, HashSet<Integer> set){
        if (root == null) return false;

        if (set.contains(k - root.val)) return true;

        set.add(root.val);

        return inorder(root.left, k, set) || inorder(root.right, k, set);
    }

}
