public class BinaryTreeMaximumPathSum {

    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        solve(root);
        return ans;
    }

    public int solve(TreeNode root){
        if(root==null) return 0;
        int left=solve(root.left);
        int right=solve(root.right);

        ans=Math.max(ans,root.val+left+right);

        int temp= Math.max(left,right);
        return Math.max(temp+ root.val,0);

    }



    public static void main(String[] args) {
        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();

        // Test case 1: Simple tree
        TreeNode root1 = new TreeNode(2);
        root1.left = new TreeNode(-1);

        System.out.println("Test Case 1: " + obj.maxPathSum(root1));

        // Test case 2: Tree with negative values
        BinaryTreeMaximumPathSum obj2 = new BinaryTreeMaximumPathSum();
        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(20);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);
        System.out.println("Test Case 2: " + obj2.maxPathSum(root2));

        // Test case 3: Single node tree
        BinaryTreeMaximumPathSum obj3 = new BinaryTreeMaximumPathSum();
        TreeNode root3 = new TreeNode(5);
        System.out.println("Test Case 3: " + obj3.maxPathSum(root3));
    }

}
