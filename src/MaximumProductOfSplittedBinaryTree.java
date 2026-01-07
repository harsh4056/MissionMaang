public class MaximumProductOfSplittedBinaryTree {
    long sum=0;
    long ans=Integer.MIN_VALUE;

    public int maxProduct(TreeNode root) {
        sum=0;
        ans=Integer.MIN_VALUE;

        dfs(root);
        solve(root);
        return (int) (ans%(1e9+7));
    }
    public void dfs(TreeNode root){
        if(root==null) return;
        sum+=root.val;
        dfs(root.left);
        dfs(root.right);
    }
    public long solve(TreeNode root){
        if(root==null) return 0;
        long rSum=root.val+solve(root.left)+solve(root.right);
        ans=Math.max(ans,rSum*(sum-rSum));
        return rSum;
    }

    public static void main(String[] args) {
        MaximumProductOfSplittedBinaryTree sol = new MaximumProductOfSplittedBinaryTree();

        // Test case 1
        // Tree: [1,2,3,4,5,6]
        // Expected output: 110
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        root1.right.left = new TreeNode(6);

        System.out.println(sol.maxProduct(root1)); // 110

        // Reset object for next test
        sol = new MaximumProductOfSplittedBinaryTree();

        // Test case 2
        // Tree: [1,null,2,3,4,null,null,5,6]
        // Expected output: 90
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.left = new TreeNode(3);
        root2.right.right = new TreeNode(4);
        root2.right.left.left = new TreeNode(5);
        root2.right.left.right = new TreeNode(6);

        System.out.println(sol.maxProduct(root2)); // 90

        // Reset object for next test
        sol = new MaximumProductOfSplittedBinaryTree();

        // Test case 3
        // Tree: [2,1,3]
        // Expected output: 6
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(3);

        System.out.println(sol.maxProduct(root3)); // 9
    }


}
