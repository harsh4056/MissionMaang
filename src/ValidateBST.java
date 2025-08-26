public class ValidateBST {
    boolean result=true;
    long prev= Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
         result=true;
         findOut(root);
         return result;

    }
    public void findOut(TreeNode root){
        if(root==null) return ;
        if(!result) return;
        findOut(root.left);
        if(prev<root.val){
            prev=root.val;
        }else{
            result=false;
        }
        findOut(root.right);

    }

    public static void main(String[] args) {
        ValidateBST solution = new ValidateBST();

        // Test case 1: Valid BST
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        //System.out.println(solution.isValidBST(root1)); // Expected: true

        // Test case 2: Invalid BST (from given example [5,4,6,null,null,3,7])
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(6);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(7);
        System.out.println(solution.isValidBST(root2)); // Expected: false

        // Test case 3: Single node tree
        TreeNode root3 = new TreeNode(1);
        System.out.println(solution.isValidBST(root3)); // Expected: true
    }

}
