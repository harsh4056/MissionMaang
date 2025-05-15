public class UnivaluedTree {


    int value=-1;
    public boolean isUnivalTree(TreeNode root) {
        if(root==null){
            return true;
        }
        else{
            value=root.val;
        }

        return preorder(root);
    }
    public boolean preorder(TreeNode root){
        if(root==null){
            return true;
        }
        return(  root.val==value && preorder(root.left) && preorder(root.right));
    }


}
