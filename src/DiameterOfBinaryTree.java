class DiameterOfBinaryTree {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return maxDiameter;
    }

    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = depth(root.left);
        int right = depth(root.right);
        maxDiameter = Math.max(maxDiameter, left + right);
        return Math.max(left, right) + 1;
    }



public static void main(String[] args) {
        DiameterOfBinaryTree obj = new DiameterOfBinaryTree();

        // Test Case 1: Simple tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        root1.left.right = new TreeNode(5);
        printResult(obj, root1);

        // Test Case 2: Single node tree
        TreeNode root2 = new TreeNode(1);
        printResult(obj, root2);

        // Test Case 3: Skewed tree (all nodes on one side)
        TreeNode root3 = new TreeNode(1);
        root3.right = new TreeNode(2);
        root3.right.right = new TreeNode(3);
        root3.right.right.right = new TreeNode(4);
        printResult(obj, root3);
    }

    public static void printResult(DiameterOfBinaryTree obj, TreeNode root) {
        int res = obj.diameterOfBinaryTree(root);
        System.out.println("Diameter: " + res);
    }
}
