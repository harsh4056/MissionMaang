public class BinaryTreeMaximumPathSum {

    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    int max = Integer.MIN_VALUE;  // global variable to store the result



    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int leftPath = Math.max(0, left) + node.val;
        int rightPath = Math.max(0, right) + node.val;

        max = Math.max(max, leftPath + rightPath - node.val);

        return Math.max(leftPath, rightPath);
    }



    public static void main(String[] args) {
        BinaryTreeMaximumPathSum obj = new BinaryTreeMaximumPathSum();

        // Test case 1: Simple tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
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
