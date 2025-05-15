import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MinimumDistanceBST {


    public int minDiffInBST(TreeNode root) {
        inorder(root);
        return min;
    }
    int prev=Integer.MAX_VALUE;
    int min=Integer.MAX_VALUE;
    public void inorder(TreeNode root){
        if(root==null)
            return;
        inorder(root.left);
        int value=Math.abs(root.val-(prev));
        min=Math.min(min,value);
        prev=root.val;
        inorder(root.right);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(0);
        root.right = new TreeNode(48);

        // root.left.left = null;
        // root.left.right = null;

        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(49);
        MinimumDistanceBST minimumDistanceBST= new MinimumDistanceBST();
        minimumDistanceBST.minDiffInBST(root);
    }


}
