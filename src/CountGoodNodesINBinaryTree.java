public class CountGoodNodesINBinaryTree {

    int count=0;
    public int goodNodes(TreeNode root) {
        count=0;
        dfs(root,root.val);
        return count;
    }

    public void dfs(TreeNode root,int maxSoFar){
        if(root==null)
            return;

        if(maxSoFar<=root.val){
            count++;
            maxSoFar=root.val;
        }
        dfs(root.left,maxSoFar);
        dfs(root.right,maxSoFar);

    }

    public static void main(String[] args) {
        // Test case 1: Tree: [3,1,4,3,null,1,5]
        TreeNode t1 = new TreeNode(3,
                new TreeNode(1, new TreeNode(3), null),
                new TreeNode(4, new TreeNode(1), new TreeNode(5))
        );
        CountGoodNodesINBinaryTree solution = new CountGoodNodesINBinaryTree();
        System.out.println(solution.goodNodes(t1)); // Expected: 4

        // Test case 2: Tree: [3,3,null,4,2]
        TreeNode t2 = new TreeNode(3,
                new TreeNode(3, new TreeNode(4), new TreeNode(2)),
                null
        );
        solution = new CountGoodNodesINBinaryTree();
        System.out.println(solution.goodNodes(t2)); // Expected: 3

        // Test case 3: Single node tree: [1]
        TreeNode t3 = new TreeNode(1);
        solution = new CountGoodNodesINBinaryTree();
        System.out.println(solution.goodNodes(t3)); // Expected: 1
    }

}
