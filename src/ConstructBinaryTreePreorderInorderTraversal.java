import java.util.HashMap;

public class ConstructBinaryTreePreorderInorderTraversal {


    /*
    *
    * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    * Output: [3,9,20,null,null,15,7]
    *
    * */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hashMap= new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            hashMap.put(inorder[i],i);
        }
        return build(0,preorder.length-1,preorder,0,inorder.length-1,inorder,hashMap);
    }

    public TreeNode build(int preStart,int preEnd,int[]preOrder,int inStart,int inEnd,int[] inorder,HashMap<Integer,Integer> hashMap){
        if(preStart>preEnd|| inStart>inEnd){
            return null;
        }
        int inorderIndex= hashMap.get(preOrder[preStart]);
        TreeNode root= new TreeNode(inorder[inorderIndex]);
        int size=inorderIndex-inStart;
        root.left= build(preStart+1,preStart+size,preOrder,inStart,inorderIndex-1,inorder,hashMap);
        root.right= build(preStart+size+1,preEnd,preOrder,inorderIndex+1,inEnd,inorder,hashMap);
        return root;
    }


    public static void main(String[] args) {
        ConstructBinaryTreePreorderInorderTraversal traversal= new ConstructBinaryTreePreorderInorderTraversal();
        TreeNode treeNode=traversal.buildTree(new int[]{3,9,20,15,7},new int[]{9,15,7,20,3});
        MergeBinaryTree.printTree(treeNode);
    }

}
