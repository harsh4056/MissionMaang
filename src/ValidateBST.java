public class ValidateBST {
    int prev=Integer.MIN_VALUE;
    boolean first=true;
    public boolean isValidBST(TreeNode root) {
        if(root==null)
            return true;
        boolean b1=isValidBST(root.left);
        boolean b2=prev<root.val;
        if(first){
            first=false;
            b2=true;
        }
        prev=root.val;
        boolean b3=isValidBST(root.right);
        return b1&&b2&&b3;

    }

    public static void main(String[] args) {
        ValidateBST validateBST= new ValidateBST();
        TreeNode root = new TreeNode(2);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);


        System.out.println(validateBST.isValidBST(root));
    }
}
