import java.util.HashMap;

public class ConstructBinaryTreePreorderInorderTraversal {


    /*
    *
    * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    * Output: [3,9,20,null,null,15,7]
    *
    * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {

        HashMap<Integer,Integer> valueIndexMap= new HashMap<>();

        for (int i = 0; i < preorder.length; i++) {
            int i1 = preorder[i];
            valueIndexMap.put(inorder[i], i);

        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1, valueIndexMap);

    }

    public TreeNode build(int[] preorder, int preOrderStart,int preOrderEnd,int[] inorder,int inOrderStart,int inOrderEnd,HashMap<Integer,Integer> map){
        if (preOrderStart > preOrderEnd) {
            return null;
        }

        int rootVal = preorder[preOrderStart];
        TreeNode root = new TreeNode(rootVal);

        int rootIndexInInorder = map.get(rootVal);
        int leftTreeSize = rootIndexInInorder - inOrderStart;

        root.left = build(preorder, preOrderStart + 1, preOrderStart + leftTreeSize,
                inorder, inOrderStart, rootIndexInInorder - 1, map);

        root.right = build(preorder, preOrderStart + leftTreeSize + 1, preOrderEnd,
                inorder, rootIndexInInorder + 1, inOrderEnd, map);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreePreorderInorderTraversal traversal= new ConstructBinaryTreePreorderInorderTraversal();
        TreeNode treeNode=traversal.buildTree(new int[]{3,9,20,15,7},new int[]{9,15,7,20,3});
        MergeBinaryTree.printTree(treeNode);
    }

}
