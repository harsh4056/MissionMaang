import java.util.HashMap;

public class ConstructBinaryTreePreorderInorderTraversal {


    /*
    *
    * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    * Output: [3,9,20,null,null,15,7]
    *
    * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return null;
    }


    public static void main(String[] args) {
        ConstructBinaryTreePreorderInorderTraversal traversal= new ConstructBinaryTreePreorderInorderTraversal();
        TreeNode treeNode=traversal.buildTree(new int[]{3,9,20,15,7},new int[]{9,15,7,20,3});
        MergeBinaryTree.printTree(treeNode);
    }

}
