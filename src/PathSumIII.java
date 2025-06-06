import java.util.*;

public class PathSumIII {


    int count=0;

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> hashMap = new HashMap<>();
        hashMap.put(0L, 1); // base case

        dfs(root, hashMap, 0, targetSum);
        return count;
    }

    public void dfs(TreeNode root, HashMap<Long, Integer> hashMap, long currentSum, int targetSum) {
        if (root == null) {
            return;
        }
        long sum = currentSum + root.val;

        count += hashMap.getOrDefault(sum - targetSum, 0);

        hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);

        dfs(root.left, hashMap, sum, targetSum);
        dfs(root.right, hashMap, sum, targetSum);

        hashMap.put(sum, hashMap.get(sum) - 1); // backtrack
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        /*root.left.left = new TreeNode(294967296);
        root.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left = new TreeNode(1000000000);
        root.left.left.left.left.left = new TreeNode(1000000000);*/

        PathSumIII solver = new PathSumIII();
        System.out.println("Custom Test Case Result: " + solver.pathSum(root, 1));  // You can replace target sum here

        // Test Case 1
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(-3);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(2);
        root1.right.right = new TreeNode(11);
        root1.left.left.left = new TreeNode(3);
        root1.left.left.right = new TreeNode(-2);
        root1.left.right.right = new TreeNode(1);

        PathSumIII solver1 = new PathSumIII();
        System.out.println("Test Case 1 Result: " + solver1.pathSum(root1, 8));  // Expected: 3

        // Test Case 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(-2);
        root2.right = new TreeNode(-3);
        root2.left.left = new TreeNode(1);
        root2.left.right = new TreeNode(3);
        root2.right.left = new TreeNode(-2);
        root2.left.left.left = new TreeNode(-1);

        PathSumIII solver2 = new PathSumIII();
        System.out.println("Test Case 2 Result: " + solver2.pathSum(root2, -1));  // Expected: 4

        // Test Case 3
        TreeNode root3 = new TreeNode(1);
        PathSumIII solver3 = new PathSumIII();
        System.out.println("Test Case 3 Result: " + solver3.pathSum(root3, 1));  // Expected: 1
    }

}
