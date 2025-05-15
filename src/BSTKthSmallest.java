public class BSTKthSmallest {

    int limit=0;
    int value;
    public int kthSmallest(TreeNode root, int k) {
        limit=k;
        smallest(root);
        return value;
    }
    public int smallest(TreeNode root){
        if(root==null)
            return -1;
        smallest(root.left);
        limit--;
        if(limit==0)
         value= root.val;
        smallest(root.right);
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
      /*  TreeNode root = new TreeNode(3);

        root.left = new TreeNode(1);
        root.right = new TreeNode(4);


        root.left.right = new TreeNode(2);*/

        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);

        // Tree is now built. You can do stuff like:
       BSTKthSmallest bstKthSmallest= new BSTKthSmallest();
       System.out.println(bstKthSmallest.kthSmallest(root,4));

    }

}
