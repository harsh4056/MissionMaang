import com.sun.source.tree.Tree;

public class LongestZigZagPathInBinaryTree {
    int max = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root);
        return max;
    }

    // returns int[]{leftZig, rightZig}
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        int leftZig = 1 + l[1];
        int rightZig = 1 + r[0];

        max = Math.max(max, Math.max(leftZig, rightZig));
        return new int[]{leftZig, rightZig};
    }

    public static void main(String[] args) {
        // Test case 1: Tree: [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]
        TreeNode t1 = new TreeNode(1,
                null,
                new TreeNode(1,
                        new TreeNode(1,
                                new TreeNode(1, null, null),
                                new TreeNode(1,
                                        null,
                                        new TreeNode(1, null, new TreeNode(1))
                                )
                        ),
                        null
                )
        );
        LongestZigZagPathInBinaryTree solution = new LongestZigZagPathInBinaryTree();
        System.out.println(solution.longestZigZag(t1)); // Expected: 3

        // Test case 2: Tree with just one node
        TreeNode t2 = new TreeNode(1);
        solution = new LongestZigZagPathInBinaryTree();
        System.out.println(solution.longestZigZag(t2)); // Expected: 0

        // Test case 3: Tree: [1,2,3,null,4,null,5]
        TreeNode t3 = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(4)),
                new TreeNode(3, null, new TreeNode(5))
        );
        solution = new LongestZigZagPathInBinaryTree();
        System.out.println(solution.longestZigZag(t3)); // Expected: 2
    }

}
