public class LeafSimilarTrees {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        StringBuilder stringBuilder1= new StringBuilder();
        StringBuilder stringBuilder2= new StringBuilder();
        dfs(root1,stringBuilder1);
        dfs(root2,stringBuilder2);
        return stringBuilder1.compareTo(stringBuilder2) == 0;
    }

    public void dfs(TreeNode root,StringBuilder stringBuilder){
        if(root==null ){
            return;
        }
        if(root.left==null && root.right==null){
            stringBuilder.append(root.val);
            stringBuilder.append(',');
            return;
        }
        dfs(root.left,stringBuilder);
        dfs(root.right,stringBuilder);

    }

    public static void main(String[] args) {
        // Test case 1: Both trees have same leaf sequence: 6,7,4,9,8
        TreeNode r1 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))),
                new TreeNode(1, new TreeNode(9), new TreeNode(8))
        );
        TreeNode r2 = new TreeNode(3,
                new TreeNode(5, new TreeNode(6), new TreeNode(7)),
                new TreeNode(1, new TreeNode(4), new TreeNode(2, new TreeNode(9), new TreeNode(8)))
        );
        LeafSimilarTrees solution = new LeafSimilarTrees();
        System.out.println(solution.leafSimilar(r1, r2)); // Expected: true

        // Test case 2: Different leaf sequences
        TreeNode t1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode t2 = new TreeNode(1, new TreeNode(3), new TreeNode(2));
        solution = new LeafSimilarTrees();
        System.out.println(solution.leafSimilar(t1, t2)); // Expected: false

        // Test case 3: Both trees with single same leaf
        TreeNode s1 = new TreeNode(7);
        TreeNode s2 = new TreeNode(7);
        solution = new LeafSimilarTrees();
        System.out.println(solution.leafSimilar(s1, s2)); // Expected: true
    }

}
