public class MaximumSumBST {
    int maximum = 0;

    public int maxSumBST(TreeNode root) {
        traverse(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return maximum;

    }



    public int traverse(TreeNode root, int min, int max) {
        if (root == null) {

            return 0;
        }
        int left=0,right=0;
        if (root.val <= min || root.val >= max ||
                (root.left != null && root.left.val >= root.val)
                || (root.right != null && root.right.val <= root.val)) {

            left=traverse(root.left, Integer.MIN_VALUE, Integer.MAX_VALUE);
            right=traverse(root.right, Integer.MIN_VALUE, Integer.MAX_VALUE);
        } else {

            left=traverse(root.left, min, root.val);
            right=traverse(root.right, root.val, max);
        }
        return root.val+left+right;

    }
    public static void main(String[] args) {
        MaximumSumBST sol = new MaximumSumBST();

        // Test case 1
        //       5
        //      / \
        //     2   8
        //        /
        //       6
        //      /
        //     4   <-- violates BST property since 4 < 5 but is in right subtree
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(8);
        root1.right.left = new TreeNode(6);
        root1.right.left.left = new TreeNode(4);
        System.out.println(sol.maxSumBST(root1)); // Expected output: 8 (best BST is subtree [2] or [6], not including 4)

        // Test case 2
        //       10
        //      /  \
        //     5    15
        //         /  \
        //        6    20
        // "6" is in right subtree of 10 but < 10 -> violates BST
        MaximumSumBST sol2 = new MaximumSumBST();
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(15);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(20);
        System.out.println(sol2.maxSumBST(root2)); // Expected output: 20 (subtree [15, null, 20])

        // Test case 3
        //       3
        //      / \
        //     2   5
        //        / \
        //       4   6
        //          /
        //         1  <-- violates BST since it's in right subtree of 3
        MaximumSumBST sol3 = new MaximumSumBST();
        TreeNode root3 = new TreeNode(3);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(5);
        root3.right.left = new TreeNode(4);
        root3.right.right = new TreeNode(6);
        root3.right.right.left = new TreeNode(1);
        System.out.println(sol3.maxSumBST(root3)); // Expected output: 11 (BST [5,4,6])
    }


}
