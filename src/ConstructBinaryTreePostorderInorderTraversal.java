import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreePostorderInorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1,
                inorderMap);
    }

    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd,
                           Map<Integer, Integer> inorderMap) {
        if (postStart > postEnd || inStart > inEnd) return null;

        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);

        int rootIndex = inorderMap.get(rootVal);
        int rightTreeSize = inEnd - rootIndex;

        root.right = build(inorder, rootIndex + 1, inEnd,
                postorder, postEnd - rightTreeSize, postEnd - 1,
                inorderMap);

        root.left = build(inorder, inStart, rootIndex - 1,
                postorder, postStart, postEnd - rightTreeSize - 1,
                inorderMap);

        return root;
    }
    public static void main(String[] args) {
        ConstructBinaryTreePreorderInorderTraversal traversal= new ConstructBinaryTreePreorderInorderTraversal();
        TreeNode treeNode=traversal.buildTree(new int[]{3,9,20,15,7},new int[]{9,3,15,20,7});
        MergeBinaryTree.printTree(treeNode);
    }


}
