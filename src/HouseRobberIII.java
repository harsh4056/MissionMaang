public class HouseRobberIII {


    // Helper class to store both states at each node
    class Pair {
        int rob;
        int notRob;

        Pair(int rob, int notRob) {
            this.rob = rob;
            this.notRob = notRob;
        }
    }

    public int rob(TreeNode root) {
        Pair result = dfs(root);
        return Math.max(result.rob, result.notRob);
    }

    private Pair dfs(TreeNode node) {
        if (node == null) return new Pair(0, 0);

        Pair left = dfs(node.left);
        Pair right = dfs(node.right);

        int rob = node.val + left.notRob + right.notRob;
        int notRob = Math.max(left.rob, left.notRob) + Math.max(right.rob, right.notRob);

        return new Pair(rob, notRob);
    }

    public static void main(String[] args) {
        // Test Case 1
        HouseRobberIII robber1 = new HouseRobberIII();
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.right = new TreeNode(3);
        root1.right.right = new TreeNode(1);
        printRobbery(robber1, root1);

        // Test Case 2
        HouseRobberIII robber2 = new HouseRobberIII();
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(1);
        printRobbery(robber2, root2);

        // Test Case 3
        HouseRobberIII robber3 = new HouseRobberIII();
        TreeNode root3 = new TreeNode(2);
        root3.left = new TreeNode(1);
        root3.right = new TreeNode(3);
        root3.left.right = new TreeNode(4);
        printRobbery(robber3, root3);
    }

    public static void printRobbery(HouseRobberIII robber, TreeNode root) {
        int result = robber.rob(root);
        System.out.println("Max Robbery Amount: " + result);
    }

}
