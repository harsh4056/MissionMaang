public class BinaryTreeTilt {

        int tiltSum=0;
    public int findTilt(TreeNode root) {
        helper(root);
        return tiltSum;

    }
    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left);
        int right = helper(root.right);

        tiltSum += Math.abs(left - right);

        return root.val + left + right;
    }


    public static void main(String[] args) {
        // Test Case 1
        BinaryTreeTilt tree1 = new BinaryTreeTilt();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        printTilt(tree1, root1);

        // Test Case 2
        BinaryTreeTilt tree2 = new BinaryTreeTilt();
        TreeNode root2 = new TreeNode(4);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(9);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(5);
        root2.right.right = new TreeNode(7);
        printTilt(tree2, root2);

        // Test Case 3
        BinaryTreeTilt tree3 = new BinaryTreeTilt();
        TreeNode root3 = new TreeNode(21);
        root3.left = new TreeNode(7);
        root3.right = new TreeNode(14);
        root3.left.left = new TreeNode(1);
        root3.left.right = new TreeNode(1);
        root3.right.left = new TreeNode(2);
        root3.right.right = new TreeNode(2);
        printTilt(tree3, root3);
    }

    public static void printTilt(BinaryTreeTilt tree, TreeNode root) {
        int result = tree.findTilt(root);
        System.out.println("Total Tilt: " + result);
    }


}
